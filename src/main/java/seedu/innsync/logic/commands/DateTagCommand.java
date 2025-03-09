package seedu.innsync.logic.commands;

import static seedu.innsync.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.innsync.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;
import seedu.innsync.commons.core.index.Index;
import seedu.innsync.logic.Messages;
import seedu.innsync.logic.commands.exceptions.CommandException;
import seedu.innsync.model.Model;
import seedu.innsync.model.person.DateTag;
import seedu.innsync.model.person.Person;


/**
 * Tag a person with date identified using it's displayed index from the address book.
 */
public class DateTagCommand extends Command {

    public static final String COMMAND_WORD = "tag";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Allows users to add date-specific tags to contacts.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1 d/2025-02-21";

    public static final String MESSAGE_DATETAG_PERSON_SUCCESS = "Date Tag '2025-02-21' added to contact: Jane Doe";

    private final Index index;
    private final DateTag dateTag;

    /**
     * @param index of the person in the filtered person list to edit the remark
     * @param dateTag of the person to be updated to
     */
    public DateTagCommand(Index index, DateTag dateTag) {
        requireAllNonNull(index, dateTag);

        this.index = index;
        this.dateTag = dateTag;
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Person editedPerson = new Person(personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), dateTag, personToEdit.getTags());

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        return new CommandResult(generateSuccessMessage(editedPerson));
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Person personToEdit) {
        String message = !dateTag.value.isEmpty() ? MESSAGE_DATETAG_PERSON_SUCCESS : MESSAGE_DATETAG_PERSON_SUCCESS;
        return String.format(message, personToEdit);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DateTagCommand)) {
            return false;
        }

        // state check
        DateTagCommand e = (DateTagCommand) other;
        return index.equals(e.index)
                && dateTag.equals(e.dateTag);
    }
}
