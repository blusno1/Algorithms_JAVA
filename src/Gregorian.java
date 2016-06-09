import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by root on 16-6-9.
 * mailto:blusto@gmail.com
 */
public class Gregorian {

    public static void main(String[] args) {

        GregorianCalendar d = new GregorianCalendar();
//      获取当前的日期
        int today = d.get(Calendar.DAY_OF_MONTH);
//      获取当前月份
        int month = d.get(Calendar.MONTH);
        //将d设置为本月第一天
        d.set(Calendar.DAY_OF_MONTH,1);
//      获取当前星期几
        int weekday = d.get(Calendar.DAY_OF_WEEK);


        int firstDayOfWeek = d.getFirstDayOfWeek();
        System.out.println("firstDayOfWeek= "+firstDayOfWeek);

        int indent = 0;
        /*
        * 将d指向本周第一天
        * */
        while (weekday != firstDayOfWeek){
            indent++;
            d.add(Calendar.DAY_OF_MONTH,-1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        /*
        输出日期缩写
         */
        do
        {
            System.out.printf("%4s",weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH,1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }while (weekday != firstDayOfWeek);

        System.out.println();

        for (int i = 0; i <= indent ; i++) {
            System.out.print("    ");
        }
        System.out.print("  ");
        d.set(Calendar.DAY_OF_MONTH,1);
        do {

            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d",day);

            if (day == today){
                System.out.print("*  ");
            }
            else {
                System.out.print("   ");
            }

            d.add(Calendar.DAY_OF_MONTH,1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            if (weekday == firstDayOfWeek){
                System.out.println();
            }
        }while (d.get(Calendar.MONTH) == month);

        if (weekday != firstDayOfWeek){
            System.out.println();
        }
    }
}
