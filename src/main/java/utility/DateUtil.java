package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getTimeStamp(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        return date.toString().replaceAll(":","_").replaceAll("","_");
    }
}
