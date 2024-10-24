package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceRound;
import racingcar.validator.CarValidator;
import racingcar.view.InputView;

public class InputTest {
    private static final String CAR_NAMES = "emily, tomas, gina";
    private static final String LAST_CAR_NAME = "gina";
    private static final int NUMBER_OF_ROUNDS = 5;

    @Test
    void 자동차이름입력_테스트() {
        Cars cars = new Cars();
        cars.addCarFromString(CAR_NAMES);

        assertEquals(3, cars.getCarList().size());

        Car lastCar = cars.getCarList().getLast();
        assertNotNull(lastCar);
        assertEquals(LAST_CAR_NAME, lastCar.getName());

    }

    @Test
    void 모든자동차이름공백_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarValidator.isValid(",,,");
        });
    }
}
