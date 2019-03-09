package com.github.echat.util;

import java.util.Random;

/**
 * @author db1995
 */
public class EchatUtils {
    public static String generateRandomColor() {
        Random random = new Random();
        int a = random.nextInt(256);
        int b = random.nextInt(256);
        int c = random.nextInt(256);
        StringBuilder sb = new StringBuilder();
        sb.append("rgb(");
        sb.append(a).append(",");
        sb.append(b).append(",");
        sb.append(c);
        sb.append(")");
        return sb.toString();
    }
}
