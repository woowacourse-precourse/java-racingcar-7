package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.entity.Car;

public class OutputViewTest {
    @Test
    void 우승자_출력_정상적으로_표시되는지_확인() {
        OutputView outputView = new OutputView();
        List<String> winners = List.of("pobi", "jun");

        outputView.printWinners(winners);
    }
}
