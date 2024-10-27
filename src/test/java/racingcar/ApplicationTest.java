package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Player;
import racingcar.util.PlayerMaker;
import racingcar.util.Racing;
import racingcar.util.WinnerMaker;
import racingcar.validation.CounterValidation;
import racingcar.validation.PlayerValidation;

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
        assertThatThrownBy(() -> PlayerValidation.validation("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("player가 1명이면 예외가 발생한다.")
    void playersInputTest2() {
        assertThatThrownBy(() -> PlayerValidation.validation("pobi,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("player의 이름이 숫자이면 예외가 발생한다.")
    void playersInputTest3() {
        assertThatThrownBy(() -> PlayerValidation.validation("1111,24123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("player의 이름이 특수문자이면 예외가 발생한다.")
    void playersInputTest4() {
        assertThatThrownBy(() -> PlayerValidation.validation("pobi,?!@!,java"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("player의 이름이 한글이라도 단어가 아니면 예외가 발생한다.")
    void playersInputTest5() {
        assertThatThrownBy(() -> PlayerValidation.validation("pobi,ㅁㄱ,java"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(",(쉼표)가 연속으로 입력되면 예외가 발생한다.")
    void playersInputTest6() {
        assertThatThrownBy(() -> PlayerValidation.validation("pobi,,,,java"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("player 중간에 숫자가 들어가면 예외가 발생한다.")
    void playersInputTest7() {
        assertThatThrownBy(() -> PlayerValidation.validation("pob1,java"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("player 중간에 초성이 들어가면 예외가 발생한다.")
    void playersInputTest8() {
        assertThatThrownBy(() -> PlayerValidation.validation("pobㄱ,java"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("player 중간에 특수문자가 들어가면 예외가 발생한다.")
    void playersInputTest9() {
        assertThatThrownBy(() -> PlayerValidation.validation("pob?,java"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {",", "a", "가", "1.3"})
    @DisplayName("count가 숫자가 아니면 예외를 발생한다.")
    void countInputTest1(String count) {
        assertThatThrownBy(() -> CounterValidation.validation(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    @DisplayName("count의 값이 양수가 아니면 예외가 발생한다.")
    void countInputTest2(String count) {
        assertThatThrownBy(() -> CounterValidation.validation(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Plyaers를 입력받으면 plyaer를 가지는 객체를 반환한다.")
    void cratePlayerListTest() {
        // give
        String players = "pobi,woni";

        // when
        List<Player> playerList = PlayerMaker.createPlayer(players);

        //then
        assertThat(playerList).hasSize(2);
    }

    @Test
    @DisplayName("랜덤 값이 4이상이면 전진한다.")
    void forwardTest() {
        // give
        Player player = new Player("pobi", 0);
        int randomNumber = 4;

        // when
        Racing.move(player, randomNumber);

        //then
        assertThat(player.getScore()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4미만이면 정지한다.")
    void stopTest() {
        // give
        Player player = new Player("pobi", 0);
        int randomNumber = 3;

        // when
        Racing.move(player, randomNumber);

        // then
        assertThat(player.getScore()).isEqualTo(0);
    }

    @Test
    @DisplayName("최종 우승자가 두 명일 때의 출력를 테스트한다.")
    void winnerTest1() {
        // give
        List<Player> players = List.of(
                new Player("pobi", 3),
                new Player("woni", 3),
                new Player("java", 2));

        // when
        String winner = WinnerMaker.createWinner(players);

        // then
        assertThat(winner).isEqualTo("pobi, woni");
    }

    @Test
    @DisplayName("최종 우승자가 세 명일 때의 출력를 테스트한다.")
    void winnerTest2() {
        // give
        List<Player> players = List.of(
                new Player("pobi", 3),
                new Player("woni", 3),
                new Player("java", 3));

        // when
        String winner = WinnerMaker.createWinner(players);

        // then
        assertThat(winner).isEqualTo("pobi, woni, java");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
