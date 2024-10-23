package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IOHandlerTest extends NsTest {

    @Test
    @DisplayName("올바른 입력 테스트")
    void 올바른입력테스트() {
        // given
        IOHandler ioHandler = new IOHandler();

        // when
        run("pobi,woni,jun", "3");  // 여기서 미리 정의된 입력값을 run 메서드로 실행
        UserInput userInput = ioHandler.inputCarNamesAndAttemptCount();

        // then
        assertEquals("pobi,woni,jun", userInput.carNames());  // 자동차 이름이 올바르게 입력되었는지 검증
        assertEquals("3", userInput.attemptCount());  // 시도 횟수가 올바르게 입력되었는지 검증
    }

    // Validator 테스트에서 예외 발생 여부를 확인하므로 IOHandler에서는 예외가 발생하지 않음
    @Test
    @DisplayName("빈 문자열 입력 테스트 - 예외는 발생하지 않음")
    void 빈문자열입력테스트() {
        // given
        IOHandler ioHandler = new IOHandler();

        // when
        run("", "");
        UserInput userInput = ioHandler.inputCarNamesAndAttemptCount();

        // then
        assertEquals("", userInput.carNames());
        assertEquals("", userInput.attemptCount());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}