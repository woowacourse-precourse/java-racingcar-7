package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    void 자동차_생성_성공_테스트() {
        assertSimpleTest(() -> {
            Car car = new Car("pobi", () -> true);
            car.move();
            assertThat(car.getName()).isEqualTo("pobi");
            assertThat(car.getPosition()).isOne();
        });
    }

    @Test
    void 자동차_이동_성공_테스트() {
        assertSimpleTest(() -> {
            Car car = new Car("pobi", () -> true);
            car.move();
            assertThat(car.getPosition()).isEqualTo(1);
        });
    }

    @Test
    void 자동차_이동_실패_테스트() {
        assertSimpleTest(() -> {
            Car car = new Car("pobi", () -> false);
            car.move();
            assertThat(car.getPosition()).isZero();
        });
    }

    @Test
    void 게임_생성_성공_테스트() {
        assertSimpleTest(() -> {
            List<String> names = Arrays.asList("pobi", "woni");
            Game game = new Game(names, new DefaultMoveStrategy(), 3);
            assertThat(game.getCars()).hasSize(2);
        });
    }

    @Test
    void 게임_라운드_성공_테스트() {
        assertSimpleTest(() -> {
            Game game = new Game(
                    Arrays.asList("pobi", "woni"),
                    new DefaultMoveStrategy(),
                    3
            );
            game.playRound();
            assertThat(game.getCars().get(0).getPosition()).isEqualTo(0);
        });
    }

    @Test
    void 게임_종료_성공_테스트() {
        Game game = new Game(
                Arrays.asList("pobi", "woni"),
                new DefaultMoveStrategy(),
                1
        );
        game.playRound();
        assertThat(game.isFinished()).isTrue();
    }

    @Test
    void 빈_입력_Exception_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 필수입니다.")
        );
    }

    @Test
    void 이름_길이초과_Exception_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javajigi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @Test
    void 이름_공백_Exception_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 공백일 수 없습니다.")
        );
    }

    @Test
    void 시도_횟수_음수_Exception_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("시도 횟수는 양수여야 합니다.")
        );
    }

    @Test
    void 시도_횟수_문자_Exception_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "sui"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("유효한 숫자를 입력해주세요.")
        );
    }

    @Test
    void 단독_우승자_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : ",
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,jun,sui", "1");
                    assertThat(output()).contains(
                            "pobi : -",
                            "jun : -",
                            "sui : ",
                            "최종 우승자 : pobi, jun"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
