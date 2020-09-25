package com.example.common.utils;


import java.math.BigDecimal;
import java.util.*;

/**
 * 字符串工具类
 *
 * @author ruoyi
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 空字符串
     */
    private static final String NULLSTR = "";

    /**
     * 下划线
     */
    private static final char SEPARATOR = '_';

    private static final char[] hex={'1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    /**
     * 获取参数不为空值
     *
     * @param value defaultValue 要判断的value
     * @return value 返回值
     */
    public static <T> T nvl(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    /**
     * * 判断一个Collection是否为空， 包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll) {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个Collection是否非空，包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * * 判断一个对象数组是否为空
     *
     * @param objects 要判断的对象数组
     *                * @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects) {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * * 判断一个对象数组是否非空
     *
     * @param objects 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return isNull(map) || map.isEmpty();
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || NULLSTR.equals(str.trim());
    }

    /**
     * * 判断一个字符串是否为非空串
     *
     * @param str String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * * 判断一个对象是否是数组类型（Java基本型别的数组）
     *
     * @param object 对象
     * @return true：是数组 false：不是数组
     */
    public static boolean isArray(Object object) {
        return isNotNull(object) && object.getClass().isArray();
    }

    /**
     * 去空格
     */
    public static String trim(String str) {
        return (str == null ? "" : str.trim());
    }

    /**
     * 截取字符串
     *
     * @param str   字符串
     * @param start 开始
     * @return 结果
     */
    public static String substring(final String str, int start) {
        if (str == null) {
            return NULLSTR;
        }

        if (start < 0) {
            start = str.length() + start;
        }

        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return NULLSTR;
        }

        return str.substring(start);
    }

    /**
     * 截取字符串
     *
     * @param str   字符串
     * @param start 开始
     * @param end   结束
     * @return 结果
     */
    public static String substring(final String str, int start, int end) {
        if (str == null) {
            return NULLSTR;
        }

        if (end < 0) {
            end = str.length() + end;
        }
        if (start < 0) {
            start = str.length() + start;
        }

        if (end > str.length()) {
            end = str.length();
        }

        if (start > end) {
            return NULLSTR;
        }

        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }


    /**
     * 下划线转驼峰命名
     */
    public static String toUnderScoreCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // 前置字符是否大写
        boolean preCharIsUpperCase = true;
        // 当前字符是否大写
        boolean curreCharIsUpperCase = true;
        // 下一字符是否大写
        boolean nexteCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i > 0) {
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            } else {
                preCharIsUpperCase = false;
            }

            curreCharIsUpperCase = Character.isUpperCase(c);

            if (i < (str.length() - 1)) {
                nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase) {
                sb.append(SEPARATOR);
            } else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase) {
                sb.append(SEPARATOR);
            }
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        if (str != null && strs != null) {
            for (String s : strs) {
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。 例如：HELLO_WORLD->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String convertToCamelCase(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母大写
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 首字母大写
            result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }

    /**
     * 驼峰式命名法 例如：user_name->userName
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String getHaxRandom(){
        return "";
    }



    public static final String[] format_dic1={"/","/"," ",":"};
    public static final String[] format_dic2={"-","-"," ",":"};

    /**
     * 功能描述: <br>
     * 〈转换long类型的时间(2020050402254512)  ->  (yyyy-MM-dd HH:mm)〉
     * @Param: [time]
     * @Return: java.lang.String
     * @Author: songxinzhang
     * @Date: 2020/6/4 9:44
     */
    public static String getStringDateDic1(Long time){
        String str=String.valueOf(BigDecimal.valueOf(time));
        String[] strs=str.split("|");
        List<String> tagart= Arrays.asList(strs);
        List<String> list=new ArrayList<>(tagart);
        StringBuilder sb=new StringBuilder();
        if(list.size()>12){
            list.add(4,format_dic2[0]);
            list.add(7,format_dic2[1]);
            list.add(10,format_dic2[2]);
            list.add(13,format_dic2[3]);
            for (int i=0;i<list.size()-2;i++) {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    /**
     * 功能描述: <br>
     * 〈〉20200527120001  ->  yyyy-MM-dd HH:mm
     * @Param: [time]
     * @Return: java.lang.String
     * @Author: songxinzhang
     * @Date: 2020/6/8 16:27
     */
    public static String getStringDateDic1(String str){
        if(StringUtils.isEmpty(str)){
            return "";
        }
        String[] strs=str.split("|");
        List<String> tagart= Arrays.asList(strs);
        List<String> list=new ArrayList<>(tagart);
        StringBuilder sb=new StringBuilder();
        if(list.size()>12){
            list.add(4,format_dic2[0]);
            list.add(7,format_dic2[1]);
            list.add(10,format_dic2[2]);
            list.add(13,format_dic2[3]);
            for (int i=0;i<list.size()-2;i++) {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    public static String getStringDateDic2(String str){
        String[] strs=str.split("|");
        List<String> tagart= Arrays.asList(strs);
        List<String> list=new ArrayList<>(tagart);
        StringBuilder sb=new StringBuilder();
        if(list.size()>12){
            list.add(4,format_dic1[0]);
            list.add(7,format_dic1[1]);
            list.add(10,format_dic1[2]);
            list.add(13,format_dic1[3]);
            for (int i=0;i<list.size()-2;i++) {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }

    /**
     * 功能描述: <br>
     * 〈〉20200529  ->  yyyy-MM-dd
     * @Param: [time]
     * @Return: java.lang.String
     * @Author: songxinzhang
     * @Date: 2020/6/8 16:27
     */
    public static String getStringDateDic3(String bankAcctDate) {
        String[] strs=bankAcctDate.split("|");
        List<String> tagart= Arrays.asList(strs);
        List<String> list=new ArrayList<>(tagart);
        StringBuilder sb=new StringBuilder();
        if(list.size()>7){
            list.add(4,format_dic2[0]);
            list.add(7,format_dic2[1]);
            for (int i=0;i<list.size();i++) {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}