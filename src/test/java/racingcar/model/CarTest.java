package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameLengthException;
import racingcar.exception.ExceptionMessage;
import racingcar.strategy.ModeType;

public class CarTest {
    @Test
    void car_자동차_객체_생성() {
        String input = "pobi";
        Car result = new Car(input);

        assertThat(result.getCarName()).isEqualTo(input);
    }

    @Test
    void car_자동차_객체_모드_설정() {
        String input = "pobi";
        Car result = new Car(input);
        result.setMode(ModeType.createCarMode(ModeType.RACING_CAR));

        assertThat(result.getMode()).isEqualTo("RacingCar");
        assertThat(result.getMoveDistance()).isEqualTo(0);
    }

    @Test
    void car_자동차_객체_생성_예외() {
        assertThatThrownBy(() -> {
            Car result = new Car("poooobi");
        }).isInstanceOf(CarNameLengthException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_LENGTH_EXCEPTION_MESSAGE.getMessage());
    }
}
