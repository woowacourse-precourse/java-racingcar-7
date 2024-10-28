package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingController;
import racingcar.util.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingControllerTest {

    private InputView inputView;
    private OutputView outputView;
    private StringParser stringParser;
    private RacingController racingController;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        outputView = new OutputView();
        stringParser = new StringParser();
        racingController = new RacingController(inputView, outputView, stringParser);
    }

    @Test
    void 게임_실행() {
        String input = "car1,car2\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        racingController.run();

        assertThat(true).isTrue();  // 단순히 실행이 되는지 확인하는 용도로 사용.
    }
}
