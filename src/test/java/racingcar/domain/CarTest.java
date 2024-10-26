package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    private final Car CAR_POBI = new Car("pobi", 0);

    @Test
    void Car_객체_생성() {
        assertThat(CAR_POBI).isEqualTo(new Car("pobi", 0));
    }

    @Test
    void 전진() {
        assertThat(CAR_POBI.move(4)).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void 정지() {
        assertThat(CAR_POBI.move(3)).isEqualTo(new Car("pobi", 0));
    }
}
