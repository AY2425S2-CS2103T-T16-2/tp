package seedu.innsync.model.person;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDateTag(String)}
 */
public class DateTag {

    public static final String MESSAGE_CONSTRAINTS = "Invalid date tag format. DateTag can only contain numbers"
            + " characters in the format YYYY-MM-DD.\n";

    /*
     *
     *
     */
    public static final String VALIDATION_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

    public final String value;

    /**
     * Constructs an {@code Address}.
     *
     * @param dateTag A valid address.
     */
    public DateTag(String dateTag) {
//        checkArgument(isValidDateTag(dateTag), MESSAGE_CONSTRAINTS);
        value = dateTag;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidDateTag(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Address)) {
            return false;
        }

        DateTag otherAddress = (DateTag) other;
        return value.equals(otherAddress.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
