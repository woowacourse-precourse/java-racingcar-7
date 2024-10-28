package racingcar.InputTest;

import org.junit.jupiter.api.Test;
import racingcar.dto.RacingInput;
import racingcar.dto.RacingResult;
import racingcar.model.RacingRecord;
import racingcar.service.RacingService;
import racingcar.validator.InputValidator;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputTest {
    private RacingService racingService;

    @Test
    void 자동차이름_시도횟수_정상입력() {
        // given
        RacingInput validRacingInput = new RacingInput(
                Arrays.asList("pobi", "juju", "damin"),
                3
        );

        // when
        racingService = new RacingService(new RacingRecord());
        racingService.racing(validRacingInput);

        // then
        String actualWinners = racingService.getWinnerNames();
        assertThat(actualWinners).isIn("pobi", "juju", "damin");
    }

    @Test
    void 자동차이름_공백인경우_예외발생() {
        // given
        RacingInput cars = new RacingInput(
                Arrays.asList("pobi", "juju", ""),
                3
        );
        // then
        assertThatThrownBy(() -> {
            // when
            InputValidator.validateCarNames(cars.getCarNames());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_5글자_이상인경우_예외발생() {
        // given
        RacingInput cars = new RacingInput(
                Arrays.asList("pobi", "jujudd", "dami"),
                3
        );
        // then
        assertThatThrownBy(() -> {
            // when
            InputValidator.validateCarNames(cars.getCarNames());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_중복인경우_예외발생() {
        // given
        RacingInput cars = new RacingInput(
                Arrays.asList("pobi", "pobi", "dami"),
                3
        );
        // then
        assertThatThrownBy(() -> {
            // when
            InputValidator.validateCarNames(cars.getCarNames());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_한글영어숫자외의_글인경우_예외발생() {
        // given
        RacingInput cars = new RacingInput(
                Arrays.asList("pobi", ",'", ""),
                3
        );
        // then
        assertThatThrownBy(() -> {
            // when
            InputValidator.validateCarNames(cars.getCarNames());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수가_0이상의_정수가_아닐경우() {
        // given
        RacingInput cars = new RacingInput(
                Arrays.asList("pobi", "juju", "damin"),
                -1
        );
        // then
        assertThatThrownBy(() -> {
            // when
            InputValidator.validateTryCounts(cars.getTryCount());
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
