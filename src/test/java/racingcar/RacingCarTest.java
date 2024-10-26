package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.StringSeparator.separate;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Winners;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;
import racingcar.mock.TestRandomNumberGenerator;
import racingcar.view.OutputView;

public class RacingCarTest {
    @Test
    void 자동차_생성_테스트() {
        Car car = new Car("MCs");

        assertThat(car.getName()).isEqualTo("MCs");
    }

    @Test
    void 자동차_리스트_생성_테스트() {
        Car car = new Car("MCs");
        Car car2 = new Car("asdf");
        RandomGenerator randomNumberGenerator = new RandomNumberGenerator();
        Cars cars = new Cars(List.of(car, car2), randomNumberGenerator);

        CarsDto carsDto = cars.toDto();
        List<String> carNames = List.of("MCs", "asdf");

        assertThat(carsDto.getCars().stream()
                .map(CarDto::getName))
                .containsExactlyElementsOf(carNames);
    }

    @Test
    void 자동차_전진_테스트() {
        Car car = new Car("MCs");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_멈춤_테스트() {
        Car car = new Car("MCs");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전체_이동_테스트() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> carList = List.of(car1, car2);
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,3));
        Cars cars = new Cars(carList, testRandomNumberGenerator);

        cars.moveAll();

        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(0);
    }

    @Test
    void 단독_우승자_결정_테스트() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> carList = List.of(car1, car2);
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,3));
        Cars cars = new Cars(carList, testRandomNumberGenerator);
        Winners winners;

        cars.moveAll();
        winners = new Winners(cars.getWinners());

        assertThat(winners.getWinnersList()).isEqualTo("car1");
    }

    @Test
    void 공동_우승자_결정_테스트() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> carList = List.of(car1, car2);
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,4));
        Cars cars = new Cars(carList, testRandomNumberGenerator);
        Winners winners;

        cars.moveAll();
        winners = new Winners(cars.getWinners());

        assertThat(winners.getWinnersList()).isEqualTo("car1, car2");
    }

    @Test
    void 차수별_실행_결과_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> carList = List.of(car1, car2);
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,3));
        Cars cars = new Cars(carList, testRandomNumberGenerator);

        cars.moveAll();

        OutputView.printRoundResultOutput(cars.toDto());

        assertThat(out.toString()).isEqualTo("car1 : -" + System.lineSeparator() +
                "car2 : " + System.lineSeparator() + System.lineSeparator());
    }

    @Test
    void 단독_우승자_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> carList = List.of(car1, car2);
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,3));
        Cars cars = new Cars(carList, testRandomNumberGenerator);
        Winners winners;

        cars.moveAll();
        winners = new Winners(cars.getWinners());

        OutputView.printWinnersOutput(winners.getWinnersList());

        assertThat(out.toString().trim()).isEqualTo("최종 우승자 : car1");
    }

    @Test
    void 공동_우승자_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> carList = List.of(car1, car2);
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,4));
        Cars cars = new Cars(carList, testRandomNumberGenerator);
        Winners winners;

        cars.moveAll();
        winners = new Winners(cars.getWinners());

        OutputView.printWinnersOutput(winners.getWinnersList());

        assertThat(out.toString().trim()).isEqualTo("최종 우승자 : car1, car2");
    }
}
