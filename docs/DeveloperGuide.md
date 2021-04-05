# MojoHr Developer Guide

## Design

### Architecture
![Architect class diagram](UML diagrams/OverviewClassDiagram.png)
The Architecture Diagram above gives an overview of the different components in the application. 
Details of the individual components are given below.  

Mojo class controls the overall logic for the application. 
It is responsible for 
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

The rest of the App consists of 4 components:
* Login: Links the user to their account.
* Email: Stores and manages the user's email.
* Utilities: Consists of Ui, Storage and Parser helper class. Ui interacts with the user. Storage reads data from, and writes data to the hard disk. Parser parse user's input into instructions that can be understood by the application.
* Command: In charge of executing the user's request.

For these four components,
* The Login component exposes its functionality through the LoginController class.
* The Email component exposes its functionality through the EmailManager class
* The Utilities component consists of Ui, Storage and Parser classes.
* The Command component exposes its functionality through different command classes that inherit from a base Command class.

**How the architecture components interact with each other**
![Architect sequence diagram](Sequence Diagrams/OverviewSequenceDiagram.png)
The Sequence Diagram above shows how the components interact with each other for a command.
1. `Mojo` uses the `LoginController` to get the user's userID and password.
2. `Mojo` sends the user's info to the `Storage`, which will retrieve the existing emails from hard disks.
3. `Mojo` updates the `EmailManager` with the retrieved emails
4. `Mojo` gets the user's input from `Ui`
5. `Mojo` sends the input to `Parser` which then return the respective `Command` class according to user's input
6. `Mojo` executes the command.

***Due to a limitation of PlantUML, the lifeline did not end at the end of the destroy marker**

### Utilities Component
The Utilities component contains the main classes that run the main functions of Mojo.

![Utility diagram](UML diagrams/Utilities.jpeg)

The Utilities Class Diagram given above shows how the classes in the Utilities component interact with each other and classes from other component.

The Utilities Component consists for 3 classes.

* `Parser`: Breaks down user input into relevant objects.
* `Storage`: Reads data from, and writes data to, the local disk.
* `Ui`: Handles the input and output of the application.


### Login Component
The login component consists of the classes that run the main functions of the Login user Interface
![Login Component Class Diagram](UML diagrams/LoginComponentClassDiagram.png)
The **Login Class Diagram** give above shows how the classes in the Login Component interact with each other

The Login Component consists of 5 components.
* <code> LoginController </code> The LoginController handles the login process and control logic of the login process.
* <code> LoginManager </code> The LoginManager provides the logic to verify the user login details
* <code> LoginUi </code> The LoginUi defines the display and gets input from the user. LoginUi extends the functionality of the Ui class
* <code> LoginInfo </code> The LoginInfo contains the atrributes and methods of each LoginInfo object from a particular user logging into MojoHR application
* <code> LoginInfoFileManager </code> The LoginInfoFileManager is responsible for the logic that handles the storage and retrieval of login information

### Email Component
The email component consists of classes that are involved with all the emails
![Email Component Class Diagram](UML diagrams/EmailClassDiagram.png)
The **Login Class Diagram** give above shows how the classes in the Email Component interact with each other

The Email Component consists of 8 components.
* <code> Email </code> is the parent class to the other email classes and contains all the information that is required in an email
* <code> Archive </code> inherits from Email
* <code> Deleted </code> inherits from Email
* <code> Draft </code> inherits from Email
* <code> Inbox </code> inherits from Email
* <code> Junk </code> inherits from Email
* <code> Sent </code> inherits from Email
* <code> EmailManager </code> is responsible for the logic of retrieving Emails as a whole

## Implementation

### ListCommand 
There are seven variations of the <code> list </code> command.
1. List by All email(s)
2. List by Archived email(s) 
3. List by Deleted email(s)
4. List by Draft(s) email(s) 
5. List by Inbox email(s)
6. List by Junk email(s)
7. List by Sent email(s)

