package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exception.ErrorMessage;

class CarRaceControllerTest {

    private CarRaceController carRaceController;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        carRaceController = new CarRaceController();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("자동차 경주 성공 테스트")
    @ParameterizedTest
    @CsvSource({
            "pobi,woni,jun,3",
            "car1,car2,car3,5",
            "carA,carB,carC,4"
    })
    void carRaceSuccess(String car1, String car2, String car3, String rounds) {
        String carName = setUpInput(car1, car2, car3, rounds);

        carRaceController.process();

        String output = outputStream.toString();

        String winnerLine = extractWinner(output);
        String[] splitWinners = winnerLine.replace("최종 우승자 :", "").trim().split(",");
        Set<String> carSet = new HashSet<>(Arrays.asList(carName.split(",")));

        assertThat(output).contains("실행 결과");
        assertThat(output).contains("최종 우승자 :");
        assertThat(winnerLine).startsWith("최종 우승자 :");
        assertThat(Arrays.asList(car1, car2, car3)).allMatch(car -> output.contains(car + " :"));
        assertThat(Arrays.stream(splitWinners)
                .map(String::trim)
                .collect(Collectors.toSet()))
                .isSubsetOf(carSet);
    }

    @DisplayName("자동차 이름의 길이가 5를 초과할 경우 예외")
    @ParameterizedTest
    @CsvSource({
            "pobiiii,woni,jun,3",
            "car1,car2222,car3,5",
            "carA,carB,carCCCC,4"
    })
    void longCarNameException(String car1, String car2, String car3, String rounds) {
        setUpInput(car1, car2, car3, rounds);

        assertThatThrownBy(() -> carRaceController.process())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_TOO_LONG);
    }

    @DisplayName("시도 횟수가 음수일경우 예외")
    @ParameterizedTest
    @CsvSource({
            "pobi,woni,jun,-1",
            "car1,car2,car3,-4",
            "carA,carB,carC,-2"
    })
    void replyCountNegativeNumberException(String car1, String car2, String car3, String rounds) {
        setUpInput(car1, car2, car3, rounds);

        assertThatThrownBy(() -> carRaceController.process())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ATTEMPT_COUNT_CANNOT_BE_ZERO);
    }

    @DisplayName("잘못된 시도횟수 입력시 예외 발생")
    @ParameterizedTest
    @CsvSource({
            "pobi,woni,jun,one",
            "car1,car2,car3,two",
            "carA,carB,carC,exxcc"
    })
    void invalidReplyCountIntegerParseException(String car1, String car2, String car3, String rounds) {
        setUpInput(car1, car2, car3, rounds);

        assertThatThrownBy(() -> carRaceController.process())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPT_COUNT);
    }

    private static String setUpInput(String car1, String car2, String car3, String rounds) {
        String participants = String.join(",", car1, car2, car3);

        ByteArrayInputStream in = new ByteArrayInputStream((participants + "\n" + rounds + "\n").getBytes());
        System.setIn(in);
        Console.close();

        return participants;
    }

    private String extractWinner(String output) {
        Pattern pattern = Pattern.compile("최종 우승자 : .*");
        Matcher matcher = pattern.matcher(output);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

}