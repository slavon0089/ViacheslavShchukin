package utils;

import io.qameta.allure.Attachment;

public class AttachmentUtils {

    @Attachment(type = "image/png", value  = "try to use param")
    public static byte [] makeImageAttachment(final String name, final byte[] source) {
        return source;
    }
}
