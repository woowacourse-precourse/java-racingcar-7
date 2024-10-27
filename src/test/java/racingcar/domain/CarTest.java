package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CarTest {

    private static final Car CAR_MARU = new Car("maru", 0);

    static Stream<Object[]> carGenerator() {
        return Stream.of(
                new Object[]{new Car("maru"), CAR_MARU},
                new Object[]{new Car("maru", 0), CAR_MARU},
                new Object[]{new Car(new Name("maru"), 0), CAR_MARU},
                new Object[]{new Car(new Name("maru"), new Position(0)), CAR_MARU}
        );
    }

    @ParameterizedTest
    @MethodSource("carGenerator")
    void Car_생성(Car inputCar, Car expectedCar) {
        assertThat(inputCar).isEqualTo(expectedCar);
    }

    @Test
    void 랜덤값_4이상이면_자동차_전진() {
        assertThat(CAR_MARU.decideMove(4)).isEqualTo(new Car("maru", 1));
    }

    @Test
    void 랜덤값_4미만이면_자동차_정지() {
        assertThat(CAR_MARU.decideMove(3)).isEqualTo(CAR_MARU);
    }

    @Test
    void 더_큰_위치값() {
        int position = 4;
        assertThat(CAR_MARU.getMaxMove(position)).isEqualTo(4);
    }

    @Test
    void 인자로_들어온_다른_차의_전진_최댓값과_같은지_판단() {
        assertThat(CAR_MARU.isSameMaxMove(0)).isTrue();
        assertThat(CAR_MARU.isSameMaxMove(1)).isFalse();
    }

    @Test
    void 자동차_이름_반환() {
        assertThat(CAR_MARU.getName()).isEqualTo("maru");
    }

    @Test
    void to_string() {
        Car car = new Car("pobi", 3);
        
        assertThat(car.toString()).isEqualTo("pobi : ---\n");
    }
}
