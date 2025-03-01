package com.graham.jcip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UnsafeSequenceTest {

    @Test
    public void shouldReturnUniqueValue() {
        int numberOfRuns = 1000;
        UnsafeSequence seq = new UnsafeSequence();

        for (int i = 0; i < numberOfRuns; i++) {
            var res = seq.getNext();
            assertEquals(res, i);
        }

    }
}
