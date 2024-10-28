package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_객체_생성_및_초기_위치_확인() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 랜덤_숫자에_따른_자동차_전진_여부_확인() {
        Car car = new Car("pobi");

        car.moveIfPossible(4);
        assertThat(car.getPosition())
                .as("랜덤 숫자가 4 이상일 때 전진해야 합니다.")
                .isEqualTo(1);

        car.moveIfPossible(3);
        assertThat(car.getPosition())
                .as("랜덤 숫자가 3 이하일 때 전진하지 않아야 합니다.")
                .isEqualTo(1);
    }
}
