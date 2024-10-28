package racingcar.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.RacingCarList;
import racingcar.model.Drivable;
import racingcar.model.RacingCar;

class RacingCarListCollectorTest {

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

    @DisplayName("Single Car Collector Test")
    @ParameterizedTest(name = "Collecting single car: {0}")
    @MethodSource("singleCarProvider")
    void singleCarCollectorTest(List<Drivable> cars) {

        RacingCarList racingCarList = cars.stream()
                .collect(CarListCollector.toCarList());

        assertNotNull(racingCarList);
        assertEquals(1, racingCarList.getCarsCopy().size());
        assertEquals("Car1", racingCarList.getCarsCopy().get(0).getName());
    }

    @DisplayName("Multiple Car Collector Test")
    @ParameterizedTest(name = "Collecting multiple cars: {0}")
    @MethodSource("multipleCarProvider")
    void multipleCarsCollectorTest(List<RacingCar> cars) {

        RacingCarList racingCarList = cars.stream()
                .collect(CarListCollector.toCarList());


        assertNotNull(racingCarList);
        assertEquals(cars.size(), racingCarList.getCarsCopy().size());
        for (int i = 0; i < cars.size(); i++) {
            assertEquals(cars.get(i).getName(), racingCarList.getCarsCopy().get(i).getName());
        }
    }

    @DisplayName("Car List Merge Collector Test")
    @Test
    void carListMergeCollectorTest() {

        Drivable car1 = new RacingCar("Car1");
        Drivable car2 = new RacingCar("Car2");
        Drivable car3 = new RacingCar("Car3");


        RacingCarList racingCarList = Stream.of(car1, car2).collect(CarListCollector.toCarList());
        racingCarList.addCar((RacingCar) car3);

        assertNotNull(racingCarList);
        assertEquals(3, racingCarList.getCarsCopy().size());
        assertEquals("Car1", racingCarList.getCarsCopy().get(0).getName());
        assertEquals("Car2", racingCarList.getCarsCopy().get(1).getName());
        assertEquals("Car3", racingCarList.getCarsCopy().get(2).getName());
    }
}
