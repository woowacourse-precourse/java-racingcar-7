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
        carNameList.add("test3");

        racingService = new RacingService(carNameList);
        testCarList = racingService.getCarList();
        testProgress = racingService.getCarToRacingProgress();
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

}
