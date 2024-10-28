package racingcar.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.model.Car;
import racingcar.model.RaceCars;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest extends NsTest {

    private RaceCars raceCars;

    @BeforeEach
    void setUp() {
        raceCars = new RaceCars();
    }

    @Test
    @DisplayName("여러대의 자동차 생성 테스트")
    void createNewCarsTest() {
        String input = "kim, jun,     pobi";
        raceCars.createCars(input);

        List<Car> cars = raceCars.getCars();

        assertEquals("kim", cars.get(0).getName());
        assertEquals("jun", cars.get(1).getName());
        assertEquals("pobi", cars.get(2).getName());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
