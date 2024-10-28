package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 쉼표가_아닌_다른_구분자_포함_경우() {
        String input = "pobi,woni.jun";
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.InputStringValidator(input);
        });
    }

    @Test
    void 이름_문자열_공백이_섞인_경우() {
        String input = "pobi,,jun";
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.InputStringValidator(input);
        });
    }

    @Test
    void 우승자_여러명() {
        Cars.makeCarslist(List.of("pobi", "woni", "jun"));
        Cars.cars.get(0).count = 3;
        Cars.cars.get(1).count = 3;
        Cars.cars.get(2).count = 2;

        Cars.printWinner();
    }

    @Test
    void 자동차_이름_중복() {
        String input = "pobi,pobi,jun";
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.InputStringValidator(input);
        });
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
