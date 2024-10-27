package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    InputView inputView = new InputView();
    Validator validator = new Validator();
    @DisplayName("이름이 5글자가 넘으면 예외가 발생한다.")
    @Test
    void carNameInputTest() {
        ByteArrayInputStream input = new ByteArrayInputStream("escape".getBytes(StandardCharsets.UTF_8));
        System.setIn(input);
        String name = inputView.readNames();
        Assertions.assertThatThrownBy(() -> validator.nameValidate(name) )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 정수가 아니면 예외가 발생한다.")
    @Test
    void trialInputIsIntegerTest() {
        ByteArrayInputStream input = new ByteArrayInputStream("삼".getBytes(StandardCharsets.UTF_8));
        System.setIn(input);
        String trial = inputView.readNames();
        Assertions.assertThatThrownBy(() -> validator.trialValidate(trial) )
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("시도 횟수가 양의 정수가 아니면 예외가 발생한다.")
    @Test
    void trialInputIsPositiveTest() {
        ByteArrayInputStream input = new ByteArrayInputStream("-3".getBytes(StandardCharsets.UTF_8));
        System.setIn(input);
        String trial = inputView.readNames();
        Assertions.assertThatThrownBy(() -> validator.trialValidate(trial) )
                .isInstanceOf(IllegalArgumentException.class);
    }
}