The sequence diagram shows how the <code> list(type) </code> operation work. 
![ListCommand Sequence Diagram](Sequence Diagrams/ListCommand.png)

### TagCommand
`TagCommand` allows the user to tag a specific email with the a number of tags.
1. `TagCommand` first finds out which email the user chose to be tagged by searching through the listedEmailList for the index given.
2. `TagCommand` will list the available tags that the users will choose from by calling `printTag()` on `Ui`
3. `TagCommand` then pass the user's input to the `parser` to extract the index
4. `TagCommand` sets the tag to the email through `EmailManager`
5. `TagCommand` updates the hard disk through `Storage`.

The sequence diagram shows how the <code> list(type) </code> operation work.
![Tag Sequence Diagram](Sequence Diagrams/TagSequenceDiagram.png)

### ComposeCommand
When the `compose` command is entered, the software will prompt user to enter the necessary details and save them to draft.

The details needed are receiver email, subject and content. The time the draft was composed would be saved automatically.

The sequence diagram roughly shows how the `compose` operation works.
![ComposeCommand Sequence Diagram](Sequence Diagrams/ComposeCommand.png)


## Product scope

### Target user profile

{Describe the target user profile}

### Value proposition

The HR department receives many emails from job seekers. 
A large portion of their day is spent clearing emails. Thus, our product seeks to allow the user to clear emails more efficiently by streamlining the process. This will reduce the time spent on clearing emails.
and allow HR personnel to focus on more productive things
(from clearing emails to classifying important emails).

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

### Performance and scalability

* Constraint: Multi-User
  
The product allows user to choose to login to different accounts upon start up of software

* Constraint: Typing-Preferred

The software is targeted for user who prefers typing as means of input

### Portability and compatibility

* Constraint: Platform-Independent

The software is runnable on the Windows, Linux, and OS-X platforms.

* Constraint: Java-Version

The software is written and tested in Java 11.

### Reliability, availability, maintainability

### Security

 * Constraint: Non-editable Local Storage File

The local storage file cannot be modified by user directly.

### Usability

## Glossary

* *glossary item* - Definition

