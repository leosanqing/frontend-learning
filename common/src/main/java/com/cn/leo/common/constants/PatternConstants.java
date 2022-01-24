package com.cn.leo.common.constants;


public interface PatternConstants {
    String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    String MUST_NUMBER = "^[0-9]*$";
    String PHONE = "^\\d{11,13}$";
    String VERIFY_CODE = "^\\d{6}$";
    String PW = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
    String SOCIAL_CREDIT_CODE = "[A-Z0-9]{18}$";
    String DATE= "yyyy-MM-dd";
}
