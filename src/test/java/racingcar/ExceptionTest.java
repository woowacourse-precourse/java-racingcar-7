package racingcar;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import racingcar.controller.RaceController;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.util.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {
    @Test
    void 자동차_이름에_아무_것도_입력이_되지_않았을_때() {
        String carName = "";

        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_EMPTY.getMessage());
    }

    @Test
    void 자동차_이름에_5글자_이상이_입력되었을_때() {
        String carName = "kyoungmin";

        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_OVER_FIVE.getMessage());
    }

    @Test
    void 시도_횟수에_0이하의_수가_입력되었을_때() {
        List<Car> cars = new ArrayList<>(List
                .of(new Car("pobi"), new Car("woni"), new Car("jun")));

        int trial = -1;

        assertThatThrownBy(() -> new Race(cars, trial))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.TRIAL_UNDER_ZERO.getMessage());
    }

    @Test
    void 시도_횟수에_숫자가_아닌_값이_입력되었을_때() {
        RaceController controller = new RaceController();
        List<Car> cars = new ArrayList<>(List
                .of(new Car("pobi"), new Car("woni"), new Car("jun")));

        String trial = "q";

        assertThatThrownBy(() -> controller.getRace(cars, trial))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.TRIAL_IS_NOT_NUMBER.getMessage());
    }

    @Test
    void 입력된_자동차_이름에_중복된_값이_존재할_때() {
        RaceController controller = new RaceController();
        List<Car> cars = new ArrayList<>(List
                .of(new Car("pobi"), new Car("woni"), new Car("pobi")));

        String trial = "4";

        assertThatThrownBy(() -> controller.getRace(cars, trial))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_DUPLICATED.getMessage());
    }
}
