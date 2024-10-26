package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

public class CheckInputTest extends NsTest {

    @Test
    @DisplayName("입력에 공백이 포함된 경우 트림 후 올바르게 파싱하는지 테스트")
    void testTrimAndSplitNames(){
        CheckInput checkInput = new CheckInput();
        String input = "노범석,         김수한무";
        String[] result = checkInput.splitNames(input);
        String[] expected = {"노범석","김수한무"};

        assertThat(result).containsExactly(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"노범석,김수한무", "java", "1111,222"})
    @DisplayName("한글,영문,숫자로 5글자 이하의 입력으로 주어질 때 테스트")
    void testValidNameLength(String input) {
        CheckInput checkInput = new CheckInput();
        assertThatNoException().isThrownBy(() -> {
            checkInput.splitNames(input);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"노범석,김수한무거북이", "java,abracadabra", "111111,222"})
    @DisplayName("한글,영문,숫자로 5글자를 초과하는 입력으로 주어질 때 테스트")
    void testInvalidNameLength(String input) {
        CheckInput checkInput = new CheckInput();
        assertThatThrownBy(() -> {
            checkInput.splitNames(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @ValueSource(strings = {"노범석, 노범석, 김수한무"})
    @DisplayName("공백 제거시 중복되는 이름이 주어질 때 테스트")
    void testAlreadyExistingName(String input) {
        CheckInput checkInput = new CheckInput();
        assertThatThrownBy(() -> {
            checkInput.splitNames(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "100"})
    @DisplayName("경주 횟수로 숫자 입력이 들어오는 경우")
    void testValidRaceCount(String input) {
        CheckInput checkInput = new CheckInput();
        assertThatNoException().isThrownBy(() -> {
            checkInput.isValidCount(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "one"})
    @NullAndEmptySource
    @DisplayName("경주 횟수로 숫자 외 입력이 들어오는 경우")
    void testInvalidRaceCount(String input) {
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
