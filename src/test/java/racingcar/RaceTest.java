package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RaceTest {
    @Test
    void 자동차경주_총라운드_최소_1회() {
        assertThrows(IllegalArgumentException.class, () -> new Race(0));
        assertThrows(IllegalArgumentException.class, () -> new Race(-1));
    }
}
