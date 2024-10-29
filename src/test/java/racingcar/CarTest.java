package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;
import racingcar.model.domain.Cars;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void 자동차_이름_설정_테스트() {
        Car car = Car.from("growi");
        assertEquals("growi", car.getName());
    }
    @Test
    void 자동차_이름_길이_초과_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                Car.from("growingpsy"));
    }
    @Test
    void 빈_이름_입력_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                Car.from(""));
    }
    @Test
    void 공백_이름_입력_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                Car.from(" "));
    }
    @Test
    void 자동차의_처음위치는_0이다() {
        Car car = Car.from("name");
        assertEquals(0, car.getPosition());
    }
    @Test
    void 자동차_전진_테스트() {
        Car car = Car.from("name");
        Car movedCar = car.moveForward(4);
        assertEquals(1, movedCar.getPosition());
    }

    @Test
    void 자동차_정지_테스트() {
        Car car = Car.from("name");
        Car movedCar = car.moveForward(3);
        assertEquals(0, movedCar.getPosition());
    }
    @Test
    void 여러_자동차_생성_테스트() {
        List<String> names = List.of("pobi", "woni");
        Cars cars = Cars.from(names);
        assertEquals(names, cars.getNames());
    }

    @Test
    void 자동차_우승자_결정_테스트() {
        List<String> names = List.of("pobi", "woni", "jun");
        Cars cars = Cars.from(names, new NumberGeneratorTest(List.of(4, 4, 3, 4, 4, 3, 4, 4, 3)));

        Cars finalCars = cars.moveForward()
                .moveForward()
                .moveForward();
        List<String> winners = finalCars.findWinners();

        assertEquals(List.of("pobi", "woni"), winners);
    }
}
