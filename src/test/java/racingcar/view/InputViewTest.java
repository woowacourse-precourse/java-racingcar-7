package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.InputView;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    public void tearDown() {
        Console.close();
    }

    @Test
    public void Input_자동차입력_테스트() {
        String inputString = "ACar, BCar, CCar";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        String result = inputView.inputCars();
        assertThat(result)
                .isEqualTo("ACar, BCar, CCar");
    }

    @Test
    public void Input_자동차입력_빈문자열_예외테스트() {
        String inputString = "\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(inputView::inputCars)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Input_횟수입력_테스트() {
        String inputString = "3";
        int expectValue = Integer.parseInt(inputString);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        assertEquals(inputView.inputCount(), expectValue);
    }

    @Test
    public void Input_횟수입력_빈문자열_예외테스트() {
        String inputString = "\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(inputView::inputCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
