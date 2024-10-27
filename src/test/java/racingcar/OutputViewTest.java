package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final OutputView outputView = new OutputView();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 라운드_결과_출력_테스트() {
        List<Car> carList = List.of(
                new Car("pobi", 3),
                new Car("woni", 2),
                new Car("jun", 1)
        );

        outputView.printRoundResult(carList);

        String expectedResult = "pobi : ---\n" +
                                "woni : --\n" +
                                "jun : -\n";
        assertThat(outputStream.toString()).isEqualTo(expectedResult);
    }

}