package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

class OutputViewTest {
    private OutputView outputView;
    private static OutputStream outputStream;

    @BeforeEach
    void setup() {
        outputView = new OutputView();
    }

    @DisplayName("개행 문자를 출력한다.")
    @Test
    void printEndLine() {
        String expected = "\n";

        SystemOut();
        outputView.printEndLine();

        assertEquals(expected, getStringFromOutputStream(outputStream));
    }

    @DisplayName("\"실행 결과\" 메시지를 출력한다.")
    @Test
    void printExecutionResultMessage() {
        String expectedMessage = "실행 결과\n";
        SystemOut();
        outputView.printExecutionResultMessage();

        assertEquals(expectedMessage, getStringFromOutputStream(outputStream));
    }

    @DisplayName("각 자동차의 이름과 이동거리를 출력하는 기능이 잘 수행되야 한다.")
    @MethodSource("provideEachExecutionResultTestCases")
    @ParameterizedTest(name = "기대값: \"{0}\", 입력값: \"{1}\"")
    void printEachExecutionResult(String expected, Car car) {
        SystemOut();
        outputView.printEachExecutionResult(car);

        assertEquals(expected, getStringFromOutputStream(outputStream));
    }

    @DisplayName("최종 우승자를 형식에 맞게 출력한다.")
    @Test
    void printWinner() {
        Car car = new Car("pobi");

        String expectedWinnerPrint = "최종 우승자 : pobi\n";
        SystemOut();
        outputView.printWinner(car);

        assertEquals(expectedWinnerPrint, getStringFromOutputStream(outputStream));
    }

    @DisplayName("공동 우승자를 형식에 맞게 출력한다.")
    @Test
    void printWinners() {
        Car pobi = new Car("pobi");
        Car jun = new Car("jun");
        ArrayList<Car> winnersList = Stream.of(pobi, jun)
                .collect(Collectors.toCollection(ArrayList::new));

        SystemOut();
        outputView.printWinners(winnersList);

        assertEquals("최종 우승자 : pobi, jun", getStringFromOutputStream(outputStream));
    }

    private static Stream<Arguments> provideEachExecutionResultTestCases() {
        Car pobi = new Car("pobi");
        Car wooni = new Car("wooni");
        Car jun = new Car("jun");

        wooni.plusLocation();
        jun.plusLocation();
        jun.plusLocation();

        return Stream.of(
                Arguments.of("pobi :  \n", pobi),
                Arguments.of("wooni : - \n", wooni),
                Arguments.of("jun : -- \n", jun)
        );
    }

    private static void SystemOut() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private static String getStringFromOutputStream(final OutputStream outputStream) {
        return outputStream.toString();
    }

}
