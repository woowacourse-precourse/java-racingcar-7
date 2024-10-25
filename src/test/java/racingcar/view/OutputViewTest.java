package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class OutputViewTest {

    private OutputView outputView;
    private ByteArrayOutputStream outputStream;
    private PrintStream original;

    @BeforeEach
    void beforeEach() {
        outputView = new OutputView();

        outputStream = new ByteArrayOutputStream();
        original = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void afterEach() {
        outputStream.reset();
        System.setOut(original);
    }

    @Test
    void 실행_결과_문구를_출력한다() {
        // given
        String successResult = "\n실행 결과\n";

        // when
        outputView.printRunResult();

        // then
        Assertions.assertEquals(outputStream.toString(), successResult);
    }

    @Test
    void 라운드_결과_문구를_출력한다() {
        // given
        String successResult = "pobi : \n\n";
        List<Car> carList = List.of(new Car("pobi"));

        // when
        outputView.printRoundResult(carList);

        // then
        Assertions.assertEquals(outputStream.toString(), successResult);
    }
}