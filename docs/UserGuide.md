# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Login Features
### Log in to main application: `1`

Format
`1`

Enter email address: `12312@gmail.com`

Enter password: `5678`

Example of usage:
```
 _________   _____   _____   _____
|  _   _  | |  _  | |_   _| |  _  |
| | | | | | | | | |   | |   | | | |
| | | | | | | |_| |  _| |   | |_| |
|_| |_| |_| |_____| |___|   |_____|

Select either 1 or 2 or 3 (use numbers): 
[Emails address are case sensitive!]
1. Log In 
2. Create a new account
3. Exit
Enter choice:
1
Enter email address:
12312@gmail.com
Enter password:
5678
```
### Register as a new user: `2`
Format
`2`

Enter email address: `joey@gmail.com`

Enter password: `joey987`

Example of usage:
```
 _________   _____   _____   _____
|  _   _  | |  _  | |_   _| |  _  |
| | | | | | | | | |   | |   | | | |
| | | | | | | |_| |  _| |   | |_| |
|_| |_| |_| |_____| |___|   |_____|

Select either 1 or 2 or 3 (use numbers): 
[Emails address are case sensitive!]
1. Log In 
2. Create a new account
3. Exit
Enter choice: 
2
Enter email address:
joey@gmail.com
Enter password:
joey987
```
### Exit Application before log in: `3`
Format
`3`

Example of usage:
```
 _________   _____   _____   _____
|  _   _  | |  _  | |_   _| |  _  |
| | | | | | | | | |   | |   | | | |
| | | | | | | |_| |  _| |   | |_| |
|_| |_| |_| |_____| |___|   |_____|

Select either 1 or 2 or 3 (use numbers): 
[Emails address are case sensitive!]
1. Log In 
2. Create a new account
3. Exit
Enter choice: 
3
Logging off... Hope to see you again in MojoHr!

```

## Within Application Features 
{Give detailed description of each feature}


### listing an email: `list`
list different types of emails

Format: `list TYPE`
* The `TYPE` refers to the type of emails they you want to display
* `TYPES` are limited to `list emails`, `list inbox`, `list archive`, `list deleted`, `list draft`, `list junk`, `list sent`

Example of usage
```____________________________________________________________
Enter Command:
list draft
____________________________________________________________
1. [Draft][UNREAD]
|| Subject: This is subject 3
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T08:30:00
|| Tags: []
2. [Draft][UNREAD]
|| Subject: LilySubject
|| From: 12312@gmail.com --> To: [lily@gmail.com]
|| Time: 2021-03-30T20:15:06
|| Tags: []
3. [Draft][UNREAD]
|| Subject: testing
|| From: 12312@gmail.com --> To: [lolita@gmail.com, lolota@gmail.com]
|| Time: 2021-03-30T22:48:58
|| Tags: []
____________________________________________________________
```

### opening an email: `read`
opens an email 

Format: `read INDEX`

* The `INDEX` refers to the index number shown in the displayed email list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …

Example of usage:
````
____________________________________________________________
Enter Command:
list inbox
____________________________________________________________
1. [Inbox][UNREAD]
   || Subject: This is subject 1
   || From: 21312@gmail.com --> To: [12312@gmail.com]
   || Time: 2021-02-20T06:30:00
   || Tags: [Important, Work]
____________________________________________________________
Enter Command:
read 1
____________________________________________________________
[Inbox][READ]
|| Subject: This is subject 1
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T06:30:00
|| Tags: [Important, Work]
|| Content: Welcome to MOJO HR.
____________________________________________________________
````

### Deleting an email: `delete`
Delete an email to the junk box or remove an email from junk box forever.

Format: `delete INDEX`

* The `INDEX` refers to the index number shown in the displayed email list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …

* If the displayed email list if not junk emails, move the email at the specified `INDEX` to the junk box. 
* If the displayed email list is junk emails, remove the email at the specified `INDEX` from the account forever.


Example of usage: 
````
____________________________________________________________
Enter Command:
list inbox
____________________________________________________________
1. [Inbox][UNREAD]
|| Subject: This is subject 1
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T06:30:00
|| Tags: []
2. [Inbox][UNREAD]
|| Subject: This is subject 2
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T07:30:00
|| Tags: []
____________________________________________________________
Enter Command:
delete 2
____________________________________________________________
Move this email to deleted folder
____________________________________________________________
Enter Command:
list deleted
____________________________________________________________
1. [Deleted][UNREAD]
|| Subject: This is subject 2
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T07:30:00
|| Tags: []
____________________________________________________________
````
### Archiving an email: `archive`
Archive a not-archived email to the archive box.

