package racingcar.car.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.car.domain.Car;
import racingcar.global.util.ErrorMessage;
import racingcar.mock.FakeRandomHolder;

class CarServiceTest {
    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService(new FakeRandomHolder(4));
    }

    @Test
    @DisplayName("String형태로 데이터를 입력받으면 cars에 저장한다")
    void create() throws Exception {
        // given
        String input = "pobi,woni,jun";
        carService.create(input);

        // when
        List<Car> cars = carService.getCars();

        // then
        assertThat(cars).hasSize(3)
                .extracting("name", "move")
                .containsExactlyInAnyOrder(
                        Tuple.tuple("pobi", 0),
                        Tuple.tuple("woni", 0),
                        Tuple.tuple("jun", 0));
    }

    @ParameterizedTest
    @DisplayName("cars의 범위가 2~9사이가 아니라면 에러를 반환한다")
    @MethodSource("providedOutOfRangeCarCount")
    void OutOfRangeCarCount(String input) throws Exception {
        // then
        assertThatThrownBy(() -> carService.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CARS_RANGE.getMessage());
    }

    private static Stream<Arguments> providedOutOfRangeCarCount() {
        return Stream.of(
                Arguments.arguments("pobi"),
                Arguments.arguments("pobi,adf,adf,wer,as,vaasdf,werq,adf,qwer,aasdf"),
                Arguments.arguments("pobi, adf, adf, wer,as, vaasdf, werq, adf, qwer, aasdf")
        );
    }

    @Test
    @DisplayName("carService에서 move를 호출하면 랜덤 값 4이상일 시 +1을 한다")
    void carServiceMove() throws Exception {
        // given
        String input = "pobi,woni,jun";
        carService.create(input);
        List<Car> cars = carService.getCars();
        Car target = cars.get(0);

        // when
        carService.move(target);

        // then
        assertThat(target.getMove()).isEqualTo(1);
    }
}