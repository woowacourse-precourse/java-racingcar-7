package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    void 문자열을_숫자로_바꾸는_테스트() {
        InputView inputView = new InputView();
        assertEquals(inputView.convertStringToInt("12345"),12345);
    }

    @Test
    void 문자열을_콤마_기준으로_나누는_테스트() {
        InputView inputView = new InputView();
        String[] expect = {"kim","lee","alpha","bravo"};
        assertArrayEquals(inputView.splitCarName("kim,lee,alpha,bravo"),expect);
    }
}
