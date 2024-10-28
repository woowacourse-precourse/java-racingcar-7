package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;


class CarServiceTest {
    private final CarService carService = new CarService();
    Car coh = new Car("coh");
    Car pobi = new Car("pobi");
    Car jun = new Car("jun");
    @Test
    void 자동차입력_테스트() {
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter(null));
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter(",,,"));
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter("pobi,,coh"));
        assertThrows(IllegalArgumentException.class, () -> carService.getCarsByDelimiter(""));

        Assertions.assertThat(carService.getCarsByDelimiter("pobi,coh,line")).isEqualTo("pobi,coh,line".split(","));
    }

    @Test
    void 숫자변환_테스트() {
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber(null));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber(" "));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber(""));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("a"));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("5.3"));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("-1"));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("0"));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("2147483648"));
        assertThrows(IllegalArgumentException.class, () -> carService.getNumber("-2147483649"));

        Assertions.assertThat(carService.getNumber("5")).isEqualTo(5);
        Assertions.assertThat(carService.getNumber("2147483647")).isEqualTo(2147483647);
    }

    @Test
    void 우승자_테스트() {
        List<Car> cars = List.of(coh, pobi, jun);
        coh.moveIfAboveThreshold(5);
        Assertions.assertThat(carService.getWinner(cars)).isEqualTo("coh");
    }
    @Test
    void 공동우승자_테스트() {
        List<Car> cars = List.of(coh, pobi, jun);
        coh.moveIfAboveThreshold(5);
        pobi.moveIfAboveThreshold(5);
        jun.moveIfAboveThreshold(5);

        Assertions.assertThat(carService.getWinner(cars)).isEqualTo("coh,pobi,jun");
    }
}