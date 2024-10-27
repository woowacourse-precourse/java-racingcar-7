package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @DisplayName("기능 테스트: 회차별 자동차 위치 상태 생성")
    @Test
    void createRoundStatus() {
        String carNames = "Mary,John,Paul";
        Cars cars = new Cars();

        cars.createRoundStatus(carNames);
        Map<String, Integer> roundStatus = cars.getRoundStatus();

        assertFalse(roundStatus.isEmpty());
    }

    @DisplayName("기능 테스트: 회차별 자동차 위치 상태 갱신")
    @Test
    void updateRoundStatus() {
        String carNames = "Mary,John,Paul";
        Cars cars = new Cars();

        cars.createRoundStatus(carNames);
        Map<String, Integer> roundStatus = cars.getRoundStatus();
        cars.updateRoundStatus(cars);
        Map<String, Integer> newRoundStatus = cars.getRoundStatus();

        int sumStatus = 0;
        int sumNewStatus = 0;

        for (int position : roundStatus.values()) {
            sumStatus += position;
        }
        for (int newPosition : newRoundStatus.values()) {
            sumNewStatus += newPosition;
        }
        assertTrue(sumStatus <= sumNewStatus);
    }

    @DisplayName("예외 테스트: 이름 문자열 길이 초과 점검")
    @Test
    void createRoundStatus_throwIllegalArgumentException_exceeding() {
        String carNames = "Margaret,Johnathan,Pauline";
        Cars cars = new Cars();

        assertThatThrownBy(() -> cars.createRoundStatus(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 이름 빈 문자열 점검")
    @Test
    void createRoundStatus_throwIllegalArgumentException_empty() {
        String carNames = "Mary,,Paul";
        Cars cars = new Cars();

        assertThatThrownBy(() -> cars.createRoundStatus(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}