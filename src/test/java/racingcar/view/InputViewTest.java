package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void beforeEach() {
        inputView = new InputView();
    }

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름 입력을 받아 반환하는지 확인하는 테스트")
    void getCarNamesInput() {
        // given
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        String carNamesInput = inputView.getCarNamesInput();

        // then
        assertThat(carNamesInput).isEqualTo(input);
    }

    @Test
    @DisplayName("시도 횟수 입력을 받아 반환하는지 확인하는 테스트")
    void getAttemptCountInput() {
        // given
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        String attemptCountInput = inputView.getAttemptCountInput();

        // then
        assertThat(attemptCountInput).isEqualTo(input);
    }
}