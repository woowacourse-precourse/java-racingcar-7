package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Player;
import racingcar.util.PlayerMaker;

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
    @DisplayName("players에 ,(쉼표)가 없으면 예외가 발생한다.")
    void playersInputTest1() {
        PlayerMaker playerMaker = new PlayerMaker();

        assertThatThrownBy(() -> playerMaker.createPlayer("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("player가 1명이면 예외가 발생한다.")
    void playersInputTest2() {
        PlayerMaker playerMaker = new PlayerMaker();

        assertThatThrownBy(() -> playerMaker.createPlayer("pobi,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("player의 이름이 숫자이면 예외가 발생한다.")
    void playersInputTest3() {
        PlayerMaker playerMaker = new PlayerMaker();

        assertThatThrownBy(() -> playerMaker.createPlayer("1111,24123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Plyaers를 입력받으면 plyaer를 가지는 객체를 반환한다.")
    void cratePlayerListTest() {
        // give
        String players = "pobi,woni";
        PlayerMaker playerMaker = new PlayerMaker();

        // when
        List<Player> playerList = playerMaker.createPlayer(players);

        //then
        assertThat(playerList).hasSize(2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
