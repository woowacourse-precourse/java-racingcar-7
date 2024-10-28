package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.car.Position;

public class CarTest {

    @Test
    void 자동차_객체_생성시_이름이_정상적으로_저장되는지_테스트() {
        String name = "bmw";
        Car car = new Car(name);
        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 자동차_객체_생성시_초기위치_0인지_테스트() {
        Car car = new Car("tesla");
        Assertions.assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 전진_조건_미달_3_이하_숫자_테스트(int number) {
        Car car = new Car("tesla");
        car.move(number);
        Assertions.assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진_조건_충족_4_이상_테스트(int number) {
        Car car = new Car("tesla");
        car.move(number);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_추가_테스트() {
        String name = "audi";
        Cars cars = new Cars();
        Car car = new Car(name);
        cars.addCar(car);
        Assertions.assertThat(cars.getCars()).hasSize(1);
        Assertions.assertThat(cars.getCars().get(0).getName()).isEqualTo(name);
    }

    @Test
    void 우승자_한명일때_반환_테스트() {
        Cars cars = new Cars();
        Car winner = new Car("audi");
        Car loser = new Car("tesla");
        cars.addCar(winner);
        cars.addCar(loser);
        winner.move(4);
        loser.move(3);

        List<String> winners = cars.findWinners();

        Assertions.assertThat(winners).hasSize(1);
        Assertions.assertThat(winners.get(0)).isEqualTo("audi");
    }

    @Test
    void 우승자_여러명일때_반환_테스트() {
        Cars cars = new Cars();
        Car winner1 = new Car("audi");
        Car winner2 = new Car("porsche");
        Car loser = new Car("benz");
        cars.addCar(winner1);
        cars.addCar(winner2);
        cars.addCar(loser);
        winner1.move(4);
        winner2.move(5);
        loser.move(3);

        List<String> winners = cars.findWinners();

        Assertions.assertThat(winners).hasSize(2);
        Assertions.assertThat(winners).containsExactly("audi", "porsche");
    }

    @Test
    void 위치_문자열_변환_테스트() {
        Position position = new Position(3);
        String result = position.toString();
        Assertions.assertThat(result).isEqualTo("---");
    }
}
