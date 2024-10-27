package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.game.GameManager;
import racingcar.domain.game.WinnerCalculator;
import racingcar.domain.game.WootecoRule;
import racingcar.service.RacingGameService;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class RacingGameControllerTest {

    private RacingGameService racingGameService;
    private RacingGameController controller;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        GameManager gameManager = new GameManager(new WootecoRule(), new RandomNumberGenerator(),
                new WinnerCalculator(new WootecoRule()));
        racingGameService = new RacingGameService(gameManager);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        controller = new RacingGameController(racingGameService, inputView, outputView);
    }

    @Test
    void 사용자의_입력값이_유효할때_예외가_발생하지_않는다() {
        String simulatedInput = "minu\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        controller.startGame();

        String output = outputStream.toString();
        assertThat(output).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        assertThat(output).contains("시도할 횟수는 몇 회인가요?");
        assertThat(output).contains("실행 결과");
        assertThat(output).contains("minu : ");
        assertThat(output).contains("최종 우승자 : minu");
    }
}
