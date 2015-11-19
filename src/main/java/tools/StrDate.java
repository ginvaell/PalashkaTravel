package tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StrDate {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static String getCurrentDate() {
        return format.format(new Date());
    }
}
