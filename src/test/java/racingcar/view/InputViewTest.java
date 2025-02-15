package racingcar.view;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class InputViewTest {

    @Test
    void 자동차_이름_입력값_분리() {
        InputView inputView = new InputView() {
            @Override
            protected String readInput() {
                return "tobi,woni,jun";
            }
        };
        List<String> result = inputView.inputCarNames();
        assertThat(result).containsExactly("tobi", "woni", "jun");
    }

    @Test
    void 실행횟수가_0일때_예외() {
        InputView inputView = new InputView() {
            @Override
            protected String readInput() {
                return "0";
            }
        };
        assertThatThrownBy(inputView::inputCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실행횟수가_숫자가_아닐때_예외() {
        InputView inputView = new InputView() {
            @Override
            protected String readInput() {
                return "abc";
            }
        };
        assertThatThrownBy(inputView::inputCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실행횟수가_빈_값_예외() {
        InputView inputView = new InputView() {
            @Override
            protected String readInput() {
                return "";
            }
        };
        assertThatThrownBy(inputView::inputCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실행횟수가_음수_예외() {
        InputView inputView = new InputView() {
            @Override
            protected String readInput() {
                return "-1";
            }
        };
        assertThatThrownBy(inputView::inputCount)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 실행횟수가_int범위_보다_큰_예외() {
        InputView inputView = new InputView() {
            @Override
            protected String readInput() {
                return "2147483648";
            }
        };
        assertThatThrownBy(inputView::inputCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상적인_입력() {
        InputView inputView = new InputView() {
            @Override
            protected String readInput() {
                return "3";
            }
        };
        int count = inputView.inputCount();
        assertThat(count).isEqualTo(3);
    }
}