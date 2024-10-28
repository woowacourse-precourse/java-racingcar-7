package racingcar.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private final AtomicLong sequence = new AtomicLong(0L);

    public Long generate() {
        return sequence.incrementAndGet();
    }

}
