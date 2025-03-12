package seedu.innsync.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.innsync.commons.exceptions.IllegalValueException;
import seedu.innsync.model.tag.DateTag;
import seedu.innsync.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Tag}.
 */
class JsonAdaptedDateTag {

    private final String dateTagName;

    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedDateTag(String dateTagName) {
        this.dateTagName = dateTagName;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedDateTag(DateTag source) {
        dateTagName = source.dateTagName;
    }

    @JsonValue
    public String getDateTagName() {
        return dateTagName;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public DateTag toModelType() throws IllegalValueException {
        if (!Tag.isValidTagName(dateTagName)) {
            throw new IllegalValueException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new DateTag(dateTagName);
    }

}
