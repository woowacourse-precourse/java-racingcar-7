package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckInputTest extends NsTest {

    @ParameterizedTest
//    @NullSource
    @EmptySource
    @ValueSource(strings = {"노범석,김수한무거북이","java,abracadabra","111111,222"})
    @DisplayName("한글,영문,숫자로 5글자 이상이 입력으로 주어질 때 테스트")
    void testValidNameLength(String input) {
        CheckInput checkInput = new CheckInput();
        assertThatThrownBy(() -> {
            checkInput.splitNames(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ","one"})
    @EmptySource
    @NullSource
    @DisplayName("경주 횟수로 숫자 외 입력이 들어오는 경우")
    void testValidRaceCount(String input) {
        CheckInput checkInput = new CheckInput();
        assertThatThrownBy(() -> {
            checkInput.isValidCount(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        // Application 클래스의 main 메서드를 실행
        Application.main(new String[]{});
    }
}
