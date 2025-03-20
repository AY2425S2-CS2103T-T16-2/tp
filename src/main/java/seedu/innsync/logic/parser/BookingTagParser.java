package seedu.innsync.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.innsync.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_BOOKINGTAG;

import seedu.innsync.commons.core.index.Index;
import seedu.innsync.commons.exceptions.IllegalValueException;
import seedu.innsync.logic.commands.BookingTagCommand;
import seedu.innsync.logic.parser.exceptions.ParseException;
import seedu.innsync.model.tag.BookingTag;

/**
 * Parses input arguments and creates a new BookingTagCommand object
 */
public class BookingTagParser implements Parser<BookingTagCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the BookingTagCommand
     * and returns a BookingTagCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public BookingTagCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_BOOKINGTAG);
        Index index;
        BookingTag bookingTag;
        try {
            argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_BOOKINGTAG);
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
            bookingTag = ParserUtil.parseBookingTag(argMultimap.getValue(PREFIX_BOOKINGTAG).orElse(""));
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    BookingTagCommand.MESSAGE_USAGE), ive);
        }
        return new BookingTagCommand(index, bookingTag);
    }
}
