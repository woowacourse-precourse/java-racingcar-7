package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RandomEngine;

class OutputViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        outputStream.reset();
    }

    @Test
    void 우승자_두명_이상_출력_확인() {
        outputView.printWinner(List.of("pobi", "james"));
        assertThat(outputStream.toString()).isEqualTo("최종 우승자 : pobi, james\n");
    }

    @Test
    void 우승자_한명_일때_출력_확인(){
        outputView.printWinner(List.of("pobi"));
        assertThat(outputStream.toString()).isEqualTo("최종 우승자 : pobi\n");
    }

    @Test
    void 게임_진행_상황_출력_확인() {
        Map<Car, Integer> situation = new HashMap<>();
        situation.put(new Car(new RandomEngine(), "pobi"), 2);
        situation.put(new Car(new RandomEngine(), "james"), 1);
        outputView.printRacing(situation);
        assertThat(outputStream.toString())
                .contains("pobi : --", "james : -");
    }
}