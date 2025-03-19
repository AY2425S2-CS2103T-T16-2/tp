package seedu.innsync.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.innsync.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.innsync.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.innsync.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.innsync.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.innsync.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.innsync.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.innsync.commons.core.index.Index;
import seedu.innsync.logic.Messages;
import seedu.innsync.model.AddressBook;
import seedu.innsync.model.Model;
import seedu.innsync.model.ModelManager;
import seedu.innsync.model.UserPrefs;
import seedu.innsync.model.person.Person;
import seedu.innsync.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code UnstarCommand}.
 */
public class UnstarCommandTest {

    private final Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        // First star the person to be able to unstar later
        Person personToUnstar = model.getPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person starredPerson = new PersonBuilder(personToUnstar).withStarred(true).build();
        model.setPerson(personToUnstar, starredPerson);

        // Now unstar the person
        Person personToUnstarNow = model.getPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person expectedPerson = new PersonBuilder(personToUnstarNow).withStarred(false).build();
        UnstarCommand unstarCommand = new UnstarCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(UnstarCommand.MESSAGE_SUCCESS,
                Messages.format(personToUnstarNow));

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(personToUnstarNow, expectedPerson);

        assertCommandSuccess(unstarCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getPersonList().size() + 1);
        UnstarCommand unstarCommand = new UnstarCommand(outOfBoundIndex);

        assertCommandFailure(unstarCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexUnstarredPerson_failure() {
        // Use a person that is not starred
        Model testModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        Person personToUnstar = testModel.getPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        // Ensure the person is not starred
        Person unstarredPerson = new PersonBuilder(personToUnstar).withStarred(false).build();
        testModel.setPerson(personToUnstar, unstarredPerson);

        UnstarCommand unstarCommand = new UnstarCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(UnstarCommand.MESSAGE_FAILURE,
                Messages.format(unstarredPerson));
        assertCommandFailure(unstarCommand, testModel, expectedMessage);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);

        Index outOfBoundIndex = INDEX_SECOND_PERSON;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getPersonList().size());

        UnstarCommand unstarCommand = new UnstarCommand(outOfBoundIndex);

        assertCommandFailure(unstarCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        UnstarCommand unstarFirstCommand = new UnstarCommand(INDEX_FIRST_PERSON);
        UnstarCommand unstarSecondCommand = new UnstarCommand(INDEX_SECOND_PERSON);

        // same object -> returns true
        assertTrue(unstarFirstCommand.equals(unstarFirstCommand));

        // same values -> returns true
        UnstarCommand unstarFirstCommandCopy = new UnstarCommand(INDEX_FIRST_PERSON);
        assertTrue(unstarFirstCommand.equals(unstarFirstCommandCopy));

        // different types -> returns false
        assertFalse(unstarFirstCommand.equals(1));

        // null -> returns false
        assertFalse(unstarFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(unstarFirstCommand.equals(unstarSecondCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        UnstarCommand unstarCommand = new UnstarCommand(targetIndex);
        String expected = UnstarCommand.class.getCanonicalName() + "{index=" + targetIndex + "}";
        assertEquals(expected, unstarCommand.toString());
    }
}
