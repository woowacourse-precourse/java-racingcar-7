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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
