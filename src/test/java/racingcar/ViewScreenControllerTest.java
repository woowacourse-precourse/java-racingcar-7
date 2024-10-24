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

    private static ViewScreenController viewScreenController;

    @BeforeAll
    static void setUp() {
        String input = "pobi,woni,jun\n5\n";
        ByteArrayInputStream newTestInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(newTestInputStream);
        // 테스트용 viewScreenController를 더미데이터로 초기화
        viewScreenController = new ViewScreenController();
    }

    @ParameterizedTest
    @CsvSource({"5,5", "12345,12345"})
    void 경주_횟수_입력_정상_동작1(String input, int expectedOutput) {
        assertEquals(expectedOutput, viewScreenController.checkRunTimesFormat(input));
    }

    @ParameterizedTest
    @CsvSource({"-3", "ccc"})
    void 횟수_올바르지_못한_입력(String input) {
        assertThatThrownBy(() -> viewScreenController.checkRunTimesFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 횟수_널_체크(String input) {
        assertThatThrownBy(() -> viewScreenController.checkRunTimesFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"po,a,한글,d;[po, a, 한글, d]", "aba,sss  ,dd,Dd,S S;[aba, sss, dd, Dd, SS]"}, delimiter = ';')
    void 차량_이름_정상_동작(String input, String expectedOutput) {
        assertEquals(expectedOutput, viewScreenController.checkNameFormat(input).toString());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차_널_체크(String input) {
        assertThatThrownBy(() -> viewScreenController.checkRunTimesFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"-3", "aaa,c[c", "ab,ㅎcc", "s1s, ddd, f", "aaaaa,sssssss"})
    void 자동차_이름_올바르지_못한_입력(String input) {
        assertThatThrownBy(() -> viewScreenController.checkRunTimesFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
