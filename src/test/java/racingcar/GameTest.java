package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private Cars cars;
    private Output output;
    private Game game;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of("pobi", "woni", "jun"));
        output = new Output();
        game = new Game(cars, 3, output);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 게임_실행_및_결과_출력_확인() {
        game.playGame();

        String outputResult = outputStream.toString();
        assertThat(outputResult).contains("pobi", "woni", "jun", "최종 우승자");
    }
}