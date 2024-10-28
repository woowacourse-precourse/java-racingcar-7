package racingcar;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameTest {

    @DisplayName("우승자 테스트")
    @Test
    void winnersTest(){
        Game game = new Game();

        List<Car> cars = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        List<String> result = new ArrayList<>();

        cars.add(new Car("win1",4));
        cars.add(new Car("win2",4));
        cars.add(new Car("lose",2));

        expected =List.of("win1","win2");
        result = game.winners(cars);

        assertEquals(expected,result);

    }
    @DisplayName("우승자 출력 테스트")
    @Test
    void printWinners() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        Game game = new Game();

        List<String> winners = new ArrayList<>();

        winners = List.of("win1","win2");
        game.printWinners(winners);

        assertEquals("최종 우승자 : win1, win2\n",outputStream.toString());
    }
}
