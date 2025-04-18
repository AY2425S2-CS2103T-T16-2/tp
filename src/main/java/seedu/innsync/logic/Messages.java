package seedu.innsync.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.innsync.logic.parser.Prefix;
import seedu.innsync.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {
    // Command messages
    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command! " + Emoticons.SAD;
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! " + Emoticons.ANGRY + "\n%s";

    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid! "
            + Emoticons.ANGRY;
    public static final String MESSAGE_INVALID_ITEM_INDEX = "This contact does not have a %s of this index! "
            + Emoticons.SAD;
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed! " + Emoticons.PROUD;

    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s)! " + Emoticons.ANGRY;
    public static final String MESSAGE_DUPLICATE_PERSONS = "This person already exists in the address book! "
            + "To add or edit a contact, it must have a unique email address and phone number. " + Emoticons.SAD;

    public static final String MESSAGE_COMMAND_SUCCESS = "%s successful! " + Emoticons.PROUD + "\n%s";
    public static final String MESSAGE_COMMAND_FAILURE = "%s failed! " + Emoticons.SAD + "\n%s";
    public static final String MESSAGE_COMMAND_CANCEL = "Command cancelled! " + Emoticons.PROUD;

    public static final String MESSAGE_PARSE_EXCEPTION = "%s " + Emoticons.ANGRY + "\n%s";

    // Object messages
    public static final String MESSAGE_EMPTY_FIELD = "%s cannot be empty!";
    public static final String MESSAGE_MAX_LENGTH_EXCEEDED = "%s exceeds maximum length of %d characters!";
    public static final String MESSAGE_INVALID_FIELD = "%s is invalid!";
    public static final String MESSAGE_DUPLICATE_FIELD = "Command will result in duplicate %s!";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append("; Phone: ")
                .append(person.getPhone())
                .append("; Email: ")
                .append(person.getEmail())
                .append("; Address: ")
                .append(person.getAddress())
                .append("; Memo: ")
                .append(person.getMemo())
                .append("; Requests: ");
        person.getRequests().forEach(builder::append);
        builder.append("; BookingTags: ");
        person.getBookingTags().forEach(builder::append);
        builder.append("; Tags: ");
        person.getTags().forEach(builder::append);
        builder.append("; Starred: ").append(person.getStarred());
        return builder.toString();
    }

}
