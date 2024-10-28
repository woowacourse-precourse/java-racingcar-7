package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    @DisplayName("차 이름 입력 테스트")
    public void inputCarsTest() {
        String input = "pobi,woni,jun";
        String[] cars = InputView.parseCars(input);
        Assertions.assertThat(cars).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 최소 2개 이상")
    public void minimumOneCarNameTest() {
        String input = "";

        Assertions.assertThatThrownBy(() -> InputView.parseCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 최소 2대이상 입력해야합니다.");
    }

    @Test
    @DisplayName("자동차 이름 , 로 구분")
    public void emptyCarNameTest() {
        String input = "pobi,,jun";
        String[] cars = InputView.parseCars(input);
        Assertions.assertThat(cars).containsExactly("pobi", "jun");
    }

    @Test
    @DisplayName("자동차 이름 5자 초과")
    public void lengthCarNameTest() {
        String input = "wooaaaaahancorse,pobi";

        Assertions.assertThatThrownBy(() -> InputView.parseCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름 중복")
    public void duplicateCarNameTest() {
        String input = "pobi,woni,pobi";

        Assertions.assertThatThrownBy(() -> InputView.parseCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 영문자 및 숫자 이외의 문자 포함")
    public void invalidCarNameCharactersTest() {
        String input = ";,woni,jun";
        
        Assertions.assertThatThrownBy(() -> InputView.parseCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 영문자와 숫자만 포함해야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름에 띄어쓰기 입력")
    public void invalidCarNameSpaceTest() {
        String input = " ,   , ";

        Assertions.assertThatThrownBy(() -> InputView.parseCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 최소 2대이상 입력해야합니다.");
    }

    @Test
    @DisplayName("앞이나 뒤에 쉼표 들어오는경우")
    public void trimLeadingAndTrailingCommasTest() {
        String input = ",pobi,woni,jun,";
        String cars[] = InputView.parseCars(input);

        Assertions.assertThat(cars).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("시도 횟수 공백")
    public void emptyAttemptsTest() {
        String input = "";

        Assertions.assertThatThrownBy(() -> InputView.parseAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 숫자로 입력해야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수 숫자 X")
    public void invalidAttemptsTest() {
        String input = "abc";

        Assertions.assertThatThrownBy(() -> InputView.parseAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 숫자로 입력해야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수 양수 X")
    public void positiveAttemptsTest() {
        String input = "-1";

        Assertions.assertThatThrownBy(() -> InputView.parseAttempts(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 양수를 입력해주세요");
    }
}
