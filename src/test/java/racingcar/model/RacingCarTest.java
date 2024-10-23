package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void racingCar_WhenCarNameIsProvided_ShouldStoreNameAndInitializePosition() {
        // 자동차 이름이 정상적으로 저장되고 초기 위치가 0인지 확인
        RacingCar car = new RacingCar("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void racingCar_WhenRandomValueIsGreaterThanOrEqualToThreshold_ShouldMove() {
        // 무작위 값이 4 이상일 때 전진하는지 확인
        RacingCar car = new RacingCar("pobi");
        car.move(4); // 전진
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(5); // 전진
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void racingCar_WhenRandomValueIsLessThanThreshold_ShouldNotMove() {
        // 무작위 값이 4 미만일 때 전진하지 않는지 확인
        RacingCar car = new RacingCar("pobi");
        car.move(3); // 전진하지 않음
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void racingCar_DisplayPosition_ShouldReturnCorrectVisualRepresentation() {
        // 현재 위치에 따른 시각적 표현이 올바르게 반환되는지 확인
        RacingCar car = new RacingCar("pobi");
        car.move(4); // 전진
        car.move(4); // 전진
        assertThat(car.displayPosition()).isEqualTo("pobi : --");
    }

    @Test
    void racingCar_DisplayPositionWithZeroMoves_ShouldReturnInitialVisualRepresentation() {
        // 전진하지 않았을 때 시각적 표현이 올바르게 반환되는지 확인
        RacingCar car = new RacingCar("pobi");
        assertThat(car.displayPosition()).isEqualTo("pobi : ");
    }

}
