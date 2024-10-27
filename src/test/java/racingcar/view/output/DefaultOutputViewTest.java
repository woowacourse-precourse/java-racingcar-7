package racingcar.view.output;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingRoundResult;
import racingcar.mock.model.dependency.validator.MockedRacingCarValidator;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultOutputViewTest {

    private final DefaultOutputView defaultOutputView = new DefaultOutputView();

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("printInputCarNames() : 자동차_이름_입력을_요구하는_메시지를_출력한다")
    void 자동차_이름_입력을_요구하는_메시지를_출력한다() {

        // when
        defaultOutputView.printInputCarNames();

        // then
        assertThat(outputStreamCaptor.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("printInputTryCount() : 시도_횟수_입력을_요구하는_메시지를_출력한다")
    void 시도_횟수_입력을_요구하는_메시지를_출력한다() {

        // when
        defaultOutputView.printInputTryCount();

        // then
        assertThat(outputStreamCaptor.toString()).contains("시도할 회수는 몇회인가요?");
    }

    @Test
    @DisplayName("printRacingRoundResults() : 라운드_결과를_출력한다")
    void 라운드_결과를_출력한다() {

        // given
        List<RacingRoundResult> racingRoundResults = List.of(
                new RacingRoundResult(new LinkedHashMap<>(Map.ofEntries(
                        Map.entry("a", 1),
                        Map.entry("b", 2),
                        Map.entry("c", 3)
                ))),
                new RacingRoundResult(new LinkedHashMap<>(Map.ofEntries(
                        Map.entry("a", 2),
                        Map.entry("b", 3),
                        Map.entry("c", 4)
                )))
        );

        List<String> expected = List.of(
                "실행 결과",
                "\n",
                "a : -",
                "b : --",
                "c : ---",
                "a : --",
                "b : ---",
                "c : ----"
        );

        // when
        defaultOutputView.printRacingRoundResults(racingRoundResults);

        // then
        expected.forEach(message ->
                assertThat(outputStreamCaptor.toString()).contains(message)
        );
    }

    @Test
    @DisplayName("printWinners() : 쉼표를_기준으로_최종_우승_자동차_이름을_출력한다")
    void 쉼표를_기준으로_최종_우승_자동차_이름을_출력한다() {
        // given
        MockedRacingCarValidator mockedRacingCarValidator = new MockedRacingCarValidator();
        mockedRacingCarValidator.setIsValidateNameWillPass(true);

        RacingCars racingCars = new RacingCars(List.of(
                new RacingCar("a", mockedRacingCarValidator),
                new RacingCar("b", mockedRacingCarValidator),
                new RacingCar("c", mockedRacingCarValidator)
        ));

        // when
        defaultOutputView.printWinners(racingCars);

        // then
        assertThat(outputStreamCaptor.toString()).contains("최종 우승자 : a, b, c");
    }
}
