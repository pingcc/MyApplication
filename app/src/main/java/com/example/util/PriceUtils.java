package com.example.util;

import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.EditText;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mac on 2017/5/12.
 */

public class PriceUtils {


    public static String formatPrice(Double price) {
        if (price == null) {
            return "";
        }
        DecimalFormat decimalFormat;
        if (price == 0)
            decimalFormat = new DecimalFormat("###################.##");
        else
            decimalFormat = new DecimalFormat("##################0.00");
        return decimalFormat.format(price);
    }

    public static String formatPriceNoZero(Double price) {
        if (price == null) {
            return "";
        }
        DecimalFormat decimalFormat;
        if (price == 0)
            decimalFormat = new DecimalFormat("###################.##");
        else
            decimalFormat = new DecimalFormat("##################0.##");
        return decimalFormat.format(price);
    }
    /**
     * 提供精确加法计算的add方法
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确减法运算的sub方法
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static String mul(double value1, double value2) {
        return formatPrice(mulDouble(value1, value2));
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double mulDouble(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * * 提供精确的除法运算方法div
     * * @param value1 被除数
     * * @param value2 除数
     * * @param scale 精确范围
     * * @return 两个参数的商
     * * @throws IllegalAccessException
     */
    public static double div(double value1, double value2, int scale) throws
            IllegalAccessException {
        //如果精确范围小于0，抛出异常信息
        if (scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.divide(b2, scale).doubleValue();
    }

    /**
     * 价格输入框输入设置
     *
     * @param et : 被设置的  EditText 对象
     */
    public static void priceETSetting(EditText et) {
        /**不能复制,粘贴*/
        et.setLongClickable(false);

        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            int textLength = text.length();

                /**这是删除*/
            if (TextUtils.equals("", source)) {
                    String deleteChar = text.substring(dstart, dend);
                /**删除的是 .*/
                    if (TextUtils.equals(".", deleteChar)) {
                        if (textLength - 1 > 4 && textLength > dend) {
                            return ".";
                        }
                    }
                /*   这操作剪切会报错
                 if (dstart == 0 && textLength > 1) {//删除的是第一位
                        String deleteNextChar = text.substring(dstart + 1, dend + 1);//下一位
                        if (TextUtils.equals(".", deleteNextChar)) {   //删除的是 0  后面.
                            return "0";
                        }
                    }*/
            }

            if (source.equals(".")) {

                if (dstart == 0) {
                    return "0.";
                }

                if (textLength - dend > 2) {
                    return "";
                }

                if (!text.contains(".")) {
                    return null;
                }

            }
            if (text.contains(".")) {
                int index = text.indexOf(".");
                    /**小数点后面也可以写数字*/
                if (textLength - index <= 2 && dstart > index) {
                    return null;
                }

                int length = text.substring(index).length();
                if (length == 3 && dstart > index) {
                    return "";
                }


            }
            //第一位不能添加0
            if (source.equals("0") && dstart == 0 && textLength > 0) {
                return "";
            }

            //第一位为0,第二位不能添加0
            if (source.equals("0") && dstart == 1 && text.startsWith("0")) {
                return "";
            }


            return null;
        }});
    }

    /**
     * 数量输入框输入设置
     */
    public static void numberETSetting(EditText et) {
        //不能复制,粘贴
        et.setLongClickable(false);
        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            int textLength = text.length();
            if (source.length() + textLength > 4) {
                return source.subSequence(0, 4 - textLength);
            }

            //不能有.
            if (source.equals(".")) {
                return "";
            }
            //第一位不能添加0
            if (source.equals("0") && dstart == 0) {
                return "";
            }
            if (text.length() >= 4) {
                return "";
            }

            return null;
        }});
    }

    /**
     * 数量输入框输入设置,可以输入0
     */
    public static void numberETZeroSetting(EditText et) {
        //不能复制,粘贴
        et.setLongClickable(false);

        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            int textLength = text.length();
            if (source.length() + textLength > 4) {
                return source.subSequence(0, 4 - textLength);
            }

            //不能有.
            if (source.equals(".")) {
                return "";
            }
            //第一位为0
            if (dstart == 0 && source.equals("0")) {
                //第二位不能再输
                if (dstart == 1)
                    return "";
            }
            if (text.length() >= 4) {
                return "";
            }

            return null;
        }});
    }

    /**
     * 数量输入框输入设置 ,可输入负数
     */
    public static void numberNegativeETSetting(EditText et) {
        //不能复制,粘贴
        et.setLongClickable(false);

        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            int textLength = text.length();
            if (source.length() + textLength > 4) {
                return source.subSequence(0, 4 - textLength);
            }


            //不能有.
            if (source.equals(".")) {
                return "";
            }
            //第一位为0
            if (dstart == 0 && source.equals("0")) {
                //第二位不能再输
                if (dstart == 1)
                    return "";
            }
            //长度大于0，第一位不能输入0
            if (textLength > 0) {
                if (dstart == 0 && source.equals("0"))
                    return "";
            }
            //如果是负数
            if (text.contains("-")) {
                //第二位不能输入0
                if (dstart == 1 && source.equals("0"))
                    return "";
            }


            if (text.length() >= 4) {
                return "";
            }

            return null;
        }});
    }

    /**
     * 发货输入快递单号
     */
    public static void numberTextETSetting(EditText et) {
        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            if (text.length() > 20)
                return "";


            String regExp = "^[A-Za-z0-9]$";
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(source);
            if (!matcher.matches()) {
                return "";
            }

            return null;
        }});
    }


    /**
     * 打折输入框输入设置
     * 最大为9.9
     */
    public static void discountETSetting(EditText et) {
        et.setFilters(new InputFilter[]{(source, start, end, dest, dstart, dend) -> {
            String text = dest.toString();
            //这是删除
            if (TextUtils.equals("", source)) {
                String deleteChar = text.substring(dstart, dend);
                //删除的是 .
                if (TextUtils.equals(".", deleteChar)) {
                    if (text.length() > dend)
                        return ".";
                }
            }
            if (text.contains(".")) {
                int index = text.indexOf(".");
                int length = text.substring(index).length();
                //小数点后面1位
                if (length == 2 && dstart > index) {
                    return "";
                }
            }
            //最多输入两位
            if (text.length() > 2)
                return "";

            //判断第一位输入.
            if (dstart == 0 && source.equals("."))
                return "";

            //第二位不等于.
            if ((dstart == 1) && !source.equals("."))
                return "";

            //第三位等于.
            if ((dstart == 2) && source.equals("."))
                return "";

            //大于三位
            if (dstart > 2)
                return "";

            //可以返回
            return null;
        }});
    }
}
