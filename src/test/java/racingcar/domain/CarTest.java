package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    private static final Car CAR_MARU = new Car("maru", 2);

    @Test
    void Car_객체_생성() {
        Car car = new Car("maru", 0);
        assertThat(car).isEqualTo(new Car("maru", 0));
    }

    @Test
    void 전진() {
        assertThat(CAR_MARU.decideMove(4)).isEqualTo(new Car("maru", 3));
    }

    @Test
    void 정지() {
        assertThat(CAR_MARU.decideMove(3)).isEqualTo(CAR_MARU);
    }

    @Test
    void 더_큰_위치값_구하기() {
        int position = 4;
        assertThat(CAR_MARU.getLargerMove(position)).isEqualTo(4);
    }

    @Test
    void 같은_위치값인지_판단하기() {
        assertThat(CAR_MARU.isSameMaxMove(2)).isTrue();
        assertThat(CAR_MARU.isSameMaxMove(3)).isFalse();
    }

    @Test
    void 자동차_이름_반환() {
        assertThat(CAR_MARU.getName()).isEqualTo("maru");
    }

    @Test
    void to_string() {
        assertThat(CAR_MARU.toString()).isEqualTo("maru : --\n");
    }
}
