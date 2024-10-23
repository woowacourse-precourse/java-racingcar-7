package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.model.RacingGameModel;
import racingcar.view.OutputView;

public class OutputViewTest {
    private final ByteArrayOutputStream outputMessage = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView();
    private final RacingGameModel racingGameModel = new RacingGameModel();
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputMessage));

        cars = List.of(
                new Car("car1", 0),
                new Car("car2", 1),
                new Car("car3", 2)
        );
    }

    @AfterEach
    void reset() {
        System.setOut(System.out);
    }

    @Test
    void 자동차_경주_게임_실행결과_테스트() {
        outputView.printCarStatus(cars);

        String consoleMessage = outputMessage.toString().trim();

        assertThat(consoleMessage).contains("car1 : ", "car2 : -", "car3 : --");
    }

    @Test
    void 자동차_경주_게임_최종_우승자_출력_테스트() {
        List<String> winners = racingGameModel.getWinners(cars);

        outputView.printWinners(winners);

        String consoleMessage = outputMessage.toString().trim();

        assertThat(consoleMessage).contains("최종 우승자 : car3");
    }
}
