package racingcar.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong sequence = new AtomicLong();

    public Long generate() {
        return sequence.incrementAndGet();
    }

}
