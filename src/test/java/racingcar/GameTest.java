package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameTest {

    static Stream<Arguments> parseCarsCases() {
        return Stream.of(
                Arguments.of("pobi,woni",new ArrayList<String>(Arrays.asList("pobi","woni")))
        );
    }

    @ParameterizedTest
    @MethodSource("parseCarsCases")
    public void parseCarsTest(String input, ArrayList<String> expected){
        List<Car> cars = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        Game game=new Game();
        cars = game.parseCars(input);
        for(Car car:cars){
            result.add(car.getName());
        }
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> parseCarsExceptionCases() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("javaji,pobi")
        );
    }

    @ParameterizedTest
    @MethodSource("parseCarsExceptionCases")
    public void parseCarsExceptionTest(String input){
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> game.parseCars(input));
    }

    static Stream<Arguments> parseMoveCountCases() {
        return Stream.of(
                Arguments.of("1",1),
                Arguments.of("2",2)
        );
    }

    @ParameterizedTest
    @MethodSource("parseMoveCountCases")
    public void parseMoveCountTest(String input, int expected){
        Game game = new Game();
        assertThat(game.parseMoveCount(input)).isEqualTo(expected);
    }

    static Stream<Arguments> parseMoveCountExceptionCases() {
        return Stream.of(
                Arguments.of("a"),
                Arguments.of("-1"),
                Arguments.of("1 2")
        );
    }

    @ParameterizedTest
    @MethodSource("parseMoveCountExceptionCases")
    public void parseMoveCountExceptionTest(String input){
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> game.parseMoveCount(input));
    }

}
