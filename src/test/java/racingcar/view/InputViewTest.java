package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest{

    @Test
    void 올바른_자동차_이름_입력시_이름_반환() {
        //given
        run("pobi,woni,jun");
        //when
        String[] carNames = InputView.getCarNames();
        //then
        assertThat(carNames).containsExactly("pobi","woni","jun");
    }

    @Test
    void 올바른_시도_횟수_입력시_정수_반환() {
        //given
        run("5");
        //when
        int count = InputView.getCount();
        //then
        assertThat(count).isEqualTo(5);
    }

    @Test
    void 음수_시도_횟수_입력시_예외_발생() {
        //given
        run("-5");
        //when, then
        assertThatThrownBy(InputView::getCount).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_시도_횟수_입력시_예외_발생() {
        //given
        run("n");
        //when, then
        assertThatThrownBy(InputView::getCount).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수가_아닌_시도_횟수_입력시_예외_발생() {
        //given
        run("5.5");
        //when, then
        assertThatThrownBy(InputView::getCount).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
}