## Instructions for manual testing
{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

### Logging into system 

#### 1. Login
##### Test case 1.0 : When correct login information is provided
Logs into the system when correct email address and password is provided by the user

**Test case**:

Enter choice: `1`

Enter email address: `12312@gmail.com`

Enter password: `5678`

Expected:
```` Hello! I'm MojoHR
  _________   _____   _____   _____
 |  _   _  | |  _  | |_   _| |  _  |
 | | | | | | | | | |   | |   | | | |
 | | | | | | | |_| |  _| |   | |_| |
 |_| |_| |_| |_____| |___|   |_____|
 What can I do for you?
 > Use the keyword "LIST (type) " to print the emails by types
 > Use the keyword "READ (index) " to open the selected email
 > Use the keyword "COMPOSE " to create a draft email
 > Use the keyword "SEND (index of draft) " to send email in the draft folder
 > Use the keyword "DELETE (index) " to delete the selected email
 > Use the keyword "FIND (keyword) " to find the  email by keywords
 > Use the keyword "ARCHIVE (index) " to move the selected email to the archive folder
 > Use the keyword "TAG (index)" to select the email for tagging labels
 > Use the keyword "RESET" to reset the your account password
 > Use the keyword "HELP" to print the menu
 > Use the keyword "BYE" to exit
 ____________________________________________________________
 Enter Command: 
````
##### Test case 1.1: When wrong login information is provided
When wrong email address and password is provided by the user

**Test case**

Enter choice: `1`

Enter email address: `abc`

Enter password: `000`

Expected: 
```
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 Error Message: 
 Wrong UserID and/or Password. Please try again!
 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
```

#### 2. Register New User
##### Test case 2.0: Correctly registers a user
Registers a new user, when the formatting provided is correct

**Test case:**

Enter choice: 2

Enter email address: `mary@gmail.com`

Enter password: `1234`

Expected:
```` Hello! I'm MojoHR
  _________   _____   _____   _____
 |  _   _  | |  _  | |_   _| |  _  |
 | | | | | | | | | |   | |   | | | |
 | | | | | | | |_| |  _| |   | |_| |
 |_| |_| |_| |_____| |___|   |_____|
 What can I do for you?
 > Use the keyword "LIST (type) " to print the emails by types
 > Use the keyword "READ (index) " to open the selected email
 > Use the keyword "COMPOSE " to create a draft email
 > Use the keyword "SEND (index of draft) " to send email in the draft folder
 > Use the keyword "DELETE (index) " to delete the selected email
 > Use the keyword "FIND (keyword) " to find the  email by keywords
 > Use the keyword "ARCHIVE (index) " to move the selected email to the archive folder
 > Use the keyword "TAG (index)" to select the email for tagging labels
 > Use the keyword "RESET" to reset the your account password
 > Use the keyword "HELP" to print the menu
 > Use the keyword "BYE" to exit
 ____________________________________________________________
 Enter Command: 
````

##### Test case 2.1: Incorrect Registration Format provided by a User
Error message shown, when the formatting provided is not correct

**Test case**

Enter choice: `2`

Enter email address: `hi`

Enter password: `1234`

Expected
````
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Error Message: 
Please enter a valid email address! 
Email address must have "@" and cannot have empty string in front or behind
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
````

#### 3. Exits Application
##### Test case 3.0: Allow the user to exit the system
When the correct choice format is chosen, user will be able to exit the system

**Test case**

Enter choice: 3

Expected:
```
Logging off... Hope to see you again in MojoHr!
```

#### Test case 3.1: Incorrect Choice Format
When an incorrect format of choice is shown, error message will be displayed

Enter choice: `three`

Expected:
```
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Error Message: 
You need to enter an integer! Please try again!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
```


### Finding emails by keyword
Print all emails that contains the keyword, and if there is no email contains the keyword, outputs `No matching emails found.`

Test case: `find subject 10`

Expected: 
````
1. [Deleted][UNREAD]
|| Subject: This is subject 10
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T15:30:00
|| Tags: []
````

Test case: `find school`

Expected: `No matching emails found.`


##Resetting the password
Reset the password for the user's email account.
The program will ask for the old password from user. 

If the old password is correct, the program will ask for the new password from user and outputs`Your password has changed successfully!`

The number of wrong attempt is 3. 
If the old password is wrong for 3 times, the program will output `Sorry your old password is wrong. Please try again!(0 times left!)` and back to main menu.

###Test case 1: Typing wrong old password for 3 times

Input: `reset`

Expected: `Please enter your old password:`

Input: `12312`

Expected: `Sorry your old password is wrong. Please try again!(2 times left!)`

Input: `12222`

Expected: `Sorry your old password is wrong. Please try again!(1 times left!)`

Input: `12223`

Expected: `Sorry your old password is wrong. Please try again!(0 times left!)`

###Test case 2: Typing old password correctly

Input: `reset`

Expected: `Please enter your old password:`

Input: `5678`

Expected: `Please enter your new password:`

Input: `1234`

Expected: `Your password has changed successfully!`

Then, you can exit the program and use the new password to login.

##Compose an email
Compose an email for the user which will be saved into draft upon completion.

The program will ask for Receiver, Subject and Content whereas draft time will be saved automatically

Input: `compose`

Expected:
```
Please enter the details below in the correct order  
To:
Subject:
Content:
You can send to multiple recipents by appending emails with ;
e.g: Alice@gmail.com;Bob@gmail.com
```

Input: 
```
testing@gmail.com
testSubject
Dear Sir,

This is a test content.

regards,
user
/end
```

Expected: `Email saved to draft at 2021-04-01T13:00:00`

The email is saved in draft and ready to be sent.


