/**
 * Please Visit: Fans Page Facebook: https://web.facebook.com/coverstarcomunity
 * Group Facebook: https://web.facebook.com/groups/454664331926261 Youtube:
 * https://www.youtube.com/channel/UClcEDDeJvnJ69p-n7XsRqHQ Instagram:
 * coverstarstory
 */
package com.example.datn.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author vietnq
 */
public class RandomUtil {

    private static final String NUMBER = "0123456789";

    private static SecureRandom random = new SecureRandom();

    public static String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString.toUpperCase();
    }
    
    public static String generateRandomStringNumber(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(NUMBER.length());
            char rndChar = NUMBER.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }
}
