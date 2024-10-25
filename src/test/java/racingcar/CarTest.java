package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    static private Car car;

    @BeforeAll
    static void setUpCar() {
        car = new Car("test");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 9})
    void 정상_전진_테스트(int inboundNumber) {
        int prevScore = car.getScore();

        car.go(inboundNumber);

        assertThat(car.getScore()).isEqualTo(prevScore + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 범위_외_난수_전진_테스트(int outboundNumber) {
        int prevScore = car.getScore();

        car.go(outboundNumber);

        assertThat(car.getScore()).isEqualTo(prevScore);
    }
}
