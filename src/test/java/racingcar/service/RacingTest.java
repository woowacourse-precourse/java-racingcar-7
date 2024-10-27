package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameDuplicationException;
import racingcar.exception.CarNameEmptyException;
import racingcar.exception.CarNameSeparatorException;
import racingcar.exception.ExceptionMessage;
import racingcar.strategy.ModeType;

public class RacingTest {
    @Test
    void racing_레이싱_생성() {
        String input = "pobi,woni";
        Racing racing = new Racing(input);

        assertThat(racing.getRacingCars().get(0).getCarName()).isEqualTo("pobi");
        assertThat(racing.getRacingCars().get(1).getCarName()).isEqualTo("woni");
    }

    @Test
    void racing_자동차_이름_구분자_예외() {
        assertThatThrownBy(() -> {
            String input = "pobiwoni";
            Racing racing = new Racing(input);
        }).isInstanceOf(CarNameSeparatorException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_SEPARATOR_EXCEPTION_MESSAGE.getMessage());
    }

    @Test
    void racing_빈_자동차_이름_예외() {
        assertThatThrownBy(() -> {
            String input = ",woni";
            Racing racing = new Racing(input);
        }).isInstanceOf(CarNameEmptyException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_EMPTY_EXCEPTION_MESSAGE.getMessage());
    }

    @Test
    void racing_자동차_이름_중복_예외() {
        assertThatThrownBy(() -> {
            String input = "woni,woni";
            Racing racing = new Racing(input);
        }).isInstanceOf(CarNameDuplicationException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE.getMessage());
    }

    @Test
    void racing_자동차_모드_설정() {
        String input = "pobi,woni";
        Racing racing = new Racing(input);
        racing.setRacingCarMode(ModeType.RACING_CAR);

        assertThat(racing.getRacingCars().get(0).getMode()).isEqualTo("RacingCar");
        assertThat(racing.getRacingCars().get(0).getMoveDistance()).isEqualTo(0);
        assertThat(racing.getRacingCars().get(1).getMode()).isEqualTo("RacingCar");
        assertThat(racing.getRacingCars().get(1).getMoveDistance()).isEqualTo(0);
    }
}
