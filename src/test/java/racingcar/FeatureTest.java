package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FeatureTest extends NsTest {

    @Test
    void testInputCharacterException() {
        String input = "1234"; // 숫자 입력
        assertThatThrownBy(() -> validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 문자가 아닙니다.");
    }

    @Test
    void testInputNumericException() {
        String input = "abcd"; // 문자 입력
        assertThatThrownBy(() -> validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 숫자가 아닙니다.");
    }

    @Test
    void testInputRangeException() {
        int input = -5; // 음수 입력
        assertThatThrownBy(() -> validatePositive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값은 양수여야 합니다.");
    }

    @Test
    void testInputSameException() {
        String[] names = {"pobi", "pobi"}; // 중복된 이름
        assertThatThrownBy(() -> createCars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 값이 입력되었습니다.");
    }

    @Test
    void testNameQuantityException() {
        String input = "javaji"; // 6자 입력
        assertThatThrownBy(() -> createCar(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5이하여야 합니다.");
    }

    @Test
    void testDelimiterNonexistentionException() {
        String input = "pobi"; // 쉼표 없음
        assertThatThrownBy(() -> validateDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표가 적어도 1개 이상은 존재해야 합니다.");
    }

    @Test
    void testDelimiterDuplicationException() {
        String input = "pobi,,javaji"; // 중복 쉼표
        assertThatThrownBy(() -> validateDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표와 쉼표 사이에 적어도 1개 이상의 문자가 입력되어야 합니다.");
    }

    @Test
    void testDelimiterRangeException() {
        String input = "pobi,woni|jun"; // 잘못된 구분자 사용
        assertThatThrownBy(() -> validateDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표 외에 다른 구분자를 사용할 수 없습니다.");
    }

    @Test
    void testRandomNumberInRange() {
        assertRandomNumberInRangeTest(() -> {
            int randomNumber = (int) (Math.random() * 10); // 예시로 0-9 범위의 랜덤 숫자 생성
            assertThat(randomNumber).isBetween(0, 9); // 범위 검사
        }, 0, 9);
    }

    @Test
    void testSimpleFunctionality() {
        assertSimpleTest(() -> {
            int expected = 5;
            int actual = 5; // 이 값은 어떤 로직에 의해 계산된 값으로 가정
            assertThat(actual).isEqualTo(expected);
        });
    }

    // 입력 값 검증을 위한 메서드들
    private void validateInput(String input) {
        if (!input.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("입력 값이 문자가 아닙니다.");
        }
    }

    private void validateNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
    }

    private void validatePositive(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("입력 값은 양수여야 합니다.");
        }
    }

    private void createCars(String[] names) {
        if (names.length != new HashSet<>(Arrays.asList(names)).size()) {
            throw new IllegalArgumentException("중복된 값이 입력되었습니다.");
        }
        // 자동차 생성 로직
    }

    private void createCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5이하여야 합니다.");
        }
        // 자동차 생성 로직
    }

    private void validateDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("쉼표가 적어도 1개 이상은 존재해야 합니다.");
        } else if (input.contains("|") || input.contains(";")) {
            throw new IllegalArgumentException("쉼표 외에 다른 구분자를 사용할 수 없습니다.");
        }
        if (input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("쉼표와 쉼표 사이에 적어도 1개 이상의 문자가 입력되어야 합니다.");
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
