---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# InnSync User Guide

InnSync is a **desktop app for managing contacts, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, InnSync can get your contact management tasks done faster than traditional GUI apps.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `17` or above installed on your Computer.<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

1. Download the latest `.jar` file from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for InnSync.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar innsync.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe p/+65 98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

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

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a person: `add`

Adds a person to the address book.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<box type="tip" seamless>

**Tip:** A person can have any number of tags (including 0)
</box>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

### Listing all starred persons : `liststar`

Shows a list of all starred persons in the address book.

Format: `liststar`

### Starring a person : `star`

Stars a person in the address book.

Format: `star INDEX`

### Unstar a person : `unstar`

Unstar a starred person in the address book.

Format: `unstar INDEX`

### Editing a person : `edit`

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
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.
*  `edit 2 n/Betsy Crower b/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing booking tags.

### Adding a booking tag : `addbt`

Adds a booking tag into the person in the address book.

Format: `addbt INDEX [KEYWORD] from/YYYY-MM-DD to/YYYY-MM-DD`

* Adds the booking tag to the person specified by 'INDEX'. The index refers to the index number shown in the displayed person LIST. The index **must be a positive integer**
* All the fields must be provided.
* The date format has to be exactly the same "YYYY-MM-DD".
* When adding a new booking tag the new booking tag will be appended to the previous booking tags if they exist.
* When adding a booking tag for a time interval that has already occurred for the person, it will be rejected.

Examples:
* `addbt 1 Hotel from/2025-10-10 to/2025-10-11` Adds the booking tag to the 1st person on the list.

### Locating persons: `find`

Allows users to search for a contact by their name, phone, address, email, tag, booking tag 

Format: `find [n/]KEYWORD [MORE_KEYWORDS] | p/PHONE [MORE_PHONES] | e/EMAIL [MORE_EMAILS] | a/ADDRESS [MORE_ADDRESS] | t/TAG [MORE_TAGS] | b/DATE [MORE_DATES]`

#### Search Modes:

| Prefix | Field       | Description                                  | Example                    |
|--------|-------------|----------------------------------------------|----------------------------|
| (none) or `n/` | Name        | Searches through contact names              | `find John` or `find n/John` |
| `p/`    | Phone       | Searches through phone numbers               | `find p/9123`              |
| `e/`    | Email       | Searches through email addresses             | `find e/@example.com`      |
| `a/`    | Address     | Searches through addresses                   | `find a/Clementi`          |
| `t/`    | Tag         | Searches through contact tags                | `find t/friend`            |
| `b/`    | Booking     | Searches for contacts with bookings that include the specified date(s) | `find b/2025-01-01` |

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


### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action     | Format, Examples
-----------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Add**    | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Addbt**  | `addbt INDEX <KEYWORD> from/YYYY-MM-DD to/YYYY-MM-DD` <br> e.g.. `addbt 1 Hotel from/2025-10-10 to/2025-10-11`
**Star**   | `star INDEX` <br> e.g., `star 1`
**Unstar** | `unstar INDEX` <br> e.g., `unstar 1`
**Liststar**| `liststar`
**Clear**  | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit**   | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find**   |`find KEYWORD [MORE_KEYWORDS]` or<br>`find n/NAME [MORE_NAMES]` or<br>`find p/PHONE [MORE_PHONES]` or<br>`find e/EMAIL [MORE_EMAILS]` or<br>`find a/ADDRESS [MORE_ADDRESSES]` or<br>`find t/TAG [MORE_TAGS]` or<br>`find b/DATE [MORE_DATES]`<br>e.g., `find James Jake` or `find p/9123` or `find b/2025-01-01`
**List**   | `list`
**Help**   | `help`
