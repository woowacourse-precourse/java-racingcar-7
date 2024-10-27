package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.util.CarNameValidator;
import racingcar.util.RoundValidator;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.util.Constants.*;

class RacingCarTest {

    @Test
    @DisplayName("Car 객체 생성 및 전진 테스트")
    void test() {
        // given
        Car car = new Car("pobi");

        // when
        car.move();

        // then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 테스트")
    void carNameTest() {
        // given
        CarNameValidator carNameValidator = new CarNameValidator();
        String name = "pobi, javaji";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(name.split(",")));

        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_SIZE_ERROR.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 중복 테스트")
    void carNameDuplicateTest() {
        // given
        CarNameValidator carNameValidator = new CarNameValidator();
        String name = "pobi,pobi";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(name.split(",")));

        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_DUPLICATE_ERROR.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 쉼표로 구분된 비어있지 않은 문자 테스트")
    void carNameWrongTest() {
        // given
        CarNameValidator carNameValidator = new CarNameValidator();
        String name = "pobi,,crong";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> carNameValidator.validate(name.split(",")));

        // then
        assertThat(exception.getMessage()).isEqualTo(CAR_NAME_EMPTY_ERROR.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 숫자 아닌 경우 테스트")
    void roundNumTest() {
        // given
        RoundValidator roundValidator = new RoundValidator();
        String roundNum = "1a";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> roundValidator.validate(roundNum));

        // then
        assertThat(exception.getMessage()).isEqualTo(ROUND_NUM_WRONG_ERROR.getMessage());
    }

    @Test
    @DisplayName("시도 횟수 1 미만인 경우 테스트")
    void roundNumZeroTest() {
        // given
        RoundValidator roundValidator = new RoundValidator();
        String roundNum = "0";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> roundValidator.validate(roundNum));

        // then
        assertThat(exception.getMessage()).isEqualTo(ROUND_NUM_WRONG_ERROR.getMessage());
    }

    @Test
    @DisplayName("최종 우승자 출력 테스트")
    void winnerTest() {
        // given
        OutputView outputView = new OutputView();
        List<String> winners = Arrays.asList("pobi", "crong", "honux");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // when
        outputView.printWinnerMessage(winners);

        // then
        String expectedOutput = "최종 우승자 : pobi, crong, honux";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput);

        System.setOut(originalOut);
    }

}
