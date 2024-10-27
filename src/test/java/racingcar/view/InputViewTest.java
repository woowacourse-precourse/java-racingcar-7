package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import racingcar.Application;

public class InputViewTest{
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = InputView.getInstance();
    }

    @Test
    @DisplayName("자동차 이름과 시도 횟수 입력받기")
    void readCarNamesAndTryCount() {
        String input = "car1,car2,car3\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String carNames = inputView.readCarNames();
        String tryCount = inputView.readTryCount();

        assertThat(carNames).isEqualTo("car1,car2,car3");
        assertThat(tryCount).isEqualTo("5");
    }
}
