package com.changebill.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ErrorResponseTest {
    @Test
    void testConstructor() {
        ErrorResponse actualErrorResponse = new ErrorResponse("message", new ArrayList<>());
        ArrayList<String> stringList = new ArrayList<>();
        actualErrorResponse.setDetails(stringList);
        actualErrorResponse.setMessage("error");
        assertSame(stringList, actualErrorResponse.getDetails());
        assertEquals("error", actualErrorResponse.getMessage());
    }
}

