package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    @AfterEach
    void restoreSetting() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름을 정확하게 입력받는지 확인")
    void 기능_테스트_자동차_이름_입력() {

        String testCarNames = "pobi, java";
        provideInput(testCarNames);

        String actualCarNames = InputManager.readCarNames();

        assertThat(testCarNames).isEqualTo(actualCarNames);
    }

    @Test
    @DisplayName("시도 횟수를 정확하게 입력받는지 확인")
    void 기능_테스트_시도_횟수_입력() {

        String testTryCount = "6";
        provideInput(testTryCount);

        String actualTryCount = InputManager.readTryCount();

        assertThat(testTryCount).isEqualTo(actualTryCount);
    }

    private void provideInput(String inputData) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(testIn);
    }
}