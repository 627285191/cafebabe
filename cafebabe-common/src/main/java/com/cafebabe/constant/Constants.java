package com.cafebabe.constant;

/**
 *
 * <p>createDate: 2017/10/17 10:48
 * <p>blog: <a href=http://www.cnblogs.com/koala2016/>喝咖啡的考拉</a>
 * <p>author: 李德华 
 * <p>version: 1.0 2017/10/17
 */
public class Constants {

    /**
     * logback常量枚举类
     */
    public enum LogbackEnum{
        /**
         * 输出源为CyclicBufferAppender的名字
         */
        CYCLIC_BUFFER_APPENDER_NAME("CYCLIC"),
        /**
         * logback servlet支持
         */
        ACCESS("Access"),
        /**
         * logback slf4j支持
         */
        CLASSIC("Classic");
        String value;
        LogbackEnum(String value){
            this.value=value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 2222枚举类
     */
    public enum Constants2222Enum{

    }
}
