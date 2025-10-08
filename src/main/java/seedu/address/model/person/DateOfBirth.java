package seedu.address.model.person;

import seedu.address.model.util.DateParserUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 */
public class DateOfBirth {

    public static final String MESSAGE_CONSTRAINTS =
            "Dates should be of the following formats: DD-MM-YYYY, DD/MM/YYYY or DD.MM.YYYY";

    public static final List<DateTimeFormatter> FORMATTERS = List.of(
        DateTimeFormatter.ofPattern("dd-MM-yyyy"),
        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("dd.MM.yyyy")
    );

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /*
     * Dates: 00 to 31
     * Separators: -, /, or .
     * Months: 00 to 12
     * Separators: -, /, or .
     * Years: Four digits
     */
    public static final String VALIDATION_REGEX = "^(0[1-9]|[12]\\d|3[01])[-/.](0[1-9]|1[0-2])[-/.](\\d{4})$";

    public final LocalDate dateOfBirth;

    public DateOfBirth(String dateOfBirth) {
        requireNonNull(dateOfBirth);
        checkArgument(isValidDate(dateOfBirth), MESSAGE_CONSTRAINTS);
        this.dateOfBirth = DateParserUtil.parseDate(dateOfBirth, FORMATTERS);
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidDate(String test) {
        return test.matches(VALIDATION_REGEX) && DateParserUtil.isValidDate(test, FORMATTERS);
    }


    @Override
    public String toString() {
        return DateParserUtil.formatDate(dateOfBirth, DATE_FORMATTER);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DateOfBirth otherDate)) {
            return false;
        }

        return dateOfBirth.equals(otherDate.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return dateOfBirth.hashCode();
    }

}