Format: `archive INDEX`

* The `INDEX` refers to the index number shown in the displayed email list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …

* If the displayed email list if not archived emails, move the email at the specified `INDEX` to the archive box.
* If the displayed email list is archived emails, no action will be done.


Example of usage:

````
____________________________________________________________
Enter Command:
list inbox
____________________________________________________________
1. [Inbox][UNREAD]
|| Subject: This is subject 1
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T06:30:00
|| Tags: []
____________________________________________________________
Enter Command:
archive 1
____________________________________________________________
Move this email to archive folder
____________________________________________________________
Enter Command:
list archive
____________________________________________________________
1. [Archive][UNREAD]
|| Subject: This is subject 6
|| From: 11312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T11:30:00
|| Tags: []
2. [Archive][UNREAD]
|| Subject: This is subject 1
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T06:30:00
|| Tags: []
____________________________________________________________
````


### Finding an email: `find`
Find emails that contain a certain keyword.

Format: `find KEYWORD`

* The `KEYWORD` refers to the keyword that the email's subject or content should contain.
* The `KEYWORD` can be any non-empty string.
* The `KEYWORD` is case-ignored during the find.


Example of usage:
````
____________________________________________________________
Enter Command:
list deleted
____________________________________________________________
1. [Deleted][UNREAD]
|| Subject: This is subject 9
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T14:30:00
|| Tags: []
2. [Deleted][UNREAD]
|| Subject: This is subject 10
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T15:30:00
|| Tags: []
____________________________________________________________
Enter Command:
find 10
____________________________________________________________
1. [Deleted][UNREAD]
|| Subject: This is subject 10
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T15:30:00
|| Tags: []
____________________________________________________________
````

### tagging an email: `tag`
Tag an email with labels

Format: `tag INDEX`

* The `INDEX` refers to the index number shown in the displayed email list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …

Example of usage:
````
____________________________________________________________
Enter Command:
list inbox
____________________________________________________________
1. [Inbox][UNREAD]
|| Subject: This is subject 1
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T06:30:00
|| Tags: []
____________________________________________________________
Enter Command:
tag 1
____________________________________________________________
You have selected this email:
[Inbox][UNREAD]
|| Subject: This is subject 1
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T06:30:00
|| Tags: []
____________________________________________________________
These are the available tags: 
1. Important
2. Family
3. Friends
4. School
5. Work
6. Travels
Select the indices of the tag you want to add.
e.g. Type "1 2 6" to add the tags Important, Family, Travels
____________________________________________________________
tag 1 5
____________________________________________________________
You have successfully set the following tags [Important, Work]
____________________________________________________________
````

### composing an email: `compose`
Compose an email which will be saved to draft. The software will prompt user to enter the necessary details.

Format: `compose`

* The program will ask for receiver's email, email subject and content, and user should enter accordingly
* User must enter `/end` to signify that it is the end of content

Example of usage:
```
____________________________________________________________
Enter Command:
compose
____________________________________________________________
Please enter the details below in the correct order:
To:
Subject:
Content:
You can send to multiple recipents by appending emails with ";"
e.g: Alice@gmail.com;Bob@gmail.com
____________________________________________________________
test@gmail.com
testSubject
Dear Sir,

This is test content.

Regards,
user
/end
____________________________________________________________
Email saved to draft at 2021-04-02T18:50:14
____________________________________________________________
```

### sending an email: `send`
Sends an email from draft

Format: `send INDEX`

* The `INDEX` refers to the index number of email in the draft list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* User must `list draft` first before they can send an email

Example of usage:
```
____________________________________________________________
Enter Command:
list draft
____________________________________________________________
1. [Draft][UNREAD]
|| Subject: LilySubject
|| From: 12312@gmail.com --> To: [lily@gmail.com]
|| Time: 2021-03-30T20:15:06
|| Tags: []
2. [Draft][UNREAD]
|| Subject: testing
|| From: 12312@gmail.com --> To: [lolita@gmail.com, lolota@gmail.com]
|| Time: 2021-03-30T22:48:58
|| Tags: []
3. [Draft][UNREAD]
|| Subject: testSubject
|| From: 12312@gmail.com --> To: [test@gmail.com]
|| Time: 2021-04-02T18:50:14
|| Tags: []
4. [Draft][UNREAD]
|| Subject: 
|| From: 12312@gmail.com --> To: [no]
|| Time: 2021-04-02T18:51:07
|| Tags: []
____________________________________________________________
Enter Command:
send 4
____________________________________________________________
Email successfully sent to: [no] at 2021-04-02T19:02:12.724156500
____________________________________________________________
```

