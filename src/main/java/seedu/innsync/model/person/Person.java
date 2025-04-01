package seedu.innsync.model.person;

import static seedu.innsync.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.innsync.commons.util.ToStringBuilder;
import seedu.innsync.model.request.Request;
import seedu.innsync.model.tag.BookingTag;
import seedu.innsync.model.tag.Tag;
import seedu.innsync.model.tag.exceptions.DuplicateTagException;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Memo memo;

    private final Set<Request> requests = new HashSet<>();
    private final Set<BookingTag> bookingTags = new HashSet<>();
    private final Set<Tag> tags = new HashSet<>();
    private final boolean starred;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Memo memo, Set<Request> requests,
                  Set<BookingTag> bookingTags, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, memo, requests, bookingTags, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.memo = memo;
        this.requests.addAll(requests);
        this.bookingTags.addAll(bookingTags);
        this.tags.addAll(tags);
        this.starred = false;
    }

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Memo memo, Set<Request> requests,
                  Set<BookingTag> bookingTags, Set<Tag> tags, boolean starred) {
        requireAllNonNull(name, phone, email, address, bookingTags, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.memo = memo;
        this.requests.addAll(requests);
        this.bookingTags.addAll(bookingTags);
        this.tags.addAll(tags);
        this.starred = starred;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public boolean getStarred() {
        return starred;
    }

    public Memo getMemo() {
        return memo;
    }

    public Set<Request> getRequests() {
        return Collections.unmodifiableSet(requests);
    }

    public Set<BookingTag> getBookingTags() {
        return Collections.unmodifiableSet(bookingTags);
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Adds a tag to the list of tags of the person.
     *
     * @param tag the tag to be added
     */
    public void addTag(Tag tag) throws DuplicateTagException {
        requireAllNonNull(tag);
        if (tags.contains(tag)) {
            throw new DuplicateTagException();
        }
        tags.add(tag);
    }

    /**
     * Removes a tag from the list of tags of the person.
     *
     * @param tag the tag to be removed
     */
    public void removeTag(Tag tag) {
        requireAllNonNull(tag);
        tags.remove(tag);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && address.equals(otherPerson.address)
                && starred == otherPerson.starred
                && memo.equals(otherPerson.memo)
                && requests.equals(otherPerson.requests)
                && bookingTags.equals(otherPerson.bookingTags)
                && tags.equals(otherPerson.tags);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, memo, requests, bookingTags, tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("memo", memo)
                .add("requests", requests)
                .add("bookingTags", bookingTags)
                .add("tags", tags)
                .add("starred", starred)
                .toString();
    }

}
