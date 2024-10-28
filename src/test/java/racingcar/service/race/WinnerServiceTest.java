package racingcar.service.race;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Engine;
import racingcar.service.DemoCar;
import racingcar.service.constant.ExpressionFormat;

class WinnerServiceTest {

    private WinnerService winnerService;

    private Car testCar(String carName, Long mileage) {
        return new DemoCar(carName
                , new Engine(1L
                ,1L)
                , mileage, 3L);
    }

    @Test
    @DisplayName("승자 고르기 테스트")
    void pick() {
        String carName1 = "test1";
        String carName2 = "test2";
        List<Car> finishers = List.of(testCar(carName1, 1L)
                ,testCar(carName2, 2L));

        winnerService = new WinnerService(finishers);

        String actual = winnerService.raceWinners();
        assertEquals(carName2, actual);
    }

    @Test
    @DisplayName("정해진 출력 형식 승자가 한 명 이상일 때 쉼표 테스트")
    void correctForm() {
        String carName1 = "test1";
        String carName2 = "test2";
        List<Car> finishers = List.of(testCar(carName1, 2L)
                ,testCar(carName2, 2L));

        winnerService = new WinnerService(finishers);

        String expected = carName1.concat(ExpressionFormat.WINNER_SEPARATOR.form()).concat(carName2);
        String actual = winnerService.raceWinners();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("정해진 출력 형식 테스트 승자가 한 명일 때 쉼표 없음")
    void correctForm2() {
        String carName1 = "test1";
        String carName2 = "test2";
        List<Car> finishers = List.of(testCar(carName1, 2L)
                ,testCar(carName2, 3L));

        winnerService = new WinnerService(finishers);

        String actual = winnerService.raceWinners();
        assertEquals(carName2, actual);
    }
}