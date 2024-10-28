package racingcar.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.constants.GameConstants;
import racingcar.constants.MessageType;
import racingcar.model.Car;
import racingcar.model.WinningCars;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameWinnerTest extends NsTest {

    private List<Car> cars = new ArrayList<>();
    private WinningCars winningCars;

    @BeforeEach
    void setUp() {
        winningCars = new WinningCars(cars);
    }

    @Test
    @DisplayName("공동 우승자 출력 테스트")
    void printJointWinnerOutputTest() {
        Car car1 = new Car("kim");
        Car car2 = new Car("jun");

        car1.moveCar(GameConstants.MOVING_FORWARD);
        car2.moveCar(GameConstants.MOVING_FORWARD);

        cars.add(car1);
        cars.add(car2);

        winningCars = new WinningCars(cars);

        assertEquals(MessageType.RESPONSE_FINAL_WINNER.getMessage() + winningCars.getWinnerNames(), MessageType.RESPONSE_FINAL_WINNER.getMessage() + " kim, jun");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
