package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    @DisplayName("음수 라운드 생성 불가능")
    @Test
    void negativeRound() {
        assertThrows(IllegalArgumentException.class, () -> {Round.of("-4");});
    }

    @DisplayName("문자열 라운드 생성 불가능")
    @Test
    void stringRound() {
        assertThrows(IllegalArgumentException.class, () -> {Round.of("three");});
    }

    @DisplayName("라운드 생성 성공")
    @Test
    void createRound() {
       Round round = Round.of("4");
        assertTrue(round.hasRound());
    }

    @DisplayName("라운드 진행시 라운드 감소")
    @Test
    void reduce() {
        Round round = Round.of("1");
        round.reduceRound();
        assertFalse(round.hasRound());
    }
}