package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.enums.ExceptionMessage.CAR_NOT_FOUND;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.strategy.FixedMoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

class CarRaceServiceTest {

    @Test
    @DisplayName("자동차 이름을 쉼표로 구분하여 저장한다.")
    void should_InitializeCars_When_GivenCommaSeparatedNames() {
        //given
        String input = "foo,bar";
        CarRaceService carRaceService = new CarRaceService(new RandomMoveStrategy());

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
        CarRaceService carRaceService = new CarRaceService(new FixedMoveStrategy(true));
        carRaceService.init("foo,bar");

        //when
        carRaceService.moveCars();

        //then
        Map<String, String> carsStatus = carRaceService.getCarsStatus();
        assertEquals("-", carsStatus.get("foo"));
        assertEquals("-", carsStatus.get("bar"));
    }

    @Test
    @DisplayName("자동차가 정지하면 이동거리는 변하지 않는다.")
    void should_NotMoveCars_When_RandomNumberBelowThreshold() {
        //given
        CarRaceService carRaceService = new CarRaceService(new FixedMoveStrategy(false));
        carRaceService.init("foo,bar");

        //when
        carRaceService.moveCars();

        //then
        Map<String, String> carsStatus = carRaceService.getCarsStatus();
        assertEquals("", carsStatus.get("foo"));
        assertEquals("", carsStatus.get("bar"));
    }

    @Test
    @DisplayName("이동거리가 제일 긴 자동차가 우승자이다.")
    void should_ReturnSingleWinner_When_OneCarHasLongestDistance() {
        //given
        List<String> carNames = List.of("foo");
        CarRaceService mockCarRaceService = getCarRaceService(carNames);
        mockCarRaceService.init("foo,bar");
        mockCarRaceService.moveCars();

        //when
        List<String> winners = mockCarRaceService.getWinners();

        //then
        assertEquals(1L, winners.size());
        assertEquals("foo", winners.get(0));
    }

    @Test
    @DisplayName("우승자는 여러 명일 수 있다.")
    void should_ReturnMultipleWinners_When_CarsHaveSameLongestDistance() {
        //given
        List<String> carNames = List.of("foo", "bar");
        CarRaceService mockCarRaceService = getCarRaceService(carNames);
        mockCarRaceService.init("foo,bar,baz");
        mockCarRaceService.moveCars();

        //when
        List<String> winners = mockCarRaceService.getWinners();

        //then
        assertEquals(2L, winners.size());
        assertTrue(winners.contains("foo"));
        assertTrue(winners.contains("bar"));
    }

    //전진 조건에 이름을 전달해 전진/정지를 강제하는 모킹 서비스
    private CarRaceService getCarRaceService(List<String> carNames) {
        return new CarRaceService(new FixedMoveStrategy(true)) {
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
                        .filter(car -> carNames.contains(car.getName()))
                        .forEach(Car::move);
            }

            @Override
            public List<String> getWinners() {
                return cars.stream()
                        .filter(car -> car.getMovingDistance().length() == getMaxDistance())
                        .map(Car::getName)
                        .toList();
            }

            private int getMaxDistance() {
                return cars.stream()
                        .mapToInt(car -> car.getMovingDistance().length())
                        .max()
                        .orElseThrow(() -> new IllegalArgumentException(CAR_NOT_FOUND.getMessage()));
            }
        };
    }
}