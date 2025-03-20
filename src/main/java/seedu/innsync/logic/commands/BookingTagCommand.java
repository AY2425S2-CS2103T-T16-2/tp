package seedu.innsync.logic.commands;

import static seedu.innsync.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.innsync.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.innsync.commons.core.index.Index;
import seedu.innsync.commons.util.ToStringBuilder;
import seedu.innsync.logic.Messages;
import seedu.innsync.logic.commands.exceptions.CommandException;
import seedu.innsync.model.Model;
import seedu.innsync.model.person.Person;
import seedu.innsync.model.tag.BookingTag;




/**
 * Adds booking tag to a person to the address book.
 */
public class BookingTagCommand extends Command {

    public static final String COMMAND_WORD = "addbt";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a booking tag to the contact identified by the index number in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer) {property} from/{start-date} to/{end-date}\n"
            + "Example: " + COMMAND_WORD + " 1 b/BeachHouse from/2025-06-01 to/2025-06-10";
    public static final String MESSAGE_SUCCESS = "Booking tag successfully added: %s";
    public static final String MESSAGE_FAILURE = "Failed to add booking tag. "
            + "The booking tag %s overlaps with an existing tag.";
    private final Index index;
    private final BookingTag bookingTag;

    /**
     * Creates an BookingTagCommand to add the specified {@code index}
     */
    public BookingTagCommand(Index index, BookingTag bookingTag) {
        requireAllNonNull(index, bookingTag);
        this.index = index;
        this.bookingTag = bookingTag;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getPersonList();
        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(this.index.getZeroBased());
        Person editedPerson = addBookingTagPerson(personToEdit, bookingTag);
        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(editedPerson)));
    }

    private Person addBookingTagPerson(Person personToCopy, BookingTag bookingTag) throws CommandException {
        Set<BookingTag> updatedBookingTags = new HashSet<>(personToCopy.getBookingTags());
        for (BookingTag existingTag : updatedBookingTags) {
            if (isOverlapping(existingTag, bookingTag)) {
                throw new CommandException(String.format(MESSAGE_FAILURE, bookingTag.toPrettier()));
            }
        }
        updatedBookingTags.add(bookingTag);
        return new Person(
                personToCopy.getName(),
                personToCopy.getPhone(),
                personToCopy.getEmail(),
                personToCopy.getAddress(),
                updatedBookingTags,
                personToCopy.getTags(),
                personToCopy.getStarred()
        );
    }

    /**
     * Helper method to check if two booking tags overlap
     */
    private boolean isOverlapping(BookingTag tag1, BookingTag tag2) {
        return !(tag1.endDate.isBefore(tag2.startDate) || tag2.endDate.isBefore(tag1.startDate));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof BookingTagCommand)) {
            return false;
        }

        BookingTagCommand otherBookingTag = (BookingTagCommand) other;
        return index.equals(otherBookingTag.index);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("index", index)
                .toString();
    }
}
