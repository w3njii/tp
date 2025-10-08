package seedu.address.model.util;

import seedu.address.model.person.DateOfBirth;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class DateParserUtil {

    public static LocalDate parseDate(String date, List<DateTimeFormatter> formatters) throws DateTimeParseException {
        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (DateTimeParseException e) {
                // continue to next formatter
            }
        }
        // should never reach here if isValidDate is called before
        throw new DateTimeParseException("Invalid date format", date, 0);
    }

    public static String formatDate(LocalDate date, DateTimeFormatter formatter) {
        return date.format(formatter);
    }

    public static boolean isValidDate(String dateString, List<DateTimeFormatter> formatters) {
        return formatters.stream().allMatch(formatter -> isValid(dateString, formatter));
    }

    private static boolean isValid(String dateString, DateTimeFormatter formatter) {
        try {
            LocalDate.parse(dateString, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
