package com.changebill.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ChangeBillExceptionTest {
    @Test
    void testConstructor() {
        ChangeBillException actualChangeBillException = new ChangeBillException("An error occurred");
        assertNull(actualChangeBillException.getCause());
        assertEquals("com.changebill.exception.ChangeBillException: An error occurred",
                actualChangeBillException.toString());
        assertEquals(0, actualChangeBillException.getSuppressed().length);
        assertEquals("An error occurred", actualChangeBillException.getMessage());
        assertEquals("An error occurred", actualChangeBillException.getLocalizedMessage());
    }
}

