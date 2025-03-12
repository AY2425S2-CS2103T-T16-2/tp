package seedu.innsync.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.innsync.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tag in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidDateTagName(String)}
 */
public class DateTag {

    public static final String MESSAGE_CONSTRAINTS = "Tags names should be alphanumeric";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";

    public final String dateTagName;

    /**
     * Constructs a {@code Tag}.
     *
     * @param dateTagName A valid tag name.
     */
    public DateTag(String dateTagName) {
        requireNonNull(dateTagName);
        checkArgument(isValidDateTagName(dateTagName), MESSAGE_CONSTRAINTS);
        this.dateTagName = dateTagName;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidDateTagName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Tag)) {
            return false;
        }

        DateTag otherDateTag = (DateTag) other;
        return dateTagName.equals(otherDateTag.dateTagName);
    }

    @Override
    public int hashCode() {
        return dateTagName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + dateTagName + ']';
    }

}
