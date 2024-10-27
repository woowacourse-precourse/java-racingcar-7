package racingcar.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.CarList;
import racingcar.model.Drivable;
import racingcar.model.RacingCar;

class CarListCollectorTest {

    static Stream<List<Drivable>> singleCarProvider() {
        return Stream.of(
                List.of(new RacingCar("Car1"))
        );
    }

    static Stream<List<Drivable>> multipleCarProvider() {
        return Stream.of(
                List.of(new RacingCar("Car1"), new RacingCar("Car2")),
                List.of(new RacingCar("CarA"), new RacingCar("CarB"))
        );
    }

    @DisplayName("단일 차량 수집기 테스트")
    @ParameterizedTest(name = "단일 차량 수집: {0}")
    @MethodSource("singleCarProvider")
    void 단일차량_수집기_테스트(List<Drivable> cars) {
        // when
        CarList carList = cars.stream()
                .collect(CarListCollector.toCarList());

        // then
        assertNotNull(carList);
        assertEquals(1, carList.getAllCars().size());
        assertEquals("Car1", carList.getAllCars().get(0).getName());
    }

    @DisplayName("다수 차량 수집기 테스트")
    @ParameterizedTest(name = "다수 차량 수집: {0}")
    @MethodSource("multipleCarProvider")
    void 다수차량_수집기_테스트(List<Drivable> cars) {
        // when
        CarList carList = cars.stream()
                .collect(CarListCollector.toCarList());

        // then
        assertNotNull(carList);
        assertEquals(cars.size(), carList.getAllCars().size());
        for (int i = 0; i < cars.size(); i++) {
            assertEquals(cars.get(i).getName(), carList.getAllCars().get(i).getName());
        }
    }

    @Test
    void 차량목록_병합_수집기_테스트() {
        // given
        Drivable car1 = new RacingCar("Car1");
        Drivable car2 = new RacingCar("Car2");
        Drivable car3 = new RacingCar("Car3");

        // when
        CarList carList = List.of(car1, car2).stream()
                .collect(Collectors.collectingAndThen(
                        CarListCollector.toCarList(),
                        list -> {
                            list.addCar(car3);
                            return list;
                        }));

        // then
        assertNotNull(carList);
        assertEquals(3, carList.getAllCars().size());
        assertEquals("Car1", carList.getAllCars().get(0).getName());
        assertEquals("Car2", carList.getAllCars().get(1).getName());
        assertEquals("Car3", carList.getAllCars().get(2).getName());
    }
}
