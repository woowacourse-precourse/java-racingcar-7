package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car.Cars;

import java.util.Arrays;
import java.util.List;


public class RefereeTest {
    private Referee referee;
    private Cars cars;

    @BeforeEach
    public void setUp() {
        String [] tempCarNames = {"Car1", "Car2", "Car3"};
        cars = new Cars(tempCarNames);
        referee = new Referee(cars);
    }

    @Test
    @DisplayName("자동차 이름 목록이 올바르게 반환되는지 확인")
    public void testGetCarNames() {
        List<String> carNames = referee.getCarNames();
        Assertions.assertEquals(Arrays.asList("Car1", "Car2", "Car3"), carNames);
    }

    @Test
    @DisplayName("자동차 위치 목록이 올바르게 반환되는지 확인")
    public void testGetCarPositions() {
        cars.getCar(0).moveForward();
        cars.getCar(1).moveForward();
        cars.getCar(1).moveForward();

        List<Integer> carPositions = referee.getCarPositions();
        Assertions.assertEquals(Arrays.asList(1, 2, 0), carPositions);
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차의 이름이 올바르게 반환되는지 확인")
    public void testGetWinners() {
        cars.getCar(1).moveForward();
        cars.getCar(2).moveForward();

        List<String> winners = referee.getWinners();
        Assertions.assertEquals(Arrays.asList("Car2", "Car3"), winners);
    }

    @Test
    @DisplayName("라운드 플레이 시 이동 조건이 충족된 자동차가 이동하는지 확인")
    public void testPlayRound() {
        boolean moved = false;
        for (int i = 0; i < 10; i++) {
            referee.playRound();
            moved = cars.getCar(0).getPosition() > 0 || cars.getCar(1).getPosition() > 0 || cars.getCar(2).getPosition() > 0;
            if (moved) break;
        }
        Assertions.assertTrue(moved, "자동차가 최소 한 번은 이동해야 합니다.");
    }
}