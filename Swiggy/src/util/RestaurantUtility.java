package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RestaurantUtility {

    public static LocalTime convertStringDateToLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalTime localDateTime = LocalTime.parse(date, formatter);
        return localDateTime;
    }
}
