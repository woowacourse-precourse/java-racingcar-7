package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validation.AttemptCountValidation;
import racingcar.validation.CarNameValidation;

import java.util.ArrayList;
import java.util.List;

class InputViewTest {

    @Test
    @DisplayName("입력_가능한_자동차_이름_테스트")
    void carNameTest() {
        List<String> inputs = new ArrayList<>();
        inputs.add("pobi, hani, suzi");
        inputs.add(" p  o bi, HanI");
        inputs.add("~!@a, a123");
        inputs.stream()
                .forEach(input -> new CarNameValidation());
    }

    @Test
    @DisplayName("입력_가능한_시도할_횟수_테스트")
    void attemptCountTest() {
        List<String> inputs = new ArrayList<>();
        inputs.add("1");
        inputs.add("1000");
        inputs.stream()
                .forEach(input -> new AttemptCountValidation());
    }
}