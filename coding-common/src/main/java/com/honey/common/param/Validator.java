package com.honey.common.param;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    /**
     * 手机号校验
     *
     * @param phone
     */
    public static void checkPhone(String phone) {
        checkNotNull(phone, "手机号");
        if (!isMobile(phone))
            throw new ParamError(String.format("手机号格式错误"));
    }

    /**
     * 非空校验
     *
     * @param param
     * @param desc
     */
    public static <T> void checkNotNull(T param, String desc) {
        if (param == null)
            throw new ParamError(String.format("%s 不能为空", desc));
        if (param instanceof String && StringUtils.isEmpty((String) param))
            throw new ParamError(String.format("%s 不能为空", desc));
    }

    /**
     * 非空校验
     *
     * @param param
     * @param desc
     */
    public static <T> void checkNotNull(List<T> param, String desc) {
        if (param == null)
            throw new ParamError(String.format("%s 不能为空", desc));
        if (param.isEmpty())
            throw new ParamError(String.format("%s 不能为空", desc));
    }

    /**
     * 长度校验
     *
     * @param param
     * @param desc
     */
    public static <T> void checkOverLength(List<T> param, String desc) {
        if (param == null)
            throw new ParamError(String.format("%s 不能为空", desc));
        if (param.isEmpty())
            throw new ParamError(String.format("%s 不能为空", desc));
    }

    /**
     * 字符串长度校验
     *
     * @param min
     * @param max
     * @param param
     * @param desc
     */
    public static void checkStringLength(Integer min, Integer max, String param, String desc) {
        if (min == null)
            min = 0;
        if (max == null)
            max = Integer.MAX_VALUE;
        checkNotNull(param, "desc");
        if (param.length() > max) {
            throw new ParamError(String.format("%s 长度不能大于 %s", desc, max));
        } else if (param.length() < min) {
            throw new ParamError(String.format("%s 长度不能小于 %s", desc, min));
        }
    }

    /**
     * 数字大小校验
     *
     * @param min
     * @param max
     * @param param
     * @param desc
     */
    public static void checkNumberSize(Integer min, Integer max, Integer param, String desc) {
        if (min == null)
            min = 0;
        if (max == null)
            max = Integer.MAX_VALUE;
        checkNotNull(param, "desc");
        if (param > max) {
            throw new ParamError(String.format("%s 不能大于 %s", desc, max));
        } else if (param < min) {
            throw new ParamError(String.format("%s 不能小于 %s", desc, min));
        }
    }

    /**
     * IP校验
     *
     * @param input
     */
    public static void checkIp(String input, String desc) {
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$|^0\\.0\\.0\\.0$";
        // 判断ip地址是否与正则表达式匹配
        if (!input.matches(regex)) {
            throw new ParamError(String.format("%s IP地址非法", desc));
        }
    }

    /**
     * 身份证校验
     *
     * @param input
     */
    public static void checkIdCard(String input) {
        //第一代身份证正则表达式(15位)
        String isIDCard1 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
        //第二代身份证正则表达式(18位)
        String isIDCard2 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[A-Z])$";

        //验证身份证
        if (!input.matches(isIDCard1) && !input.matches(isIDCard2)) {
            throw new ParamError(String.format("身份证格式错误"));
        }
    }

    /**
     * 分页检查
     */
    public static void checkPaging(Integer pageIndex, Integer pageSize) {
        checkNotNull(pageIndex, "分页数");
        checkNumberSize(1, null, pageIndex, "分页数");
        checkNotNull(pageSize, "分页大小");
        checkNumberSize(1, 50, pageSize, "分页大小");
    }

    public static boolean isMobile(final String str) {
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
