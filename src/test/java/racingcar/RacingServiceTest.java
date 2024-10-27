package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.RacingService;

public class RacingServiceTest {

    private RacingService racingService;
    private HashMap<Car, Long> testProgress = new HashMap<>();
    private List<Car> testCarList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        List<String> carNameList = new ArrayList<>();
        carNameList.add("test1");
        carNameList.add("test2");

        racingService = new RacingService(carNameList);
        testCarList = racingService.getCarList();
        testProgress = racingService.getRacingProgress();
    }

    @Test
    void 랜덤_값이_4_이상이면_전진한다() {

        //when
        racingService.moveForward();
        Car car1 = testCarList.get(0);
        int test1RandomNumber = car1.getRandomNumber();

        //then
        if (test1RandomNumber >= 4) {
            Assertions.assertEquals(1L, testProgress.get(car1));
        } else {
            Assertions.assertEquals(0L, testProgress.get(car1));
        }
    }

    @Test
    void 우승자를_가려낸다() {

        //given
        racingService.moveForward();
        racingService.moveForward();
        racingService.moveForward();

        Long winnerValue = Math.max(
                testProgress.get(testCarList.get(0)),
                testProgress.get(testCarList.get(1))
        );

        //when
        List<String> winnerList = racingService.getWinner();

        //then
        for (String winner : winnerList) {
            if (testCarList.get(0).getName().equals(winner)) {
                Assertions.assertEquals(winnerValue, testProgress.get(testCarList.get(0)));
            } else if (testCarList.get(1).getName().equals(winner)) {
                Assertions.assertEquals(winnerValue, testProgress.get(testCarList.get(1)));
            }

        }

        Assertions.assertAll(
                () -> Assertions.assertFalse(winnerList.isEmpty()),
                () -> {
                    List<String> expectedWinners = testCarList.stream()
                            .filter(car -> testProgress.get(car).equals(winnerValue))
                            .map(Car::getName)
                            .toList();

                    Assertions.assertEquals(expectedWinners.size(), winnerList.size());
                    Assertions.assertTrue(winnerList.containsAll(expectedWinners));
                }
        );


    }

}
