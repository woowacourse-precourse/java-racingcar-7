package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.util.RandomUtil.getRandomNumberInRange;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarRaceServiceTest {

    @Test
    @DisplayName("자동차 이름을 쉼표로 구분하여 저장한다.")
    void should_InitializeCars_When_GivenCommaSeparatedNames() {
        //given
        String input = "foo,bar";
        CarRaceService carRaceService = new CarRaceService();

        //when
        carRaceService.init(input);

        //then
        Set<String> carNames = carRaceService.getCarsStatus().keySet();
        assertEquals(2L, carNames.size());
        assertTrue(carNames.contains("foo"));
        assertTrue(carNames.contains("bar"));
    }

    @Test
    @DisplayName("자동차가 전진하면 이동거리에 '-'를 추가한다.")
    void should_MoveCars_When_RandomNumberAboveThreshold() {
        //given
        int movingNumber = getRandomNumberInRange(4, 9);

        CarRaceService mockCarRaceService = getCarRaceService(movingNumber);
        mockCarRaceService.init("foo,bar");

        //when
        mockCarRaceService.moveCars();

        //then
        Map<String, String> carsStatus = mockCarRaceService.getCarsStatus();
        assertEquals("-", carsStatus.get("foo"));
        assertEquals("-", carsStatus.get("bar"));
    }

    @Test
    @DisplayName("자동차가 정지하면 이동거리는 변하지 않는다.")
    void should_NotMoveCars_When_RandomNumberBelowThreshold() {
        //given
        int stoppingNumber = getRandomNumberInRange(0, 3);

        CarRaceService mockCarRaceService = getCarRaceService(stoppingNumber);
        mockCarRaceService.init("foo,bar");

        //when
        mockCarRaceService.moveCars();

        //then
        Map<String, String> carsStatus = mockCarRaceService.getCarsStatus();
        assertEquals("", carsStatus.get("foo"));
        assertEquals("", carsStatus.get("bar"));
    }

    private CarRaceService getCarRaceService(int movingNumber) {
        return new CarRaceService() {
            List<Car> cars;

            @Override
            public void init(String input) {
                this.cars = Arrays.stream(input.split(","))
                        .map(Car::new)
                        .toList();
            }

            @Override
            public void moveCars() {
                cars.stream()
                        .filter(car -> movingNumber >= 4)
                        .forEach(Car::move);
            }

            @Override
            public Map<String, String> getCarsStatus() {
                return cars.stream()
                        .collect(Collectors.toMap(
                                Car::getName,
                                Car::getMovingDistance
                        ));
            }
        };
    }
}