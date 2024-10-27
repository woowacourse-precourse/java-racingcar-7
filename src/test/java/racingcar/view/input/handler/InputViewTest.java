package racingcar.view.handler;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import racingcar.racingcar.domain.RacingCar;
import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.racingcar.service.RacingCarFactory;
import racingcar.view.input.handler.InputHandlerService;
import racingcar.view.input.handler.impl.InputHandler;
import racingcar.view.input.service.InputService;

import java.util.List;

public class InputViewTest {
    @Test
    void inputTest() {
        String testSentence = "pobi,woni,jun";
        InputHandlerService inputHandlerService = new InputHandler(new InputTest(testSentence));
        RacingCarInfo racingCarInfo = inputHandlerService.receive(RacingCarFactory::create);
        assertThat(racingCarInfo.getRacingCarInfo()).isEqualTo(List.of(
                RacingCar.of("pobi"),
                RacingCar.of("woni"),
                RacingCar.of("jun")));
    }
}
class InputTest implements InputService {
    private final String inputTest;
    public InputTest(String inputTest) {
        this.inputTest = inputTest;
    }
    @Override
    public String input() {
        return inputTest;
    }
}
