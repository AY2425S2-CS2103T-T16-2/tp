package seedu.innsync.logic.commands;

import static seedu.innsync.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_TAG;
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
import seedu.innsync.model.tag.Tag;

/**
 * Adds a tag into a person to the address book.
 */
public class TagCommand extends Command {

    public static final String COMMAND_WORD = "addtag";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds tag to the contact identified by the index number in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_TAG + "TAG\n"
            + "Example: " + COMMAND_WORD + " 1 t/friend";
    public static final String MESSAGE_SUCCESS = "Tag successfully added: %s";
    private final Index index;
    private final Tag tag;

    /**
     * Creates an TagCommand to add the specified {@code index}
     */
    public TagCommand(Index index, Tag tag) {
        requireAllNonNull(index, tag);
        this.index = index;
        this.tag = tag;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getPersonList();
        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(this.index.getZeroBased());
        Person editedPerson = addTagPerson(personToEdit, tag);
        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(editedPerson)));
    }

    private Person addTagPerson(Person personToCopy, Tag tag) {
        Set<Tag> updatedTags = new HashSet<>(personToCopy.getTags());
        updatedTags.add(tag);
        return new Person(
                personToCopy.getName(),
                personToCopy.getPhone(),
                personToCopy.getEmail(),
                personToCopy.getAddress(),
                personToCopy.getBookingTags(),
                updatedTags,
                personToCopy.getStarred()
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TagCommand)) {
            return false;
        }

        TagCommand otherTag = (TagCommand) other;
        return index.equals(otherTag.index);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("index", index)
                .toString();
    }
}
