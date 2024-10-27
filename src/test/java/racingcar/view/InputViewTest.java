package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    @DisplayName("차 이름 입력 테스트")
    public void inputCarsTest() {
        String input = "pobi,woni,jun";
        String[] cars = input.split(",");
        Assertions.assertThat(cars).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름 최소 1개 이상")
    public void minimumOneCarNameTest() {
        String cars = ",";
        String[] splitCars = cars.split(",");
        Assertions.assertThatThrownBy(() -> InputView.testValidateCars(splitCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 최소 1개 이상 입력해야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름 공백")
    public void emptyCarNameTest() {
        String input = "pobi,,jun";
        String[] cars = input.split(",");
        Assertions.assertThatThrownBy(() -> InputView.testValidateCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 5자 초과")
    public void lengthCarNameTest() {
        String cars = "wooaahancorse";
        String[] splitCars = cars.split(",");
        Assertions.assertThatThrownBy(() -> InputView.testValidateCars(splitCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름 중복")
    public void duplicateCarNameTest() {
        String input = "pobi,woni,pobi";
        String[] cars = input.split(",");
        Assertions.assertThatThrownBy(() -> InputView.testValidateCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 영문자 및 숫자 이외의 문자 포함")
    public void invalidCarNameCharactersTest() {
        String input = ";,woni,jun";
        String[] cars = input.split(",");
        Assertions.assertThatThrownBy(() -> InputView.testValidateCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 영문자와 숫자만 포함해야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수 공백")
    public void emptyAttemptsTest() {
        String attempts = "";
        Assertions.assertThatThrownBy(() -> InputView.testValidateAttemptsInput(attempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 숫자로 입력해야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수 숫자 X")
    public void invalidAttemptsTest() {
        String attempts = "abc";
        Assertions.assertThatThrownBy(() -> InputView.testValidateAttemptsInput(attempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 숫자로 입력해야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수 양수 X")
    public void positiveAttemptsTest() {
        String attempts = "-1";
        Assertions.assertThatThrownBy(() -> InputView.validateAttempts(Integer.parseInt(attempts)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 양수를 입력해주세요");
    }
}
