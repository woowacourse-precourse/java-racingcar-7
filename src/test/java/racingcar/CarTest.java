package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class CarTest {
    Car car = new Car();

    @Test
    void 무브랜덤에_따라_거리의_값_증가() {
        int result = car.getDistance();
        if (car.isMove()) {
            assertThat(result).isEqualTo(1);
        }
        assertThat(result).isEqualTo(0);
    }
}