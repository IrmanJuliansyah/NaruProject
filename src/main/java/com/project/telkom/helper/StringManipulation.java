package com.project.telkom.helper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

/**
 *
 * @author Irman Juliansyah <irmanjuliansyah@gmail.com>
 */
public class StringManipulation {

    public static String createNewFileName() {
        return UUID.randomUUID().toString() + ".png";
    }

    public static byte[] base64ToByte(String base64) {
        return Base64.getDecoder().decode(base64.getBytes(StandardCharsets.UTF_8));
    }
}
