package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ScoreTest {
    Score score;
    @BeforeEach
    void setUp() {
        score = new Score();
    }
    @Test
    @DisplayName("Default Score should be 0")
    void testDefaultScore() {
        assertEquals(0, score.getValue());
    }

    @Test
    @DisplayName("Increase method should return the score with adding one")
    void testIncreaseScore() {
        assertEquals(1, score.increase());
    }

    @Test
    @DisplayName("Increase method should return the score with adding one")
    void testIncreasedScore() {
        score.increase();
        assertEquals(1, score.getValue());
    }
}