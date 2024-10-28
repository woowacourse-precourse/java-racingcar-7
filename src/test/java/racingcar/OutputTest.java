package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.RandomGenerator;
import racingcar.domain.Winners;
import racingcar.mock.TestRandomNumberGenerator;
import racingcar.view.OutputView;

public class OutputTest {
    final OutputStream out = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    static Stream<Arguments> createCarList() {
        return Stream.of(
                Arguments.of(List.of(new Car("car1"), new Car("car2")))
        );
    }

    @ParameterizedTest
    @MethodSource("createCarList")
    void 차수별_실행_결과_출력_테스트(List<Car> carList) {
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,3));
        Cars cars = new Cars(carList, testRandomNumberGenerator);

        cars.moveAll();
        OutputView.printRoundResultOutput(cars.toDto());

        assertThat(out.toString()).isEqualTo("car1 : -" + System.lineSeparator() +
                "car2 : " + System.lineSeparator() + System.lineSeparator());
    }

    @ParameterizedTest
    @MethodSource("createCarList")
    void 단독_우승자_출력_테스트(List<Car> carList) {
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,3));
        Cars cars = new Cars(carList, testRandomNumberGenerator);

        cars.moveAll();
        Winners winners = new Winners(cars.getWinners());
        OutputView.printWinnersOutput(winners.getWinnersList());

        assertThat(out.toString().trim()).isEqualTo("최종 우승자 : car1");
    }

    @ParameterizedTest
    @MethodSource("createCarList")
    void 공동_우승자_출력_테스트(List<Car> carList) {
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,4));
        Cars cars = new Cars(carList, testRandomNumberGenerator);

        cars.moveAll();
        Winners winners = new Winners(cars.getWinners());
        OutputView.printWinnersOutput(winners.getWinnersList());

        assertThat(out.toString().trim()).isEqualTo("최종 우승자 : car1, car2");
    }
}
