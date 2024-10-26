package racingcar.global.frontcontroller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.back.controller.CarRaceController;
import racingcar.back.service.impl.CarRaceGameRunnerServiceImpl;
import racingcar.front.exception.InvalidCarNameInputException;
import racingcar.front.exception.InvalidPlayCountException;
import racingcar.front.view.InputView;
import racingcar.front.view.OutputView;
import racingcar.front.view.message.OutputViewMessage;

class FrontControllerTest extends NsTest {

    private final FrontController frontController = new FrontController(new InputView(), new OutputView(),
            new CarRaceController(new CarRaceGameRunnerServiceImpl()));

    private static final String RACE_RESULT_MESSAGE = OutputViewMessage.RACE_RESULT_MESSAGE.getMessage();
    private static final String WINNER_MESSAGE = OutputViewMessage.WINNER_MESSAGE.getMessage();

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @ParameterizedTest
    @MethodSource("validInput")
    @DisplayName("valid input에 대한 통합 테스트")
    void 유효한_입력_통합_테스트1(String carNames, String playCount, String expectedPhases, String expectedWinners) {

        assertRandomNumberInRangeTest(() -> {

            run(carNames, playCount);
            assertThat(output()).contains(RACE_RESULT_MESSAGE, expectedPhases, WINNER_MESSAGE, expectedWinners);
        }, MOVING_FORWARD, STOP);
    }

    @ParameterizedTest
    @MethodSource("carNameInvalidLengthInput")
    @DisplayName("5글자가 넘는 차 이름이 있는 입력에 대한 통합 테스트")
    void 유효한_입력_통합_테스트2(String carNames, String playCount) {

        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(
                InvalidCarNameInputException.class));
    }

    @ParameterizedTest
    @MethodSource("nonNumericInput")
    @DisplayName("숫자가 있는 입력에 대한 통합 테스트")
    void 유효한_입력_통합_테스트3(String carNames, String playCount) {

        assertSimpleTest(() -> assertThatThrownBy(() -> runException(carNames, playCount)).isInstanceOf(
                InvalidPlayCountException.class));
    }

    @ParameterizedTest
    @MethodSource("invalidFormatInput")
    @DisplayName("형식에 맞지 않는 입력에 대한 통합 테스트")
    void 유효한_입력_통합_테스트4(String carNames, String playCount) {

        assertSimpleTest(() -> assertThatThrownBy(() -> runException(carNames, playCount)).isInstanceOf(
                InvalidCarNameInputException.class));
    }

    static Stream<Arguments> validInput() {
        return Stream.of(Arguments.of("pobi,woni", "1", "pobi : -", "woni : ", "pobi"));
    }

    static Stream<Arguments> carNameInvalidLengthInput() {
        return Stream.of(Arguments.of("pobi,woniasd", "1"));
    }

    static Stream<Arguments> nonNumericInput() {
        return Stream.of(Arguments.of("pobi,wonad", "asd"));
    }

    static Stream<Arguments> invalidFormatInput() {
        return Stream.of(Arguments.of("pobi,,wonad", "2"));
    }

    @Override
    public void runMain() {
        frontController.run();
    }
}