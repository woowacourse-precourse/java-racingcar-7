package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        this.inputView = new InputView();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("이름이 공백인 경우 예외발생")
    void 자동차_이름이_공백인_경우_예외발생() {
        // given
        System.setIn(readUserInput("\n3\n"));

        // when
        assertThatThrownBy(() -> inputView.readRacingInfo())
                .isInstanceOf(IllegalArgumentException.class);
    }

    public InputStream readUserInput(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }

}