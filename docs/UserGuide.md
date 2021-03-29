# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

{Give detailed description of each feature}

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


### Resetting the password: `reset`
Delete an email to the junk box or remove an email from junk box forever.

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

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Delete emails to junk box `delete INDEX`
* Archive emails `archive INDEX`
* Find emails by keywords `find KEYWORD`
* Reset the account's password `reset`


