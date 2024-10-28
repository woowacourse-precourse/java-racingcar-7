package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("포지션을 생성한다.")
    @Test
    void createPosition() {
        //given
        Position position = new Position(0);
        //when
        //then
        assertThat(position)
            .extracting("value")
            .isEqualTo(0);
    }

    @DisplayName("위치를 전진시킨다.")
    @Test
    void moveForwardTest() {
        //given
        Position position = new Position(0);
        //when
        position.moveForward();
        //then
        assertThat(position)
            .extracting("value")
            .isEqualTo(1);
    }

    @DisplayName("위치를 문자열로 반환한다.")
    @Test
    void notationsTest() {
        //given
        Position position = new Position(3);
        //when
        String notations = position.getNotations();
        //then
        assertThat(notations)
            .isEqualTo("---");
    }

    @DisplayName("위치를 비교한다.")
    @ParameterizedTest
    @CsvSource(value = {"3, 0, false", "3, 3, true"})
    void isEqualPositionValue(int givenValue, int compareValue, boolean expected) {
        //given
        Position position = new Position(givenValue);
        //when
        boolean result = position.isEqualTo(compareValue);
        //then
        assertThat(result)
            .isEqualTo(expected);
    }

}