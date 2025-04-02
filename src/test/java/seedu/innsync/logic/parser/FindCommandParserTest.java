package seedu.innsync.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static seedu.innsync.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.innsync.logic.Messages.MESSAGE_PARSE_EXCEPTION;
import static seedu.innsync.logic.parser.CommandParserTestUtil.assertParseFailure;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import seedu.innsync.logic.Emoticons;
import seedu.innsync.logic.Messages;
import seedu.innsync.logic.commands.FindCommand;
import seedu.innsync.logic.commands.FindCommand.SearchType;
import seedu.innsync.logic.parser.exceptions.ParseException;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void validateArgsNotNull_nullArgs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> parser.parse(null));
    }

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_noValidSearchField_throwsParseException() {
        String errorMessage = "Invalid search field: 'x/'. Valid prefixes are: \n name: n/ \n phone: p/ \n email: e/ \n"
                        + "address: a/ \n tag: t/ \n memo: m/ \n booking date: bd/ \n booking property: bp/";
        assertParseFailure(parser, "  x/invalid  ", String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                    errorMessage, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_emptyKeywords_throwsParseException() {
        // Empty after prefix - check for correct error message from parser
        assertParseFailure(parser, "n/",
                "Please enter at least one keyword after n/ when searching by name. "
                + Emoticons.ANGRY + "\n" + FindCommand.MESSAGE_USAGE);
        assertParseFailure(parser, "p/",
                "Please enter at least one keyword after p/ when searching by phone number. "
                + Emoticons.ANGRY + "\n" + FindCommand.MESSAGE_USAGE);
        assertParseFailure(parser, "e/",
                "Please enter at least one keyword after e/ when searching by email. "
                + Emoticons.ANGRY + "\n" + FindCommand.MESSAGE_USAGE);
        assertParseFailure(parser, "a/",
                "Please enter at least one keyword after a/ when searching by address. "
                + Emoticons.ANGRY + "\n" + FindCommand.MESSAGE_USAGE);
        assertParseFailure(parser, "t/",
                "Please enter at least one keyword after t/ when searching by tag. "
                + Emoticons.ANGRY + "\n" + FindCommand.MESSAGE_USAGE);
        // New prefixes
        assertParseFailure(parser, "m/",
                "Please enter at least one keyword after m/ when searching by memo. "
                + Emoticons.ANGRY + "\n" + FindCommand.MESSAGE_USAGE);
        assertParseFailure(parser, "bd/",
                "Please enter at least one date after bd/ when searching by booking date. "
                + Emoticons.ANGRY + "\n" + FindCommand.MESSAGE_USAGE);
        assertParseFailure(parser, "bp/",
                "Please enter at least one keyword after bp/ "
                + "when searching by booking property. "
                + Emoticons.ANGRY + "\n" + FindCommand.MESSAGE_USAGE);
    }

    @Test
    public void parse_validArgsNoPrefix_returnsFindCommand() {
        // Test with multiple words - no prefix
        try {
            FindCommand command = parser.parse("Alice Bob");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.NAME));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        // Test with single word - no prefix
        try {
            FindCommand command = parser.parse("Alice");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.NAME));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_validNameArgs_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("n/Alice Bob");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.NAME));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("n/O'Neil Smith-Jones");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.NAME));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_validPhoneArgs_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("p/12345678");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.PHONE));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("p/12345678 87654321");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.PHONE));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("p/+12345678");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.PHONE));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_validEmailArgs_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("e/test@example.com");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.EMAIL));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("e/test.user-name@example.com");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.EMAIL));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_validMemoArgs_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("m/important");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.MEMO));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("m/call back urgent");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.MEMO));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("m/Meeting scheduled for 10:30 AM!");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.MEMO));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_validBookingDateArgs_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("bd/2025-06-01");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.BOOKING_DATE));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("bd/2025-06-01 2025-07-15");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.BOOKING_DATE));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_validBookingPropertyArgs_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("bp/BeachHouse");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.BOOKING_PROPERTY));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("bp/Beach House");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.BOOKING_PROPERTY));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("bp/Beach-Villa Resort123");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.BOOKING_PROPERTY));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_multipleValidFields_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("n/John p/12345678");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(2, criteria.size());
            assertTrue(criteria.containsKey(SearchType.NAME));
            assertTrue(criteria.containsKey(SearchType.PHONE));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_mixedFormatWithNewPrefixes_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("John m/important");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(2, criteria.size());
            assertTrue(criteria.containsKey(SearchType.NAME));
            assertTrue(criteria.containsKey(SearchType.MEMO));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_mixedFormatWithLeadingUnprefixedKeywords_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("Alice Bob n/Charlie p/12345678");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();

            assertEquals(2, criteria.size());

            assertTrue(criteria.containsKey(SearchType.NAME));
            List<String> nameKeywords = criteria.get(SearchType.NAME);
            assertTrue(nameKeywords.contains("Alice"));
            assertTrue(nameKeywords.contains("Bob"));
            assertTrue(nameKeywords.contains("Charlie"));

            // Assert that we have a 'PHONE' search type
            assertTrue(criteria.containsKey(SearchType.PHONE));
            List<String> phoneKeywords = criteria.get(SearchType.PHONE);
            assertTrue(phoneKeywords.contains("12345678"));

        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }



    @Test
    public void parse_validAddressArgs_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("a/Clementi Ave 6");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.ADDRESS));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("a/Blk 123 #01-456");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.ADDRESS));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_validTagArgs_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("t/friends");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.TAG));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("t/friends family colleagues");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.TAG));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_invalidPrefix_throwsParseException() {
        assertParseFailure(parser, "x/keyword",
                "Invalid search field: 'x/'. Valid prefixes are: \n name: n/ \n phone: p/ \n email: e/ \n"
                + "address: a/ \n tag: t/ \n memo: m/ \n booking date: bd/ \n booking property: bp/ "
                + Emoticons.ANGRY + "\n" + FindCommand.MESSAGE_USAGE);
    }

    @Test
    public void parse_invalidNameFormat_throwsParseException() {
        String longName = "A".repeat(256); // Create a 256-character name
        assertParseFailure(parser, "n/" + longName, String.format(MESSAGE_PARSE_EXCEPTION,
                "Error: Name values should not exceed 170 characters.", FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidPhoneFormat_throwsParseException() {
        assertParseFailure(parser, "p/123abc", String.format(MESSAGE_PARSE_EXCEPTION,
                "Error: Invalid phone format. Phone numbers should contain digits, with an optional '+' "
                + "at the beginning. Invalid keyword(s): 123abc", FindCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "p/abc+123456", String.format(MESSAGE_PARSE_EXCEPTION,
                "Error: Invalid phone format. Phone numbers should contain digits, with an optional '+'"
                + " at the beginning. Invalid keyword(s): abc+123456", FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidEmailFormat_throwsParseException() {
        String errorMessage1 = "Error: Invalid email format. Emails should only contain alphanumeric characters, dots, "
                        + "'@', underscores, hyphens, and the special characters: ~!$%^&*_=+}{'?\\.-. "
                        + "Invalid keyword(s): invalid,email";
        String errorMessage2 = "Error: Invalid email format. Emails should only contain alphanumeric characters, dots, "
                        + "'@', underscores, hyphens, and the special characters: ~!$%^&*_=+}{'?\\.-. "
                        + "Invalid keyword(s): test>com";
        assertParseFailure(parser, "e/invalid,email", String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                errorMessage1, FindCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "e/test>com", String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                errorMessage2, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidAddressFormat_throwsParseException() {
        String longAddress = "A".repeat(501); // Create a 501-character address
        assertParseFailure(parser, "a/" + longAddress, String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Error: Address values should not exceed 170 characters.", FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidTagFormat_throwsParseException() {
        String longTag = "A".repeat(256); // Create a 256-character tag
        assertParseFailure(parser, "t/" + longTag, String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Error: Tag values should not exceed 170 characters.", FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidMemoFormat_throwsParseException() {
        String longMemo = "A".repeat(171); // Create a 171-character memo
        assertParseFailure(parser, "m/" + longMemo, String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Error! Memo values should not exceed 170 characters.", FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidBookingDateFormat_throwsParseException() {
        assertParseFailure(parser, "bd/20-06-2025", String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Invalid booking date format. Dates should be in the format yyyy-MM-dd "
                + "(e.g., 2024-10-15). Invalid keyword(s): 20-06-2025", FindCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "bd/2025/06/01", String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Invalid booking date format. Dates should be in the format yyyy-MM-dd "
                + "(e.g., 2024-10-15). Invalid keyword(s): 2025/06/01", FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidBookingPropertyFormat_throwsParseException() {
        String longProperty = "A".repeat(256); // Create a 256-character property name
        assertParseFailure(parser, "bp/" + longProperty, String.format(Messages.MESSAGE_PARSE_EXCEPTION,
            "Error! Booking Property values should not exceed 170 characters.", FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_mixedValidInvalidKeywords_throwsParseException() {
        assertParseFailure(parser, "p/12345678 9876-5432", String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Error: Invalid phone format. Phone numbers should contain digits, with an optional "
                + "'+' at the beginning. Invalid keyword(s): 9876-5432", FindCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "bd/2025-06-01 06-01-2025", String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Invalid booking date format. Dates should be in the format yyyy-MM-dd "
                + "(e.g., 2024-10-15). Invalid keyword(s): 06-01-2025", FindCommand.MESSAGE_USAGE));

        // Test with excessive character length keywords mixed with valid ones
        String longName = "A".repeat(256);
        assertParseFailure(parser, "n/John " + longName, String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Error: Name values should not exceed 170 characters.", FindCommand.MESSAGE_USAGE));

        String longTag = "T".repeat(256);
        assertParseFailure(parser, "t/friends " + longTag, String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Error: Tag values should not exceed 170 characters.", FindCommand.MESSAGE_USAGE));

        String longMemo = "M".repeat(501);
        assertParseFailure(parser, "m/important " + longMemo, String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Error! Memo values should not exceed 170 characters.", FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_duplicateSearchField_throwsParseException() {
        assertParseFailure(parser, "n/Alice n/Bob", String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Duplicate search field: n/. Each field can only be specified once.", FindCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "p/12345678 p/87654321", String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Duplicate search field: p/. Each field can only be specified once.", FindCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "John n/Alice n/Bob", String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                "Duplicate search field: n/. Each field can only be specified once.", FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_allValidFieldsTogether_returnsFindCommand() {
        try {
            FindCommand command = parser.parse("n/John p/12345678 e/john@example.com a/Clementi t/friends "
                    + "m/important bd/2025-06-01 bp/Beach");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(8, criteria.size());
            assertTrue(criteria.containsKey(SearchType.NAME));
            assertTrue(criteria.containsKey(SearchType.PHONE));
            assertTrue(criteria.containsKey(SearchType.EMAIL));
            assertTrue(criteria.containsKey(SearchType.ADDRESS));
            assertTrue(criteria.containsKey(SearchType.TAG));
            assertTrue(criteria.containsKey(SearchType.MEMO));
            assertTrue(criteria.containsKey(SearchType.BOOKING_DATE));
            assertTrue(criteria.containsKey(SearchType.BOOKING_PROPERTY));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_edgeCasesInValidation_handledCorrectly() {
        try {
            // Test name with apostrophes and hyphens
            FindCommand command = parser.parse("n/John-Smith O'Brien");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.NAME));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }

        try {
            FindCommand command = parser.parse("e/john.doe_123+test@example-domain.com");
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.EMAIL));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_invalidCommandFormatNoPrefix_throwsParseException() {
        // No field prefix after initial non-prefix keywords
        assertParseFailure(parser, "John Jane x/invalid",
                "Invalid search field: 'x/'. Valid prefixes are: \n name: n/ \n phone: p/ \n email: e/ \n"
                + "address: a/ \n tag: t/ \n memo: m/ \n booking date: bd/ \n booking property: bp/ "
                + Emoticons.ANGRY + "\n" + FindCommand.MESSAGE_USAGE);
    }

    @Test
    public void equals_sameValues_true() {
        try {
            FindCommand command1 = parser.parse("n/John p/12345678");
            FindCommand command2 = parser.parse("n/John p/12345678");
            assertEquals(command1, command2);
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void equals_differentValues_false() {
        try {
            FindCommand command1 = parser.parse("n/John");
            FindCommand command2 = parser.parse("n/Jane");
            assertFalse(command1.equals(command2));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }

    @Test
    public void parse_dateFormatValidation_worksProperly() {
        // Valid date in leap year
        try {
            FindCommand command = parser.parse("bd/2024-02-29"); // Leap year
            Map<SearchType, List<String>> criteria = command.getSearchCriteria();
            assertEquals(1, criteria.size());
            assertTrue(criteria.containsKey(SearchType.BOOKING_DATE));
        } catch (ParseException pe) {
            fail("Failed to parse valid input: " + pe.getMessage());
        }
    }


    @Test
    public void parse_noValidKeywords_throwsParseException() {
        // This tests the empty map scenario
        assertParseFailure(parser, "n/InvalidVeryLongName" + "A".repeat(200),
                String.format(MESSAGE_PARSE_EXCEPTION,
                "Error: Name values should not exceed 170 characters.",
                FindCommand.MESSAGE_USAGE));
    }
}

