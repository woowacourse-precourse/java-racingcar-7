package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

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

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
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
    @DisplayName("정상적인 입력")
    void 자동차_횟수_입력_테스트() {
        assertSimpleTest(() -> {
            run("poby,woni,jun", "3");
            assertThat(output())
                    .contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", "시도할 횟수는 몇 회인가요?");
        });
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과")
    void 자동차_이름_5글자_이상() {
        assertThatThrownBy(() -> {
            run("poby,woni,abcdef", "3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하로 입력 해야합니다.");
    }

    @Test
    @DisplayName("이름을 입력하지 않았을 때")
    void 자동차_이름_입력하지_않았을때() {
        assertThatThrownBy(() -> {
            run("\n", "3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("공백을 포함했을 때")
    void 자동차_이름_공백포함() {
        assertThatThrownBy(() -> {
            run(" poby,woni,jun", "3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 포함하면 안됩니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우")
    void 자동차_이름_중복() {
        assertThatThrownBy(() -> {
            run("poby,woni,poby", "3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복되면 안됩니다.");
    }

    @Test
    @DisplayName("시도 횟수 입력을 하지 않았을 때")
    void 시도_횟수_입력하지_않았을때() {
        assertThatThrownBy(() -> {
            run("poby,woni,jun", "\n");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수가 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("시도 횟수 공백 포함")
    void 시도_횟수_공백_포함() {
        assertThatThrownBy(() -> {
            run("poby,woni,jun", " ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 포함하면 안됩니다.");
    }

    @Test
    @DisplayName("시도 횟수 숫자 이외의 값 입력")
    void 시도_횟수_숫자_이외의_값_입력() {
        assertThatThrownBy(() -> {
            run("poby,woni,jun", "@");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양의 정수로 입력 해야합니다.");
    }

    @Test
    @DisplayName("시도 횟수 0 또는 음수")
    void 시도_횟수_0_또는_음수_입력() {
        assertThatThrownBy(() -> {
            run("poby,woni,jun", "-1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양의 정수로 입력 해야합니다.");
    }

    @Test
    @DisplayName("자동차 경주를 정상적으로 시작할 때")
    void 정상적인_경주_시작() {
        HashMap<String, Integer> cars = new HashMap<>();
        cars.put("poby", 0);
        cars.put("woni", 0);

        assertSimpleTest(() -> {
            new Race().startRace(cars, 2);
            assertThat(output()).contains("실행 결과", "poby : ", "woni : ");
        });
    }

    @Test
    @DisplayName("자동차가 이동하는지 확인")
    void 자동차_위치_업데이트_테스트() {
        HashMap<String, Integer> cars = new HashMap<>();
        cars.put("poby", 0);
        cars.put("woni", 0);

        assertSimpleTest(() -> {
            new Race().startRace(cars, 1);
            assertThat(cars.get("poby")).isGreaterThanOrEqualTo(0);
            assertThat(cars.get("woni")).isGreaterThanOrEqualTo(0);
        });
    }

    @Test
    @DisplayName("경주 결과가 한 명일 때")
    void 경주_결과_한명의_우승자_출력() {
        HashMap<String, Integer> cars = new HashMap<>();
        cars.put("poby", 3);
        cars.put("woni", 1);
        cars.put("jun", 2);

        assertSimpleTest(() -> {
            new Race().resultRace(cars);
            assertThat(output()).contains("최종 우승자 : poby");
        });
    }

    @Test
    @DisplayName("경주 결과가 여러 명일 때")
    void 경주_결과_다수의_우승자_테스트() {
        HashMap<String, Integer> cars = new HashMap<>();
        cars.put("poby", 4);
        cars.put("woni", 4);
        cars.put("jun", 2);

        assertSimpleTest(() -> {
            new Race().resultRace(cars);
            assertThat(output()).contains("최종 우승자 : poby, woni");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
