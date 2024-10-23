package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RaceTest extends NsTest {

    @Test
    void 전진_조건_실패_테스트() {
        assertThatThrownBy(() -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                    },
                    10, 0
            );
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_경기_진행_테스트() {
        runAndAssert(3,3,"pobi,woni", "pobi : ", "woni : ", "최종 우승자 : 없음");
        runAndAssert(4,3,"car1,car2", "car1 : -", "car2 : ", "최종 우승자 : car1");
        runAndAssert(3,4,"car1,car2", "car1 : -", "car2 : -", "최종 우승자 : car1, car2");
    }

    private void runAndAssert(int aMove,int bMove,String carNames, String expectedAOutput, String expectedBOutput, String expectedWinnerOutput) {
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNames, "1");
                    assertThat(output()).contains(expectedAOutput, expectedBOutput, expectedWinnerOutput);
                },
                aMove,bMove
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
