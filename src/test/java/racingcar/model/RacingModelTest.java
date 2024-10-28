package racingcar.model;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingModelTest {

    private RacingModel model;

    @BeforeEach
    void setUp() {
        model = new RacingModel();
    }

    @Test
    void 우승자_한명_결정_테스트() {
        // Given: 자동차 이름 초기화
        String[] carNames = {"pobi", "woni"};
        model.initializeCars(carNames);

        // When: 특정 자동차만 전진
        model.getCarStates().get(0).move(); // pobi가 한 칸 전진
        model.raceOneRound();

        // Then: pobi가 유일한 우승자인지 확인
        String winner = model.getWinners();
        assertEquals("pobi", winner);
    }

    @Test
    void 우승자_두명_이상_결정_테스트() {
        // Given: 자동차 이름 초기화
        String[] carNames = {"pobi", "woni", "jun"};
        model.initializeCars(carNames);

        // When: pobi와 woni가 동일하게 전진
        model.getCarStates().get(0).move();
        model.getCarStates().get(1).move();
        model.raceOneRound();

        // Then: pobi와 woni가 공동 우승자인지 확인
        String winners = model.getWinners();
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
    }

    @Test
    void 아무도_움직이지_않을때() {
        // Given
        String[] carNames = {"pobi", "woni", "jun"};
        model.initializeCars(carNames);

        // When: 모든 자동차를 모킹하여 이동하지 않도록 설정
        List<Car> cars = model.getCarStates();
        for (Car car : cars) {
            Car mockCar = spy(car);
            doNothing().when(mockCar).move(); // move 호출 시 아무것도 하지 않음
        }

        model.raceOneRound();

        // Then: 3명이 공동 우승인지 확인
        String winners = model.getWinners();
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
        assertTrue(winners.contains("jun"));
    }


}