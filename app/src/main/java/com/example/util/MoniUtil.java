package com.example.util;

import java.util.Random;

/**
 * Created  on 2017/12/27.
 * author  CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */

public class MoniUtil {
    public static String getRandomIp() {
        //ip的范围
        int[][] range_ip = {{607649792, 608174079},//36.56.0.0-36.63.255.255
                {1038614528, 1039007743},//61.232.0.0-61.237.255.255
                {1783627776, 1784676351},//106.80.0.0-106.95.255.255
                {2035023872, 2035154943},//121.76.0.0-121.77.255.255
                {2078801920, 2079064063},//123.232.0.0-123.235.255.255
                {-1950089216, -1948778497},//139.196.0.0-139.215.255.255
                {-1425539072, -1425014785},//171.8.0.0-171.15.255.255
                {-1236271104, -1235419137},//182.80.0.0-182.92.255.255
                {-770113536, -768606209},//210.25.0.0-210.47.255.255
                {-569376768, -564133889}, //222.16.0.0-222.95.255.255
        };
        //生成一个随机数
        Random random = new Random();
        int index = random.nextInt(10);
        String ip = numToip(range_ip[index][0] + new Random().nextInt(range_ip[index][1] - range_ip[index][0]));//获取ip

        return ip;
    }

    /**
     * 数字拼接成ip字符串
     *
     * @param ip
     * @return
     */
    private static String numToip(int ip) {
        int[] b = new int[4];

        b[0] = (int) ((ip >> 24) & 0xff);
        b[1] = (int) ((ip >> 16) & 0xff);
        b[2] = (int) ((ip >> 8) & 0xff);
        b[3] = (int) (ip & 0xff);
        String ip_str = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);
        return ip_str;
    }
}
