package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringPerformanceTest {
    private final int count = 100000;
    private final int threadCount = 2;

    private String s;
    private StringBuffer sbf;
    private StringBuilder sbd;

    @BeforeEach
    void setVariable() {
        s = "";
        sbf = new StringBuffer();
        sbd = new StringBuilder();
    }

    @Test
    void compareStringStringBuilder() {
        long stringTime = measureStringTime();
        long stringBufferTime = measureStringBufferTime();
        long stringBuilderTime = measureStringBuilderTime();

        String result = "String time: " + stringTime + "\n"
                + "StringBuffer time: " + stringBufferTime + "\n"
                + "StringBuilder time: " + stringBuilderTime;
        System.out.println(result);
    }

    @Test
    void threadSafeTest() throws InterruptedException {
        doMultiThread(this::loopString);
        doMultiThread(this::loopStringBuffer);
        doMultiThread(this::loopStringBuilder);

        String result = "String length: " + s.length() + "\n"
                + "StringBufferTime length: " + sbf.length() + "\n"
                + "StringBuilder: " + sbd.length();
        System.out.println(result);
    }

    private void doMultiThread(Runnable task) throws InterruptedException {
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }
    }

    long measureStringTime() {
        long startTime = System.currentTimeMillis();
        loopString();
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    long measureStringBufferTime() {
        long startTime = System.currentTimeMillis();
        loopStringBuffer();
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    long measureStringBuilderTime() {
        long startTime = System.currentTimeMillis();
        loopStringBuilder();
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private void loopString() {
        for (int i = 0; i < count; i++) {
            s += IOMessage.MOVEMENT_SIGN;
        }
    }

    private void loopStringBuffer() {
        for (int i = 0; i < count; i++) {
            sbf.append(IOMessage.MOVEMENT_SIGN);
        }
    }

    private void loopStringBuilder() {
        for (int i = 0; i < count; i++) {
            sbd.append(IOMessage.MOVEMENT_SIGN);
        }
    }
}