### Editing an email: `edit`
Edits an email in draft

Format: `edit INDEX`

* The `INDEX` refers to the index number of email in the draft list.
* The `INDEX` **must be a positive integer** 1, 2, 3, …
* User must `list draft` first before they can send an email
* The program will ask user if they want to edit the receiver's email, subject or content
* User should enter `to`, `subject`, or `content` when prompted and immediately enter the parts that the user wish to edit
* If user wants to edit content, remember to enter `/end` to signify that it is the end of content

Example of usage:
```
Enter Command:
list draft
____________________________________________________________
1. [Draft][UNREAD]
|| Subject: LilySubject
|| From: 12312@gmail.com --> To: [lily@gmail.com]
|| Time: 2021-03-30T20:15:06
|| Tags: []
2. [Draft][UNREAD]
|| Subject: testing
|| From: 12312@gmail.com --> To: [lolita@gmail.com, lolota@gmail.com]
|| Time: 2021-03-30T22:48:58
|| Tags: []
3. [Draft][UNREAD]
|| Subject: testSubject
|| From: 12312@gmail.com --> To: [test@gmail.com]
|| Time: 2021-04-02T18:50:14
|| Tags: []
____________________________________________________________
Enter Command:
edit 1
____________________________________________________________
What would you like to edit? It must be one of [to, subject, content].
to
test2@gmail.com
Email "to" successfully edited.
____________________________________________________________
```

### count number of email: `number`
Counts the number of a specific type of email

Format: `number TYPE`

* The `TYPE` refers to the types of email. 
* Example of `TYPE`: inbox, archive, deleted, draft, junk, sent, and emails. 'Emails' refer to all emails


Example of usage:
```
Enter Command:
number draft
____________________________________________________________
You have a total of 3 DRAFT emails
____________________________________________________________
```

### sorting an email: `sort`
Sorts email according to time or Lexicographic order of sender's email.

Format: `sort TYPE`

* The `TYPE` refers to the types of sorting methods.
* Types of sorting methods: sender, time

Example of usage:
```
Enter Command:
sort time
____________________________________________________________
Emails are sorted according to time
____________________________________________________________
Enter Command:
list archive
____________________________________________________________
1. [Archive][UNREAD]
|| Subject: This is subject 4
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T09:30:00
|| Tags: []
2. [Archive][UNREAD]
|| Subject: This is subject 5
|| From: 21312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T10:30:00
|| Tags: []
3. [Archive][UNREAD]
|| Subject: This is subject 6
|| From: 11312@gmail.com --> To: [12312@gmail.com]
|| Time: 2021-02-20T11:30:00
|| Tags: []
____________________________________________________________
```

### Resetting the password: `reset`
Reset the password for the user's email account.

Format: `reset`

* The program will aks for the old password from user.
* If the old password is correct, the program will ask for the new  password from user.
* The number of wrong attempt is 3.
* If the old password is wrong for 3 times, the program will back to main menu asking for command.



Example of usage:
```
____________________________________________________________
Enter Command:
reset
____________________________________________________________
Please enter your old password:
12312
Sorry your old password is wrong. Please try again!(2 times left!)
____________________________________________________________
Please enter your old password:
5678
Please enter your new password:
12315
Your password has changed successfully!
____________________________________________________________

```

### Printing the help menu: `help`
Displays the list of commands and how to use them

Format: `help`

Example of usage:
```
____________________________________________________________
Enter Command:
help
____________________________________________________________
Hello! I'm MojoHR
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
```

### Exiting the application: `bye`
Exits the application

Format: `bye`

Example of usage: 

```
____________________________________________________________
Enter Command:
bye 
____________________________________________________________
Logging off... Hope to see you again in MojoHr!

```

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}
* List emails by types `list TYPE`
* Delete emails to junk box `delete INDEX`
* Archive emails `archive INDEX`
* Find emails by keywords `find KEYWORD`
* Reset the account's password `reset`
* Print help menu `help`
* Exit application `bye`


