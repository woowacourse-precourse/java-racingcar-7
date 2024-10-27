package racingcar.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constants.ErrorMessages.NUMBER_FORMAT_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    private final InputStream originalSystemIn = System.in;

    @AfterEach
    void restoreSystemInStream() {
        System.setIn(originalSystemIn);
        Console.close();
    }

    private void setInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
    }

    @DisplayName("자동차 이름을 입력받으면 정상적으로 추출한다")
    @Test
    void 자동차_이름_입력_정상_추출() {
        //given
        String input = "car,car1,car12\n";
        setInput(input);

        //when
        List<String> carNames = InputHandler.requestCarNames();
        List<String> expectedCarNames = Arrays.asList("car", "car1", "car12");

        //then
        assertEquals(expectedCarNames, carNames);
    }

    @DisplayName("입력한 이름에 앞뒤 공백이 있을 경우 공백을 제거한다")
    @Test
    void 자동차_이름_입력_공백_제거() {
        //given
        String input = "  car,car1  ,         car12\n";
        setInput(input);

        //when
        List<String> carNames = InputHandler.requestCarNames();
        List<String> expectedCarNames = Arrays.asList("car", "car1", "car12");

        //then
        assertEquals(expectedCarNames, carNames);
    }

    @DisplayName("입력한 시도 횟수를 정상적으로 반환한다")
    @Test
    void 시도_횟수_입력_정상_반환() {
        //given
        String input = "4\n";
        setInput(input);

        //when
        int totalRounds = InputHandler.requestTotalRounds();

        //then
        assertEquals(4, totalRounds);
    }

    @DisplayName("입력한 시도 횟수가 숫자가 아니면 예외를 발생시킨다")
    @Test
    void 시도_횟수_입력_숫자_형식_오류() {
        //given
        String input = "a\n";
        setInput(input);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> InputHandler.requestTotalRounds());

        //then
        assertEquals(NUMBER_FORMAT_ERROR_MESSAGE, exception.getMessage());
    }
}
