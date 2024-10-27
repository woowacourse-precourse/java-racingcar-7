package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

}
