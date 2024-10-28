package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
    private Racing racing;
    private RacingCar racingCar1;
    private RacingCar racingCar2;
    private RacingCar racingCar3;

    @BeforeEach
    void setUp() {
        racingCar1 = new RacingCar("car1");
        racingCar2 = new RacingCar("car2");
        racingCar3 = new RacingCar("car3");

        racing = new Racing(Arrays.asList(racingCar1, racingCar2, racingCar3));
    }

    @DisplayName("자동차들이 이동했는지 확인")
    @Test
    void movingCarsTest() {
        int initPosition1 = racingCar1.getCurrentPosition();
        int initPosition2 = racingCar2.getCurrentPosition();
        int initPosition3 = racingCar3.getCurrentPosition();

        racing.playTurn();

        int maxAttempts = 10; // 반복 최대 횟수
        int attempts = 0;
        boolean anyMoved = false;

        // 최대 maxAttempts번의 시도 동안 자동차가 움직이는지 확인
        while (!anyMoved && attempts < maxAttempts) {
            anyMoved = (initPosition1 != racingCar1.getCurrentPosition()) ||
                    (initPosition2 != racingCar2.getCurrentPosition()) ||
                    (initPosition3 != racingCar3.getCurrentPosition());
            attempts++;
            racing.playTurn();
        }

        assertTrue(anyMoved, "모든 자동차가 움직이지 않았습니다.");
    }

    @DisplayName("단일 우승자를 구하는 테스트")
    @Test
    void singleWinnerTest() {
        racingCar1.moveForward();
        List<RacingCar> racingCars= racing.judgeWinners();
        assertEquals(1, racingCars.size());
    }

    @DisplayName("공동 우승자를 구하는 테스트")
    @Test
    void multipleWinnersTest() {
        racingCar1.moveForward();
        racingCar2.moveForward();
        List<RacingCar> racingCars= racing.judgeWinners();
        assertEquals(2, racingCars.size());
    }
}
