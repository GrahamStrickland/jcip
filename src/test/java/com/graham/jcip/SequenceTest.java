package com.graham.jcip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

public class SequenceTest {

    @Test
    public void shouldReturnUniqueValue() throws ExecutionException, InterruptedException {
        int numberOfThreads = 10;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        Sequence seq = new Sequence();

        for (int i = 0; i < numberOfThreads; i++) {
            Future<Integer> result = service.submit(() -> {
                latch.countDown();
                return seq.getNext();
            });
            assertEquals(result.get(), i);
        }
    }
}
