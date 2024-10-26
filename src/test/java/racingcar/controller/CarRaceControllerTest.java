package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.random.DefaultRandomGenerator;
import racingcar.domain.random.FixedRandomGenerator;
import racingcar.domain.random.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarRaceControllerTest {
    @DisplayName("자동차 중복 이름 에러 확인")
    @Test
    void checkDuplicateCarNameError(){
        String testName = "pobi";
        String testCloneName = new String(testName);
        assertThatThrownBy(() -> new CarRaceController(Arrays.asList(testName, testCloneName), new DefaultRandomGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("자동차 수량 최소값 경계값 확인")
    @Test
    void checkMinCarCount(){
        assertDoesNotThrow(() -> new CarRaceController(Arrays.asList("pobi", "popo"), new DefaultRandomGenerator()));
    }
    @DisplayName("자동차 수량 최소값 미만값 확인")
    @Test
    void checkMinCarCountError(){
        assertThatThrownBy(() -> new CarRaceController(Arrays.asList("pobi"), new DefaultRandomGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("자동차 수량 최댓값 경계값 확인")
    @Test
    void checkMaxCarCount(){
        List<String> carsName = new ArrayList<>();
        for(int i = 0; i<100; i++){
            carsName.add(String.valueOf(i));
        }

        assertDoesNotThrow(() -> new CarRaceController(carsName, new DefaultRandomGenerator()));
    }
    @DisplayName("자동차 수량 최댓값 초과값 확인")
    @Test
    void checkMaxCarCountError(){
        List<String> carsName = new ArrayList<>();
        for(int i = 0; i<101; i++){
            carsName.add(String.valueOf(i));
        }

        assertThatThrownBy(() -> new CarRaceController(carsName, new DefaultRandomGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 레이스 정상 작동 확인")
    @Test
    void checkRacePlay(){
        CarRaceController carRaceController = new CarRaceController(Arrays.asList("pobi", "popo"), new DefaultRandomGenerator());

        assertDoesNotThrow(() -> carRaceController.playRaceOnce());
    }

    @DisplayName("자동차 우승자 확인 1명")
    @Test
    void checkOneRaceWinner(){
        RandomGenerator randomGenerator = new FixedRandomGenerator(Arrays.asList(4, 3, 3));
        CarRaceController carRaceController = new CarRaceController(Arrays.asList("pobi", "popo", "bibi"), randomGenerator);
        carRaceController.playRaceOnce();

        assertEquals(carRaceController.getRaceWinners(), Arrays.asList("pobi"));
    }
    @DisplayName("자동차 우승자 확인 2명")
    @Test
    void checkTwoRaceWinner(){
        RandomGenerator randomGenerator = new FixedRandomGenerator(Arrays.asList(4, 4, 3));
        CarRaceController carRaceController = new CarRaceController(Arrays.asList("pobi", "popo", "bibi"), randomGenerator);
        carRaceController.playRaceOnce();

        assertEquals(carRaceController.getRaceWinners(), Arrays.asList("pobi", "popo"));
    }
    @DisplayName("자동차 우승자 확인 3명")
    @Test
    void checkThreeRaceWinner(){
        RandomGenerator randomGenerator = new FixedRandomGenerator(Arrays.asList(4, 4, 4));
        CarRaceController carRaceController = new CarRaceController(Arrays.asList("pobi", "popo", "bibi"), randomGenerator);
        carRaceController.playRaceOnce();

        assertEquals(carRaceController.getRaceWinners(), Arrays.asList("pobi", "popo", "bibi"));
    }
}
