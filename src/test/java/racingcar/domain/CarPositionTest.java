package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {

    @DisplayName("position을 증가시킬 수 있다.")
    @Test
    void canIncreasePosition() {
        //given
        CarPosition carPosition = new CarPosition();
        //when
        carPosition.increase();
        //then
        assertThat(carPosition.getPosition()).isEqualTo(1);
    }

    @DisplayName("다른 차 포지션보다 자신의 포지션이 높으면 true를 반환한다.")
    @Test
    void comparisonReturnsTrueWhenGreater() {
        //given
        CarPosition myPosition = new CarPosition();
        CarPosition otherPosition = new CarPosition();
        //when
        myPosition.increase();
        boolean greaterThan = myPosition.isGreaterThan(otherPosition);
        //then
        assertThat(greaterThan).isTrue();
    }

    @DisplayName("다른 차 포지션보다 자신의 포지션이 낮으면 false를 반환한다.")
    @Test
    void comparisonReturnsFalseWhenOtherPositionIsGreater() {
        //given
        CarPosition myPosition = new CarPosition();
        CarPosition otherPosition = new CarPosition();
        //when
        otherPosition.increase();
        boolean greaterThan = myPosition.isGreaterThan(otherPosition);
        //then
        assertThat(greaterThan).isFalse();
    }

    @DisplayName("두 차의 포지션이 동일한 경우 false를 반환한다.")
    @Test
    void comparisonReturnsFalseWhenPositionsAreEqual() {
        //given
        CarPosition myPosition = new CarPosition();
        CarPosition otherPosition = new CarPosition();
        myPosition.increase();
        otherPosition.increase();
        //when
        boolean result = myPosition.isGreaterThan(otherPosition);
        //then
        assertThat(result).isFalse();
    }
}