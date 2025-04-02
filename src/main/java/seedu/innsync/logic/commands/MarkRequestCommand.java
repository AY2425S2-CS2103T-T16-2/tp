package seedu.innsync.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_REQUEST;
import static seedu.innsync.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.innsync.commons.core.index.Index;
import seedu.innsync.commons.util.ToStringBuilder;
import seedu.innsync.logic.Messages;
import seedu.innsync.logic.commands.exceptions.CommandException;
import seedu.innsync.model.Model;
import seedu.innsync.model.person.Person;
import seedu.innsync.model.request.Request;

/**
 * Adds a request to a specific person in the system.
 * The person is identified using their displayed index in the person list.
 */

public class MarkRequestCommand extends Command {

    public static final String COMMAND_WORD = "mark";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks a request of the contact identified by the index number"
            + "in the displayed person list as completed.\n"
            + "Parameters: INDEX (must be a positive integer) " + PREFIX_REQUEST + "REQUEST_INDEX\n"
            + "Example: " + COMMAND_WORD + " 1 " + PREFIX_REQUEST + "1";
    public static final String MESSAGE_SUCCESS = "Request successfully marked: %s";
    public static final String MESSAGE_FAILURE_INVALID_INDEX = "Invalid Request Index!\n"
            + "CAUSE: Request Index is out of range. There is no request indexed by this number.\n"
            + "COMMAND INFO: " + MESSAGE_USAGE;
    public static final String MESSAGE_FAILURE_ALREADY_MARKED = "The request '%s' is already marked!";
    private final Index index;
    private final Index requestIndex;

    /**
     * Creates a {@code RequestCommand} to add a request to the specified person.
     *
     * @param index The index of the person in the displayed person list.
     * @param requestIndex The index of the request in the displayed request list of the person.
     * @param request The set of requests to be added to the person.
     */
    public MarkRequestCommand(Index index, Index requestIndex) {
        requireNonNull(index);
        this.index = index;
        this.requestIndex = requestIndex;
    }

    /**
     * Executes the mark request command by marking the specified request
     * of the specified person as complete.
     *
     * @param model The model which contains the list of persons.
     * @return A {@code CommandResult} indicating the outcome of the command.
     * @throws CommandException If the specified index is invalid (out of bounds).
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getPersonList();
        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
        Person person = lastShownList.get(this.index.getZeroBased());
        List<Request> requests = person.getRequests();
        if (this.requestIndex.getOneBased() > requests.size()) {
            throw new CommandException(MESSAGE_FAILURE_INVALID_INDEX);
        }
        Request request = requests.get(this.requestIndex.getZeroBased());
        if (request.isCompleted()) {
            throw new CommandException(String.format(MESSAGE_FAILURE_ALREADY_MARKED,
                    request.getRequestName()));
        }
        Person editedPerson = createEditedPerson(model, person, request, requestIndex);
        model.setPerson(person, editedPerson);

        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_SUCCESS, request.getRequestName()), editedPerson);
    }

    private Person createEditedPerson(Model model, Person person, Request request, Index index) {
        Request markedRequest = new Request(request);
        markedRequest.markAsCompleted();
        markedRequest = model.getRequestElseCreate(markedRequest);
        Person editedPerson = new Person(person);
        editedPerson.removeRequest(request);
        editedPerson.addRequest(markedRequest, index.getZeroBased());
        return editedPerson;
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
        if (!(other instanceof MarkRequestCommand)) {
            return false;
        }
        MarkRequestCommand otherRequest = (MarkRequestCommand) other;
        return index.equals(otherRequest.index);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("index", index)
                .toString();
    }
}
