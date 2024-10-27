package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    void setUp() {
        Console.close();
    }

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalSystemIn);
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    @DisplayName("자동차 이름이 정상적으로 리스트에 담기는지 테스트")
    void inputCarNames_returnCarNamesList() {
        //given
        provideInput("car1,car2,car3");

        //when
        List<String> carNames = InputView.inputCarNames();

        //then
        Assertions.assertThat(carNames).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외 발생")
    void validateCarName_throwException_whenNameLengthIsOver5() {
        //given
        provideInput("car1,carqwq,car3");

        //when & then
        Assertions.assertThatThrownBy(() -> InputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1~5자 이내여야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 비어있는 경우 예외 발생")
    void inputCarNames_throwException_whenNameIsBlank() {
        //given
        provideInput("car1,car3, ");

        //when & then
        Assertions.assertThatThrownBy(() -> InputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈칸이 아니어야 합니다.");
    }

    @Test
    @DisplayName("중복된 자동차 이름이 입력될 경우 예외 발생")
    void inputCarNames_throwException_whenDuplicateNamesExist() {
        //given
        provideInput("car1,car2,car1");

        //when & then
        Assertions.assertThatThrownBy(() -> InputView.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }
}
