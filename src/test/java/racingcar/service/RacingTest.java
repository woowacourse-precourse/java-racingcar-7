package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameDuplicationException;
import racingcar.exception.CarNameEmptyException;
import racingcar.exception.CarNameSeparatorException;
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
                .hasMessageContaining("[ERROR] 자동차 이름은 쉼표(,)로 구분되어야 합니다. 자동차 경주는 두 대 이상 가능합니다.");
    }

    @Test
    void racing_빈_자동차_이름_예외() {
        assertThatThrownBy(() -> {
            String input = ",woni";
            Racing racing = new Racing(input);
        }).isInstanceOf(CarNameEmptyException.class)
                .hasMessageContaining("[ERROR] 자동차 이름이 존재하지 않습니다. 자동차 경주는 두 대 이상 가능합니다.");
    }

    @Test
    void racing_자동차_이름_중복_예외() {
        assertThatThrownBy(() -> {
            String input = "woni,woni";
            Racing racing = new Racing(input);
        }).isInstanceOf(CarNameDuplicationException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 중복되지 않아야 합니다.");
    }

    @Test
    void racing_자동차_모드_설정() {
        String input = "pobi,woni";
        Racing racing = new Racing(input);
        racing.setRacingCarMode(ModeType.RACING_CAR);

        assertThat(racing.getRacingCars().get(0).getMode()).isEqualTo("RacingCar");
        assertThat(racing.getRacingCars().get(1).getMode()).isEqualTo("RacingCar");
    }
}
