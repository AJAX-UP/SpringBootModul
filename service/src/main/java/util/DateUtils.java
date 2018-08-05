package util;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhu
 * date: 2018/1/23
 * Description: Date 工具类
 */
public class DateUtils {

    public static Date getStartOfDay() {
        return new DateTime().withTimeAtStartOfDay().toLocalDateTime().toDate();
    }

    public static Date getStartOfNextDay() {
        return new DateTime().withTimeAtStartOfDay().plusDays(1).toLocalDateTime().toDate();
    }

    public static Date getStartOfWeek() {
        return new LocalDate().dayOfWeek().withMinimumValue().toDate();
    }

    public static Date getStartOfNextWeek() {
        return new LocalDate().dayOfWeek().withMinimumValue().plusWeeks(1).toDate();
    }

    public static Date getStartOfMonth() {
        return new LocalDate().dayOfMonth().withMinimumValue().toDate();
    }

    public static Date getStartOfNextMonth() {
        return new LocalDate().dayOfMonth().withMinimumValue().plusMonths(1).toDate();
    }
    private final static SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy/MM/dd");
    public static String simpleDate(Date date) {
        if (date == null){
            return "";
        }
        return sdf.format(date);
    }

    public static String dateFormat(Date date, String sdf) {
        if (date == null){
            return "";
        }
        return new SimpleDateFormat(sdf).format(date);
    }
}
