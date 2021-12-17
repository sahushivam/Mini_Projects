package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuctionUtility {

    public static Date getDateFromString(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(strDate);
    }
}
