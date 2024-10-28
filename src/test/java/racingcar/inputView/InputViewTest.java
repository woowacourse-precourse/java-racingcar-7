package racingcar.inputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.util.InputParser;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static java.beans.Beans.isInstanceOf;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

    private InputStream originalIn;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    void 라운드_횟수_유효한_입력_테스트() {
        String mockInput = "5\n";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        // InputView 인스턴스 생성
        InputView inputView = new InputView();

        // 메서드 호출 및 검증
        String roundCount = inputView.getRoundCount();
        assertEquals("5", roundCount);
    }

}
