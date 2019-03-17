package com.jnshu.task4.common.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @program: task4
 * @description: 自定义jsp标签, 日期long转string
 * @author: Mr.Chen
 * @create: 2019-02-22 16:07
 * @contact:938738637@qq.com
 **/
public class DateTag extends TagSupport {
    public String time;
//    @Override
//    public int doStartTag() throws JspException {
//        Long l = 0l;
//
//            if (time != null && !time.equals("")) {
//                l = Long.parseLong(time);
//            }
//            Date date = new Date();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String targetTime = dateFormat.format(date);
//        try {
//            super.pageContext.getOut().write(targetTime);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return super.doStartTag();
//    }

    @Override
    public int doStartTag() throws JspException {
        String vv = "" + time;
        try {
            long time = Long.valueOf(vv.trim());
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String s = dateformat.format(c.getTime());
            pageContext.getOut().write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
    public void setTime(String time) {
        this.time = time;
    }


}
