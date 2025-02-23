package com.graham.jcip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import org.junit.jupiter.api.Test;

public class UnsafeSequenceTest {

    @Test
    public void shouldReturnUniqueValue() {
        int numberOfThreads = 10;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        UnsafeSequence seq = new UnsafeSequence();

        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                seq.getNext();
                latch.countDown();
            });
        }
        assertEquals(9, seq.getNext());
    }
}
