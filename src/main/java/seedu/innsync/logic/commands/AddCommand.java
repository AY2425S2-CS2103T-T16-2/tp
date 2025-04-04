package seedu.innsync.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_BOOKINGTAG;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_MEMO;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_REQUEST;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.innsync.commons.util.ToStringBuilder;
import seedu.innsync.logic.Messages;
import seedu.innsync.logic.commands.exceptions.CommandException;
import seedu.innsync.model.Model;
import seedu.innsync.model.person.Person;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + "[" + PREFIX_BOOKINGTAG + "BOOKING_TAG] "
            + "[" + PREFIX_TAG + "TAG] "
            + "[" + PREFIX_REQUEST + "REQUEST] "
            + "[" + PREFIX_MEMO + "MEMO]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "+65 98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_BOOKINGTAG + "Beach House from/2025-06-01 to/2025-06-10 "
            + PREFIX_TAG + "owes money "
            + PREFIX_MEMO + "Wants extra food";

    public static final String MESSAGE_SUCCESS = String.format(Messages.MESSAGE_COMMAND_SUCCESS,
            "Add", "%s has been added to the address book!");

    private final Person toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddCommand(Person person) {
        requireNonNull(person);
        toAdd = person;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPerson(toAdd)) {
            throw new CommandException(Messages.MESSAGE_DUPLICATE_PERSONS);
        }

        model.addPerson(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(toAdd)), toAdd);
    }

    @Override
    public boolean requireConfirmation() {
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddCommand)) {
            return false;
        }

        AddCommand otherAddCommand = (AddCommand) other;
        return toAdd.equals(otherAddCommand.toAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", toAdd)
                .toString();
    }
}
