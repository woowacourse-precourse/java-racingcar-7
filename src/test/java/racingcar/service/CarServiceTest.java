package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    private final CarService carService = new CarService();

    @Test
    void 자동차_리스트_생성_테스트() {
        carService.createCarList("pobi,woni,jun");

        List<Car> carList = carService.getCarList();

        assertEquals(3, carList.size());

        assertTrue(carList.stream()
                .anyMatch(car -> car.getName().equals("pobi")));
        assertTrue(carList.stream()
                .anyMatch(car -> car.getName().equals("woni")));
        assertTrue(carList.stream()
                .anyMatch(car -> car.getName().equals("jun")));
    }

    @Test
    void 자동차_리스트_중복이름_미생성_테스트() {
        carService.createCarList("pobi,woni,pobi");

        List<Car> carList = carService.getCarList();

        assertEquals(2, carList.size());

        assertTrue(carList.stream()
                .anyMatch(car -> car.getName().equals("pobi")));
        assertTrue(carList.stream()
                .anyMatch(car -> car.getName().equals("woni")));
    }

    @Test
    void 빈문자열_입력시_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> carService.createCarList(null));
        assertThrows(IllegalArgumentException.class, () -> carService.createCarList(""));
        assertThrows(IllegalArgumentException.class, () -> carService.createCarList(" "));
    }

    @Test
    void 잘못된_자동차_이름_입력시_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> carService.createCarList("pobi,,jun"));
        assertThrows(IllegalArgumentException.class, () -> carService.createCarList(",woni,jun"));
        assertThrows(IllegalArgumentException.class, () -> carService.createCarList("popobi,woni,jun"));
    }
}
