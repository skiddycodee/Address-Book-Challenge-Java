package com.addressbook.test.utils;

import com.addressbook.app.utils.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStringUtils {

    @Test
    public void testCheckIfInputNotNull() {
        assertFalse(StringUtils.contactInputQuarantine(null));
    }

    @Test
    public void testCheckIfInputNotEmpty() {
        assertFalse(StringUtils.contactInputQuarantine(""));
    }
}