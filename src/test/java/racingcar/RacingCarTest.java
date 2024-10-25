package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import java.util.List;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Winners;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;
import racingcar.mock.TestRandomNumberGenerator;
import racingcar.utils.RandomGenerator;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    void 자동차_생성_테스트() {
        Car car = new Car("MCshin00");

        assertThat(car.getName()).isEqualTo("MCshin00");
    }

    @Test
    void 자동차_리스트_생성_테스트() {
        Car car = new Car("MCshin00");
        Car car2 = new Car("asdf1234");
        RandomGenerator randomNumberGenerator = new RandomNumberGenerator();
        Cars cars = new Cars(List.of(car, car2), randomNumberGenerator);

        CarsDto carsDto = cars.toDto();
        List<String> carNames = List.of("MCshin00", "asdf1234");

        assertThat(carsDto.getCars().stream()
                .map(CarDto::getName))
                .containsExactlyElementsOf(carNames);
    }

    @Test
    void 자동차_전진_테스트() {
        Car car = new Car("MCshin00");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_멈춤_테스트() {
        Car car = new Car("MCshin00");

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

        new OutputView().printRoundResultOutput(cars.toDto());

        assertThat(out.toString()).isEqualTo("실행 결과" + System.lineSeparator() + "car1 : -" +
                System.lineSeparator() + "car2 : " + System.lineSeparator());
    }
}
