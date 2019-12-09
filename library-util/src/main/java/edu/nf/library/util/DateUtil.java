package edu.nf.library.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dwd
 * @date 2019/12/5
 */
public class DateUtil {
    public static Date getData() throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
       String date= format.format(new Date());
      Date date1= format.parse(date);
      return date1;
    }

}