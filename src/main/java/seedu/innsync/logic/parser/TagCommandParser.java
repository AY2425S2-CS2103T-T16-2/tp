package seedu.innsync.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.innsync.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.innsync.commons.core.index.Index;
import seedu.innsync.commons.exceptions.IllegalValueException;
import seedu.innsync.logic.commands.TagCommand;
import seedu.innsync.logic.parser.exceptions.ParseException;
import seedu.innsync.model.tag.Tag;

/**
 * Parses input arguments and creates a new TagCommand object
 */
public class TagCommandParser implements Parser<TagCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the TagCommand
     * and returns a TagCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public TagCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_TAG);
        Index index;
        Tag tag;
        try {
            argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_TAG);
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
            tag = ParserUtil.parseTag(argMultimap.getValue(PREFIX_TAG).orElse(""));
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    TagCommand.MESSAGE_USAGE), ive);
        }
        return new TagCommand(index, tag);
    }
}
