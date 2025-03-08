package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REMARK_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REMARK_BOB;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.Remark;

public class RemarkCommandTest {
    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }
    @Test
    public void execute_success() {
        final String remark = "Some remark";
        Person person = model.getFilteredPersonList().get(0);
        Person updatedPerson = new Person(person.getName(),
                person.getPhone(), person.getEmail(), person.getAddress(),
                new Remark(remark), person.getTags());
        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(person, updatedPerson);

        assertCommandSuccess(new RemarkCommand(INDEX_FIRST_PERSON, remark), model,
            String.format(RemarkCommand.MESSAGE_REMARK_SUCCESS, INDEX_FIRST_PERSON.getOneBased(),
            remark), expectedModel);
    }

    @Test
    public void equals() {
        final RemarkCommand standardCommand = new RemarkCommand(INDEX_FIRST_PERSON, VALID_REMARK_AMY);

        // same values -> returns true
        RemarkCommand commandWithSameValues = new RemarkCommand(INDEX_FIRST_PERSON, VALID_REMARK_AMY);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new RemarkCommand(INDEX_SECOND_PERSON, VALID_REMARK_AMY)));

        // different remark -> returns false
        assertFalse(standardCommand.equals(new RemarkCommand(INDEX_FIRST_PERSON, VALID_REMARK_BOB)));
    }
}
