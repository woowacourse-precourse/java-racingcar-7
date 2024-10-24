package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.ViewScreenController;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;


public class ViewScreenControllerTest {
    // TOdo 입력에서 이름 오류 검출
    // TODO 입력에서 횟수가 숫자 아닌 경우

    private static ViewScreenController viewScreenController;

    @BeforeAll
    static void setUp() {
        String input = "pobi,woni,jun\n5\n";
        ByteArrayInputStream newTestInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(newTestInputStream);
        // 테스트용 GameManager 객체 초기화
        viewScreenController = new ViewScreenController();
    }

    @ParameterizedTest
    @CsvSource({"5,5", "12345,12345"})
    void 경주_횟수_입력_정상_동작1(String input, int expectedOutput) {
        assertEquals(expectedOutput, viewScreenController.checkRunTimesFormat(input));
    }

    @ParameterizedTest
    @CsvSource({"-3", "ccc"})
    void runTimes_올바르지_못한_입력(String input) {
        assertThatThrownBy(() -> viewScreenController.checkRunTimesFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void runTimes_nullCheck(String input) {
        assertThatThrownBy(() -> viewScreenController.checkRunTimesFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
