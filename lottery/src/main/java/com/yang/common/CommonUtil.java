package com.yang.common;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Package:com.yixin.ndss.utils.common
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/25 14:24
 */
public class CommonUtil {

    private CommonUtil() {
    }

    private static ThreadLocal<SimpleDateFormat> sdfThread = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override
        public SimpleDateFormat get() {
            // TODO Auto-generated method stub
            return super.get();
        }

        @Override
        public void set(SimpleDateFormat value) {
            super.set(value);
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            super.remove();
        }

    };

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat value = new SimpleDateFormat(pattern);
        sdfThread.set(value);
        SimpleDateFormat format = sdfThread.get();
        return format.format(date);
    }

    public static Date parseDate(String date, String pattern) throws ParseException {
        SimpleDateFormat value = new SimpleDateFormat(pattern);
        sdfThread.set(value);
        SimpleDateFormat format = sdfThread.get();
        return format.parse(date);
    }

    /**
     * 计算两个日期之间相差的天数 (精确到天)
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetween1(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        int i = 0;
        while (cal.getTime().before(date2)) {
            cal.add(Calendar.DAY_OF_YEAR, 1);
            i++;
        }

        return --i;
    }

    /**
     * 转换List为in的字符串('a','b')
     *
     * @param strList 入参
     * @return 结果
     * @author YixinCapital -- sfei 2016年4月9日 下午12:21:27
     */
    public static String transferListStringToIn(List<String> strList) {

        if (strList == null || strList.size() == 0)
            return "";

        String Str = "(";
        for (int i = 0; i < strList.size(); i++) {

            Str = Str + "'" + strList.get(i) + "'";
            if (i == strList.size() - 1) {
                Str = Str + ")";
            } else {
                Str = Str + ",";
            }

        }

        return Str;

    }

    /**
     * 将json 转化为对象
     *
     * @param json
     * @param obj
     * @return
     * @author YixinCapital -- chenyuan1 2016年3月2日 上午10:30:47
     * @throws IOException
     */
    public static Object jsonToObject(String json, Object obj) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, obj.getClass());
    }

    /**
     * 将对象转化为json
     *
     * @param obj
     * @return
     * @author YixinCapital -- chenyuan1 2016年3月2日 上午10:33:02
     * @throws JsonProcessingException
     */
    public static String objectToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}
