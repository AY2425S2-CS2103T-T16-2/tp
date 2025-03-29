---
  layout: default.md
    title: "User Guide"
    pageNav: 3
---

# InnSync User Guide

## Welcome to the InnSync User Guide

Welcome to the **InnSync User Guide** – your essential companion for managing contacts and guest information
efficiently. Designed specifically for Airbnb owners.

In this comprehensive user guide, we will take you to experience a full journey with InnSync step by step.

--------------------------------------------------------------------------------------------------------------------

## Table of Contents

[1. Introduction](#1-introduction)
- [1.1 What is InnSync](#1-1-what-is-innsync)
- [1.2 User Proficiency and Expectations](#1-2-user-proficiency-and-expectations)
- [1.3 Why This Guide Matters](#1-3-why-this-guide-matters)

[2. How to use this User Guide](#2-how-to-use-this-user-guide)
- [2.1 Navigating the Document](#2-1-navigating-the-document)
- [2.2 Sections](#2-2-sections)

[3. Quick start](#3-quick-start)
- [3.1 Installation](#3-1-installation)
- [3.2 Graphical User Interface Layout](#3-2-graphical-user-interface-layout)
  - [3.2.1 User Interface Overview](#3-2-1-user-interface-overview)
  - [3.2.2 Additional UI Components](#3-2-2-other-ui-components)
- [3.3 How to use InnSync features](#3-3-how-to-use-innsync-features)
  - [3.3.1 Parameter Prefixes](#3-3-1-parameter-prefixes)
  - [3.3.2 Parameters](#3-3-2-parameters)
  - [3.3.3 Command Format](#3-3-3-command-format)

[4. Features](#4-features)
- [4.1 Command Summary](#4-0-command-summary)
- [4.2 Features related to person](#4-2-features-related-to-person)
  - [4.2.1 Adding a person](#4-2-1-adding-a-person-add)
  - [4.2.2 Editing a person](#4-2-2-editing-a-person--edit)
  - [4.2.3 Listing all persons](#4-2-3-listing-all-persons--list)
  - [4.2.4 Deleting a person](#4-2-4-deleting-a-person--delete)
- [4.3 Features related to star a person](#4-3-features-related-to-star-a-person)
  - [4.3.1 Star a person](#4-3-1-star-a-person--star)
  - [4.3.2 Unstar a person](#4-3-2-unstar-a-person--unstar)
  - [4.3.4 Listing all starred persons](#4-3-3-listing-all-starred-persons--liststar)
- [4.4 Features related to tag a person](#4-4-features-related-to-tag-a-person)
  - [4.4.1 Adding a booking tag](#4-4-1-adding-a-booking-tag--tag)
  - [4.4.2 Adding a tag](#4-4-2-adding-a-tag--tag)
  - [4.4.3 Untagging a booking tag](#4-4-3-untagging-a-booking-tag--untag)
  - [4.4.4 Untagging a tag](#4-4-4-untagging-a-tag--untag)
- [4.5 Features related to finding](#4-5-features-related-to-finding)
  - [4.5.1 Locating a person](#4-5-1-locating-persons-find)
- [4.6 General features](#4-6-general-features)
  - [4.6.1 Clearing all entries](#4-6-1-clearing-all-entries--clear)
  - [4.6.2 Exiting the program](#4-6-2-exiting-the-program--exit)
  - [4.6.3 Undoing the last change](#4-6-3-undoing-the-last-change--undo)
  - [4.6.4 Viewing help](#4-6-4-viewing-help--help)
- [4.7 Saving the data](#4-7-saving-the-data)
- [4.8 Editing the data file](#4-8-editing-the-data-file)

[5. FAQ](#5-faq)

[6. Known issues](#6-known-issues)

--------------------------------------------------------------------------------------------------------------------

## 1. Introduction

### 1.1 What is InnSync

InnSync is a desktop application designed specifically for managing contacts for AirBnB owners,
optimized for use via a Command Line Interface** (CLI) while still having the benefits of a
Graphical User Interface (GUI). If you can type fast, InnSync can get your contact management
tasks done faster than traditional GUI apps.

Key Features:
* Contact & Guest Management: Add, edit, and delete contacts with ease.
* Rapid Command Execution: Quickly execute commands using a straightforward CLI.
* Automatic Data Persistence: Your changes are saved automatically to ensure all guest details remain current.

### 1.2 User Proficiency and Expectations
* Technical Skills: InnSync is designed for users with basic command line experience and familiarity with
  file navigation.

* Efficiency: Built for Airbnb owners, the tool prioritizes quick, streamlined workflows to manage guest and
  contact information.

* User-Friendly: Whether you're new to command line tools or an experienced user, InnSync’s design caters
  to a broad range of technical proficiency.

### 1.3 Why This Guide Matters
This guide is crafted to help you fully leverage InnSync’s features. As an Airbnb owner, managing guest details
quickly and accurately is vital. This guide provides clear instructions, examples, and troubleshooting tips so
you can optimize your workflow and focus on delivering a great guest experience.

--------------------------------------------------------------------------------------------------------------------

## 2. How to use this User Guide
This section explains how to navigate the guide and locate the information you need.

### 2.1 Navigating the Document:
* __Table of Contents:__ Use the Table of Contents at the start to jump directly to sections relevant to your needs.
* __Section Organization:__ The guide is divided into clear sections such as Introduction, Quick Start, Features, FAQ, Known Issues, and Command Summary.

### 2.2 Sections:
* [Installation](#3-1-installation): Step-by-step setup instructions for InnSync.
* [Features](#4-features): Detailed breakdown of each command with usage examples.
* [FAQ & Known Issues](#5-faq): Solutions to common questions and troubleshooting tips.
* [Command Summary](#4-1-command-summary): A quick-reference table for all available commands.


<box type="info" seamless>
First-time users are strongly encouraged to read the Quick Start section before beginning to use InnSync.
</box>

--------------------------------------------------------------------------------------------------------------------

## 3. Quick start

### 3.1 Installation

1. Ensure you have Java `17` or above installed on your Computer.<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

2. Download the latest `.jar` file from [here](https://github.com/AY2425S2-CS2103T-T16-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for InnSync.

4. Open your command terminal, depending on what OS you use follow the instruction below.
  * Windows: Tutorial on how to open a terminal [here.](https://learn.microsoft.com/en-us/windows/terminal/faq)
  * MacOS:Tutorial on how to open a terminal [here.](https://support.apple.com/en-sg/guide/terminal/apd5265185d-f365-44cb-8b09-71a064a42125/mac)
  * Linux: Tutorial on how to open a terminal [here.](https://ubuntu.com/tutorials/command-line-for-beginners#1-overview)

5.  Navigate to the folder by using `cd` into the folder you put the jar file in, and use the `java -jar innsync.jar` command to run the application.<br>

6. A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

7. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

  * `list` : Lists all contacts.

  * `add n/John Doe p/+65 98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

  * `delete 3` : Deletes the 3rd contact shown in the current list.

  * `clear` : Deletes all contacts.

  * `exit` : Exits the app.

8. Refer to the [Features](#features) below for details of each command.

### 3.2 Graphical User Interface Layout:

#### 3.2.1 User Interface Overview:
![Ui](images/Ui.png)
- ADD LABEL, PLACEHOLDER
#### 3.2.2 Other UI Components:
- PLACEHOLDER

### 3.3 How to use InnSync features:
InnSync operates mainly through CLI commands. Before exploring to the specific features in details under
the feature section. Let's try to familiarize ourselves with the basic components and formats to execute a command.
> **Tip:** All the command words are case-sensitive!
>
> * `add` is different from `Add`

#### 3.3.1 Parameter Prefixes:

In InnSync, a parameter prefix acts as a delimiter for specifying different types of parameters in commands.
Here's a reference table for common parameter prefixes and their corresponding parameters:

| Parameter Prefix | Corresponding Parameter |
|------------------|-------------------------|
| `n/`             | `NAME`                  |
| `p/`             | `PHONE`                 |
| `e/`             | `EMAIL`                 |
| `a/`             | `ADDRESS`               |
| `m/`             | `MEMO`                  |
| `b/`             | `BOOKING_TAG`           |
| `t/`             | `TAG`                   |

#### 3.3.2 Parameters:

In InnSync, a parameter represents a placeholder where users input data.
Parameters typically follow immediately after their corresponding Parameter Prefixes.
Essentially they are to be supplied by the user.

**Note:** All user inputs including parameters will be trimmed (all leading and trailing whitespaces will be ignored).


| Parameter     | Parameter Prefix | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
|---------------|------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `NAME `       | `n/`             | Specifies the name of a guest. <br/><br/> **Requirements:** <ul><li>Names must contain only alphabetic characters and whitespace.</li><li>Names with only whitespace are not allowed.</li></ul>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| `PHONE`       | `p/`             | Specifies the phone number of a guest. <br/><br/> Requirements: <ul><li>Phone numbers should be in the format <code>+[COUNTRY_CODE] [NUMBER]</code>.</li><li>The country code must be valid.</li><li>The number should be at least 7 digits long and at most 15 digits long.</li></ul>                                                                                                                                                                                                                                                                                                                                                                                                  |
| `EMAIL`       | `e/`             | Specifies the email of a guest. <br/><br/> Requirements: <ul><li>Emails should be of the format <code>local-part@domain</code>.</li><li>The local-part should only contain alphanumeric characters and the following special characters (excluding the parentheses): <code>[SPECIAL_CHARACTERS]</code>, and must not start or end with a special character.</li><li>This is followed by an '@' and then a domain name made up of domain labels separated by periods.</li><li>The domain name must end with a domain label that is at least 2 characters long.</li><li>Each domain label must start and end with an alphanumeric character and may contain hyphens in between.</li></ul> |                                                                                                                                                    |
| `ADDRESS`     | `a/`             | Specifies the address of a guest. <br/><br/> Requirements: <ul><li>Addresses can take any values.</li><li>The address should not be blank.</li></ul>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| `MEMO`        | `m/`             | Specifies the memo of a guest. <br/><br/> Requirements: <ul><li>Memos can take any values.</li><li>Memos should not be null.</li></ul>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| `BOOKING_TAG` | `d/`             | Specifies the booking tag of a guest. <br/><br/> Requirements: <ul><li>Booking tags should be of the format <code>{property} from/{start-date} to/{end-date}</code>.</li><li>Start-date and end-date must be in the format <code>yyyy-MM-dd</code>.</li><li>The start-date should be before the end-date.</li></ul>                                                                                                                                                                                                                                                                                                                                                                     |
| `TAG `        | `t/`             | Specifies the tag name of a guest. <br/><br/> Requirements: <ul><li>Tag names should be alphanumeric.</li></ul>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |                                                                                                                                                                                                                                                                                                |
| `INDEX`       | Not Applicable   | Refers to the index number shown in the List Panel. <br/><br/> **Requirements:** <ul><li>Must be a positive integer.</li><li>The value must fall within the valid range.</li><li>A valid range represents the set of positive values starting from 1 to the number of guests within the list.</li><li>Example: If there are 10 guests in the list, the valid range will be from 1 to 10 (inclusive).</li></ul>                                                                                                                                                                                                                                                                          |

#### 3.3.3 Command Format:

To understand how a full command is interpreted, we will utilise the following example.

**Example:** `add n/NAME p/PHONE e/EMAIL a/ADDRESS [t/TAG]`
>**Tip:** You can add a guest without specifying a tag!

**Structure of Command:**<br>

|         | Component        | Description                                            |
|---------|------------------|--------------------------------------------------------|
| `add`   | Command          | Executes Add Command to add a guest.                   |
| `n/`    | Parameter Prefix | Unique prefix to distinguish `NAME` from other prefix. |
| `NAME`  | Parameter        | Represents placeholder for name of the guest.          |


**General Notes about InnSync:**<br>

> **A command can be categorized into three formats:**
> 1. `COMMAND` + `INDEX`
> 2. `COMMAND` + `PARAMETER_PREFIX` + `PARAMETER`
> 3. `COMMAND` + `INDEX` + `PARAMETER_PREFIX` + `PARAMETER`

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

--------------------------------------------------------------------------------------------------------------------

## 4. Features
## 4.1 Command Summary
| Action        | Format, Examples                                                                                                                                                                                                                                                                                                 |
|---------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**       | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/+82 22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`                                                                                                                                        |
| **Tag**       | `tag INDEX r/TAG` <br> e.g.. `tag 1 b/TAG`  or <br/> `tag INDEX b/<KEYWORD> from/YYYY-MM-DD to/YYYY-MM-DD` <br> e.g.. `tag 1 b/Hotel from/2025-10-10 to/2025-10-11`                                                                                                                                              |
| **Untag**     | `untag INDEX t/TAG` <br> e.g., `untag 1 t/TEST` or <br/> `untag INDEX b/{property} {from/} {to/}` <br> e.g., `untag 1 b/Hotel from/2025-10-10 to/2025-10-11`                                                                                                                                                     |
| **Memo**      | `memo INDEX m/MEMO` <br/> e.g., `memo 1 m/TEST`                                                                                                                                                                                                                                                                  |
| **Star**      | `star INDEX` <br> e.g., `star 1`                                                                                                                                                                                                                                                                                 |                                                                                                                                                                                                                                                               |
| **Unstar**    | `unstar INDEX` <br> e.g., `unstar 1`                                                                                                                                                                                                                                                                             |
| **Liststar**  | `liststar`                                                                                                                                                                                                                                                                                                       |
| **Clear**     | `clear`                                                                                                                                                                                                                                                                                                          |
| **Delete**    | `delete INDEX`<br> e.g., `delete 3`  <br/>                                                                                                                                                                                                                                                                       |
| **Edit**      | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`                                                                                                                                                                                      |
| **Find**      | `find KEYWORD [MORE_KEYWORDS]` or<br>`find n/NAME [MORE_NAMES]` or<br>`find p/PHONE [MORE_PHONES]` or<br>`find e/EMAIL [MORE_EMAILS]` or<br>`find a/ADDRESS [MORE_ADDRESSES]` or<br>`find t/TAG [MORE_TAGS]` or<br>`find b/DATE [MORE_DATES]`<br>e.g., `find James Jake` or `find p/9123` or `find b/2025-01-01` |
| **List**      | `list`                                                                                                                                                                                                                                                                                                           |
| **Undo**      | `undo`                                                                                                                                                                                                                                                                                                           |
| **Help**      | `help`                                                                                                                                                                                                                                                                                                           |                                                                                                                                                                                                                                                                                                     |

## 4.2 Features related to person

### 4.2.1 Adding a person: `add`

Adds a person to the address book.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<box type="tip" seamless>

**Tip:** A person can have any number of tags (including 0)
</box>

Examples:
* `add n/John Doe p/+65 98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/+65 1234567 t/criminal`

### 4.2.2 Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [b/BOOKING_TAG]…​ [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
  specifying any tags after it.
* You can remove all the person’s booking tags by typing `b/` without
  specifying any booking tags after it.

Examples:
*  `edit 1 p/+65 91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `+65 91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.
*  `edit 2 n/Betsy Crower b/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing booking tags.


### 4.2.3 Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

### 4.2.4 Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

## 4.3 Features related to star a person

### 4.3.1 Star a person : `star`

Stars a person in the address book.

Format: `star INDEX`

### 4.3.2 Unstar a person : `unstar`

Unstar a starred person in the address book.

Format: `unstar INDEX`

### 4.3.3 Listing all starred persons : `liststar`

Shows a list of all starred persons in the address book.

Format: `liststar`

## 4.4 Features related to tag a person

### 4.4.1 Adding a booking tag : `tag`

Adds a booking tag into the person in the address book.

Format: `tag INDEX b/{property} {from/yyyy-MM-dd} {to/yyyy-MM-dd}`

* Adds the booking tag to the person specified by 'INDEX'. The index refers to the index number shown in the displayed person LIST. The index **must be a positive integer**
* All the fields must be provided.
* The date format has to be exactly the same "yyyy-MM-dd".
* When adding a new booking tag the new booking tag will be appended to the previous booking tags if they exist.
* When adding a booking tag for a time interval that has already occurred for the person, it will be rejected.

Examples:
* `tag 1 b/Hotel from/2025-10-10 to/2025-10-11` Adds the booking tag to the 1st person on the list.

### 4.4.2 Adding a tag : `tag`

Adds a tag into the person in the address book.

Format: `tag INDEX t/TAG`

* Adds the tag to the person specified by 'INDEX'. The index refers to the index number shown in the displayed person LIST. The index **must be a positive integer**
* All the fields must be provided.
* When adding a tag the new tag will be appended to the previous tags if they exist.

Examples:
* `tag 1 t/friend` Adds the tag to the 1st person on the list.

### 4.4.3 Untagging a booking tag : `untag`

Removes a booking tag on the 1st person in the address book.

Format: `untag INDEX b/{property} {from/yyyy-MM-dd} {to/yyyy-MM-dd}`

* Removes a booking tag to the person specified by 'INDEX'. The index refers to the index number shown in the displayed person LIST. The index **must be a positive integer**
* All the fields must be provided.
* The date format has to be exactly the same "yyyy-MM-dd".
* When removing a booking tag the booking tag will be removed

Examples:
* `untag 1 b/Hotel from/2025-10-10 to/2025-10-11` Removes the booking tag with matching booking tag on the 1st person in the list.

### 4.4.4 Untagging a tag : `untag`

Removes a tag on the 1st person in the address book.

Format: `untag INDEX t/TAG`

* Removes a tag to the person specified by 'INDEX'. The index refers to the index number shown in the displayed person LIST. The index **must be a positive integer**
* All the fields must be provided.
* When removing a tag the matching tag will be removed

Examples:
* `untag 1 t/friend` Removes the tag with matching tag on the 1st person in the list.


## 4.5 Features related to finding

### 4.5.1 Locating persons: `find`

Allows users to search for a contact by their name, phone, address, email, tag, booking tag

Format: `find [n/]KEYWORD [MORE_KEYWORDS] | p/PHONE [MORE_PHONES] | e/EMAIL [MORE_EMAILS] | a/ADDRESS [MORE_ADDRESS] | t/TAG [MORE_TAGS] | b/DATE [MORE_DATES]`

#### Search Modes:

| Prefix           | Field       | Description                                                             | Example                        |
|------------------|-------------|-------------------------------------------------------------------------|--------------------------------|
| (none) or `n/`   | Name        | Searches through contact names                                          | `find John` or `find n/John`   |
| `p/`             | Phone       | Searches through phone numbers                                          | `find p/9123`                  |
| `e/`             | Email       | Searches through email addresses                                        | `find e/@example.com`          |
| `a/`             | Address     | Searches through addresses                                              | `find a/Clementi`              |
| `t/`             | Tag         | Searches through contact tags                                           | `find t/friend`                |
| `b/`             | Booking     | Searches for contacts with bookings that include the specified date(s)  | `find b/2025-01-01`            |

#### Search Behavior:

* **Case-insensitive** - Search is not affected by upper or lower case (e.g., `find john` matches `John Doe`)
* **Order-independent** - The order of keywords doesn't matter (e.g., `find Bo Hans` matches `Hans Bo`)
* **Partial matching** - Keywords are matched partially against fields (e.g., `find Jo` matches `John`)
* **Field-specific** - Only one search field type can be used per command
* **Multiple keywords** - Multiple search terms can be provided for any field type. Contacts matching any keyword will be returned (e.g., `find John Jane` returns contacts with either name)

#### Special Notes for Booking Searches:

* Dates must be in the `yyyy-MM-dd` format (e.g., `2025-01-01` for January 1, 2025)
* A contact is matched if the specified date falls within the booking's start and end dates
* Multiple dates can be specified to find contacts with bookings during any of those dates

#### Examples:

**Searching by name:**
* `find John` - Finds contacts with "John" in their name
* `find alex david` - Finds contacts with either "alex" or "david" in their name
  ![result for 'find alex david'](images/findAlexDavidResult.png)

**Searching by phone:**
* `find p/9123` - Finds contacts whose phone numbers contain "9123"
* `find p/8765 9123` - Finds contacts whose phone numbers contain either "8765" or "9123"

**Searching by email:**
* `find e/@example.com` - Finds contacts with email addresses containing "@example.com"
* `find e/gmail yahoo` - Finds contacts with email addresses containing either "gmail" or "yahoo"

**Searching by address:**
* `find a/Clementi` - Finds contacts with "Clementi" in their addresses
* `find a/Street Avenue` - Finds contacts with either "Street" or "Avenue" in their addresses

**Searching by tag:**
* `find t/friend` - Finds contacts tagged as "friend"
* `find t/colleague family` - Finds contacts tagged as either "colleague" or "family"

**Searching by booking date:**
* `find b/2024-12-25` - Finds contacts with bookings that include December 25, 2024
* `find b/2025-01-01 2025-02-14` - Finds contacts with bookings that include either January 1, 2025 or February 14, 2025

#### Common Errors and How to Resolve Them:

* **Invalid format**: Make sure to use the correct prefix for your search type
* **Invalid date format**: Booking dates must follow the `yyyy-MM-dd` format exactly
* **No matches found**: Try using shorter or more general keywords to widen your search
* **Invalid characters**: Make sure your search terms contain only valid characters for the search field

## 4.6 General features

### 4.6.1 Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### 4.6.2 Exiting the program : `exit`

Exits the program.

Format: `exit`

### 4.6.3 Undoing the last change : `undo`

Undoes the last modification to the addressbook, reverting it to its original state before the last modification.
Edit, add, delete, tag, untag, star, unstar, memo and undo are the moficiations which can be undone.

Format: `undo`

## 4.6.4 Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### 4.7 Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### 4.8 Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

--------------------------------------------------------------------------------------------------------------------

## 5. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## 6. Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.
