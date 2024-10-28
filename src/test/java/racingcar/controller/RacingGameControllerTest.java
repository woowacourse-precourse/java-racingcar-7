package racingcar.controller;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.view.RacingGameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private RacingGameView view;
    private RacingGameService service;
    private RacingGameController controller;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        view = new RacingGameView();
        service = new RacingGameService(List.of("pobi", "woni", "jun"));
        controller = new RacingGameController(service, view);
    }

    @Test
    void 게임이_정상적으로_진행되는지_확인() {
        String inputRounds = "5\n";
        System.setIn(new ByteArrayInputStream(inputRounds.getBytes()));

        controller.start(5);

        String output = outputStreamCaptor.toString().trim();
        assertThat(output).contains("pobi", "woni", "jun", "최종 우승자");
    }
}