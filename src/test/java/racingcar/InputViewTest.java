package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    @DisplayName("자동차 이름을 쉼표로 구분하여 입력받고 배열로 반환한다")
    void inputCarNames_ShouldReturnListOfCarNames() {
        // Mocking the input using ByteArrayInputStream
        String input = "pobi,woni,jun\n"; // 개행 문자 추가
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        List<Car> cars = inputView.inputCarNames();

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
    }

//    @Test
//    @DisplayName("시도 횟수를 입력받아 반환한다")
//    void inputAttempts_ShouldReturnAttempts() {
//        // Mocking the input using ByteArrayInputStream
//        String input = "3\n"; // 개행 문자 추가
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//
//        InputView inputView = new InputView(in); // InputStream을 주입
//        int attempts = inputView.inputAttempts();
//
//        assertThat(attempts).isEqualTo(3);
//    }
//
//    @Test
//    @DisplayName("잘못된 이동 횟수 입력시 예외 발생")
//    void inputAttempts_ShouldThrowExceptionForInvalidInput() {
//        // Mocking the input using ByteArrayInputStream
//        String input = "abc\n"; // Non-integer input
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        InputView inputView = new InputView();
//
//        // The input should be processed without any issues until it tries to parse
//        assertThatThrownBy(inputView::inputAttempts)
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("잘못된 입력입니다. 숫자를 입력하세요.");
//    }

}
