package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.view.GameView;

public class GameViewTest {

    private ByteArrayOutputStream outputStream;
    private GameView view;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        view = new GameView();
    }

    @Test
    void 이름_입력_유효_테스트() {
        String input = "domi,cozy,pony";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> carNames = view.getCarNamesInput();

        assertThat(carNames).containsExactlyInAnyOrder("domi","cozy","pony");

    }

    @Test
    void 라운드_결과_출력_테스트() {
        String roundResult = "domy : ---\ncozy : -\npony : --\n";
        view.displayRoundResult(roundResult);

        assertEquals(roundResult + System.lineSeparator(), outputStream.toString());
    }

    @Test
    void 우승자_출력_테스트() {
        List<Car> winners = List.of(new Car("domi"), new Car("cozy"), new Car("pony"));
        view.displayWinners(winners);

        String expextedOutput = "최종 우승자 : domi, cozy, pony";
        assertEquals(expextedOutput + System.lineSeparator(), outputStream.toString());
    }

}
