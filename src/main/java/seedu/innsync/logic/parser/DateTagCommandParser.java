package seedu.innsync.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.innsync.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_DATETAG;

import seedu.innsync.commons.core.index.Index;
import seedu.innsync.commons.exceptions.IllegalValueException;
import seedu.innsync.logic.commands.DateTagCommand;
import seedu.innsync.logic.parser.exceptions.ParseException;
import seedu.innsync.model.person.DateTag;

/**
 * Parses input arguments and creates a new {@code DateTagCommand} object
 */
public class DateTagCommandParser implements Parser<DateTagCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code DateTagCommand}
     * and returns a {@code DateTagCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DateTagCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_DATETAG);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DateTagCommand.MESSAGE_USAGE), ive);
        }

        String remark = argMultimap.getValue(PREFIX_DATETAG).orElse("");

        return new DateTagCommand(index, new DateTag(remark));
    }
}
