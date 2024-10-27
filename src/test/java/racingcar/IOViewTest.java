package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.views.IOView;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOViewTest {
    private final IOView ioView = new IOView();

    @AfterEach
    void resetConsole() {
        Console.close();
    }

    @DisplayName("사용자로부터 자동차 이름을 입력 받고, 입력 받은 문자열의 앞뒤 공백을 제거한 값을 리턴한다")
    @Test
    void 자동차_입력_기능_테스트() {
        String mockInput = " car1,car2 ";
        String expectedOutput = "car1,car2";

        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(mockInputStream);

        String detectedInput = ioView.getCarInput();
        assertEquals(detectedInput, expectedOutput);
    }

    @DisplayName("사용자로부터 시도 횟수를 입력 받고, 입력 받은 문자열의 앞뒤 공백을 제거한 값을 리턴한다")
    @Test
    void 시도_횟수_입력_기능_테스트() {
        String mockInput = " 1 ";
        String expectedOutput = "1";

        ByteArrayInputStream mockInputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(mockInputStream);

        String detectedInput = ioView.getRoundInput();
        assertEquals(detectedInput, expectedOutput);
    }
}
