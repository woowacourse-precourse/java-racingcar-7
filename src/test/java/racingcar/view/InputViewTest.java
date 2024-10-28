package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest{

    private final InputView inputView = new InputView();

    @Test
    void 올바른_시도_횟수_입력시_정수_반환() {
        //given
        run("5");
        //when
        int count = inputView.getCount();
        //then
        assertThat(count).isEqualTo(5);
    }

    @Test
    void 음수_시도_횟수_입력시_예외_발생() {
        //given
        run("-5");
        //when, then
        assertThatThrownBy(inputView::getCount).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_시도_횟수_입력시_예외_발생() {
        //given
        run("n");
        //when, then
        assertThatThrownBy(inputView::getCount).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수가_아닌_시도_횟수_입력시_예외_발생() {
        //given
        run("5.5");
        //when, then
        assertThatThrownBy(inputView::getCount).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
}