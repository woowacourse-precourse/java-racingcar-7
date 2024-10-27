package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarController;
import racingcar.exception.CarNameValidationError;
import racingcar.exception.GeneralError;
import racingcar.exception.RaceValidationError;
import racingcar.view.RacingView;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    void 성공_테스트_2라운드() {
        // given
        String carNames = "a,b,c";
        String roundCount = "2";
        RacingCarController racingCarController = getRacingCarController(carNames, roundCount, List.of(1, 2, 4));

        // when
        racingCarController.run();

        // then
        assertThat(output()).contains("a : ", "b : ", "c : -", "c : --", "최종 우승자 : c");
    }

    @Test
    void 성공_테스트_모두_승리() {
        // given
        String carNames = "a,b,c";
        String roundCount = "2";
        RacingCarController racingCarController = getRacingCarController(carNames, roundCount, List.of(1, 2, 3));

        // when
        racingCarController.run();

        // then
        assertThat(output()).contains("a : ", "b : ", "c : ", "최종 우승자 : a, b, c");
    }

    @Test
    void 예외_차이름_빈문자열() {
        // given
        String carNames = "";
        String roundCount = "1";
        RacingCarController racingCarController = getRacingCarController(carNames, roundCount, List.of(1, 2, 3));

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                racingCarController::run);

        // then
        assertThat(exception.getMessage()).isEqualTo(GeneralError.EMPTY_INPUT.getMessage());
    }

    @Test
    void 예외_차_하나가_빈문자열() {
        // given
        String carNames = "pobi,,woni";
        String roundCount = "1";
        RacingCarController racingCarController = getRacingCarController(carNames, roundCount, List.of(1, 2, 3));

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                racingCarController::run);

        // then
        assertThat(exception.getMessage()).isEqualTo(CarNameValidationError.NAME_EMPTY.getMessage());
    }

    @Test
    void 예외_차_이름에_공백포함() {
        // given
        String carNames = "pobi, woni";
        String roundCount = "1";
        RacingCarController racingCarController = getRacingCarController(carNames, roundCount, List.of(1, 2, 3));

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                racingCarController::run);

        // then
        assertThat(exception.getMessage()).isEqualTo(CarNameValidationError.NAME_CONTAINS_SPACE.getMessage());
    }

    @Test
    void 예외_라운드_입력이_공백() {
        // given
        String carNames = "pobi,woni";
        String roundCount = "";
        RacingCarController racingCarController = getRacingCarController(carNames, roundCount, List.of(1, 2, 3));

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                racingCarController::run);

        // then
        assertThat(exception.getMessage()).isEqualTo(GeneralError.EMPTY_INPUT.getMessage());
    }

    @Test
    void 차이름_중복() {
        // given
        String carNames = "abc,abc,ab";
        String roundCount = "2";
        RacingCarController racingCarController = getRacingCarController(carNames, roundCount, List.of(1, 2, 3));

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                racingCarController::run);

        // then
        assertThat(exception.getMessage()).isEqualTo(RaceValidationError.CARS_DUPLICATE_NAME.getMessage());
    }

    private RacingCarController getRacingCarController(String carNames, String roundCount,
                                                       List<Integer> randomNumbers) {
        RacingView racingView = new RacingView(TestUtils.mockInputProviderGenerator(List.of(carNames, roundCount)));
        return new RacingCarController(racingView, TestUtils.mockRandomNumberGenerator(randomNumbers));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
