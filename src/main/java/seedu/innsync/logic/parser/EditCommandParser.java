package seedu.innsync.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.innsync.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_BOOKINGTAG;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_MEMO;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_REQUEST;
import static seedu.innsync.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import java.util.stream.Stream;
import seedu.innsync.commons.core.index.Index;
import seedu.innsync.logic.Messages;
import seedu.innsync.logic.commands.EditCommand;
import seedu.innsync.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.innsync.logic.commands.TagCommand;
import seedu.innsync.logic.parser.exceptions.ParseException;
import seedu.innsync.model.request.Request;
import seedu.innsync.model.tag.BookingTag;
import seedu.innsync.model.tag.Tag;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(
                    args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL,
                    PREFIX_ADDRESS, PREFIX_MEMO, PREFIX_REQUEST, PREFIX_BOOKINGTAG, PREFIX_TAG);

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_MEMO);

        if (!atLeastOnePrefixPresent(argMultimap, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL,
                PREFIX_ADDRESS, PREFIX_MEMO, PREFIX_REQUEST, PREFIX_BOOKINGTAG, PREFIX_TAG)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));
        }
        EditPersonDescriptor editPersonDescriptor = new EditPersonDescriptor();

        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            editPersonDescriptor.setName(ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()));
        }
        if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
            editPersonDescriptor.setPhone(ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()));
        }
        if (argMultimap.getValue(PREFIX_EMAIL).isPresent()) {
            editPersonDescriptor.setEmail(ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get()));
        }
        if (argMultimap.getValue(PREFIX_ADDRESS).isPresent()) {
            editPersonDescriptor.setAddress(ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get()));
        }

        if (argMultimap.getValue(PREFIX_MEMO).isPresent()) {
            editPersonDescriptor.setMemo(ParserUtil.parseMemo(argMultimap.getValue(PREFIX_MEMO).get()));
        }

        parseRequestsForEdit(argMultimap.getAllValues(PREFIX_REQUEST))
                .ifPresent(editPersonDescriptor::setRequests);

        parseBookingTagsForEdit(argMultimap.getAllValues(PREFIX_BOOKINGTAG))
                .ifPresent(editPersonDescriptor::setBookingTags);

        parseTagsForEdit(argMultimap.getAllValues(PREFIX_TAG)).ifPresent(editPersonDescriptor::setTags);

        if (!editPersonDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditCommand.MESSAGE_FAILURE);
        }
        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(Messages.MESSAGE_PARSE_EXCEPTION,
                    pe.getMessage(), EditCommand.MESSAGE_USAGE), pe);
        }
        return new EditCommand(index, editPersonDescriptor);
    }

    private static boolean atLeastOnePrefixPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).anyMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    /**
     * Parses {@code Collection<String> requests} into a {@code RequestList} if {@code requests} is non-empty.
     * If {@code requests} contain only one element which is an empty string, it will be parsed into a
     * {@code RequestList} containing zero request.
     */
    private Optional<List<Request>> parseRequestsForEdit(Collection<String> requests) throws ParseException {
        assert requests != null;

        if (requests.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> requestSet = requests.size() == 1 && requests.contains("")
                ? Collections.emptySet() : requests;
        return Optional.of(ParserUtil.parseRequests(requestSet));
    }

    /**
     * Parses {@code Collection<String> bookingTags} into a {@code Set<BookingTag>} if {@code bookingTags} is non-empty.
     * If {@code bookingTags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<BookingTag>} containing zero booking tags.
     */
    private Optional<Set<BookingTag>> parseBookingTagsForEdit(Collection<String> bookingTags) throws ParseException {
        assert bookingTags != null;

        if (bookingTags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> bookingTagSet = bookingTags.size() == 1 && bookingTags.contains("")
                ? Collections.emptySet() : bookingTags;
        return Optional.of(ParserUtil.parseBookingTags(bookingTagSet));
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>} if {@code tags} is non-empty.
     * If {@code tags} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<Tag>} containing zero tags.
     */
    private Optional<Set<Tag>> parseTagsForEdit(Collection<String> tags) throws ParseException {
        assert tags != null;

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> tagSet = tags.size() == 1 && tags.contains("") ? Collections.emptySet() : tags;
        return Optional.of(ParserUtil.parseTags(tagSet));
    }
}
