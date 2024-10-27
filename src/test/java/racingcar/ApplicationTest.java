package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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

    @Test
    public void 자동차_이름_입력받는_기능_테스트() {
        assertSimpleTest(() -> {
            // given
            String names = "창의";
            String moveCount = "1";

            // when
            run(names, moveCount);

            // then
            assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        });
    }

    @Test
    public void 자동차_이동횟수_입력받는_기능_테스트() {
        assertSimpleTest(() -> {
            // given
            String names = "창의";
            String moveCount = "1";

            // when
            run(names, moveCount);

            // then
            assertThat(output()).contains("시도할 횟수는 몇 회인가요?");
        });
    }

    @Test
    public void 자동차_이름_분리_테스트() {
        assertSimpleTest(() -> {
            // given
            String names = "창의, 민규, 지후, 상현     , 민재";
            String moveCount = "1";
            List<String> namesList = List.of("창의", "민규", "지후", "상현", "민재");

            // when
            run(names, moveCount);

            // then
            assertThat(output()).contains(namesList);
        });
    }

    @Test
    public void 자동차_이름_1자미만_테스트() {
        assertSimpleTest(() -> {
            // given
            String names = ",";
            String moveCount = "1";

            // when
            assertThatThrownBy(() -> run(names, moveCount))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 자동차_이름_5자초과_테스트() {
        assertSimpleTest(() -> {
            // given
            String names = "람보르기니우르스, 제네시스GV80";
            String moveCount = "1";

            // when
            assertThatThrownBy(() -> run(names, moveCount))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 자동차_이동횟수_1미만_테스트() {
        assertSimpleTest(() -> {
            // given
            String names = "페라리, 람보";
            String moveCount = "0";

            // when
            assertThatThrownBy(() -> run(names, moveCount))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 자동차_없는_테스트() {
        assertSimpleTest(() -> {
            // given
            String names = "";
            String moveCount = "1";

            // when
            assertThatThrownBy(() -> run(names, moveCount))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 자동차_중복_이름_테스트() {
        assertSimpleTest(() -> {
            // given
            String names = "페라리, 페라리";
            String moveCount = "1";

            // when
            assertThatThrownBy(() -> run(names, moveCount))
                    // then
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 자동차_랜덤값_4이상_테스트() {
        assertRandomNumberInRangeTest(() -> {
                    // given
                    String names = "창의, 지후";
                    String moveCount = "3";

                    // when
                    run(names, moveCount);

                    // then
                    assertThat(output())
                            .contains("창의 : ---")
                            .contains("지후 : ---");
                },
                4, 5, 6, 7, 8, 9
        );
    }

    @Test
    public void 자동차_랜덤값_3이하_테스트() {
        assertRandomNumberInRangeTest(() -> {
                    // given
                    String names = "창의, 지후";
                    String moveCount = "2";

                    // when
                    run(names, moveCount);

                    // then
                    assertThat(output()).doesNotContain(": -");
                },
                3, 2, 1, 0
        );
    }

    @Test
    public void 자동차_경주_게임_다수_우승자_테스트() {
        assertRandomNumberInRangeTest(() -> {
                    // given
                    String names = "창의, 지후, 민재, 민규, 상현";
                    String moveCount = "1";

                    // when
                    run(names, moveCount);

                    // then
                    assertThat(output()).contains(names);
                },
                4, 4, 4, 4, 4
        );
    }

    @Test
    public void 자동차_경주_게임_결과_출력_테스트() {
        assertRandomNumberInRangeTest(() -> {
                    // given
                    String names = "창의, 지후";
                    String moveCount = "1";

                    // when
                    run(names, moveCount);

                    // then
                    assertThat(output())
                            .contains("실행 결과")
                            .contains("창의 : ")
                            .contains("지후 : ");
                },
                4, 4
        );
    }

    @Test
    public void 자동차_경주_게임_우승자_출력_테스트() {
        assertRandomNumberInRangeTest(() -> {
                    // given
                    String names = "창의, 지후";
                    String moveCount = "1";

                    // when
                    run(names, moveCount);

                    // then
                    assertThat(output())
                            .contains("최종 우승자 :")
                            .contains(names);
                },
                4, 4
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
