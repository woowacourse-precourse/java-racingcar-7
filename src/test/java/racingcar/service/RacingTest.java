package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

    @ParameterizedTest
    @ValueSource(strings = {"pobiwoni", "pobi", "pobi.woni", "pobi;woni", "pobi!woni", "pobi랑woni"})
    void racing_자동차_이름_구분자_예외(String input) {
        assertThatThrownBy(() -> {
            Racing racing = new Racing(input);
        }).isInstanceOf(CarNameSeparatorException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_SEPARATOR_EXCEPTION_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {",woni", "pobi,", " ,", "pobi, ", " ,woni", ",", ", "})
    void racing_빈_자동차_이름_예외(String input) {
        assertThatThrownBy(() -> {
            Racing racing = new Racing(input);
        }).isInstanceOf(CarNameEmptyException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_EMPTY_EXCEPTION_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"woni,woni", "pobi,pobi", "pobi,woni,woni"})
    void racing_자동차_이름_중복_예외(String input) {
        assertThatThrownBy(() -> {
            Racing racing = new Racing(input);
        }).isInstanceOf(CarNameDuplicationException.class)
                .hasMessageContaining(ExceptionMessage.CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE.getMessage());
    }

    @Test
    void racing_자동차_모드_미설정() {
        String input = "pobi,woni";
        Racing racing = new Racing(input);

        assertThat(racing.getRacingCars().get(0).getMode()).isEqualTo("PracticeCar");
        assertThat(racing.getRacingCars().get(0).getMoveDistance()).isEqualTo(0);
        assertThat(racing.getRacingCars().get(1).getMode()).isEqualTo("PracticeCar");
        assertThat(racing.getRacingCars().get(1).getMoveDistance()).isEqualTo(0);
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
