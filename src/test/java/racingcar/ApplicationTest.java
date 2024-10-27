package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

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
                MOVING_FORWARD, STOP);
    }

    @Test
    void 테스트_No_Move() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("우승자가 없습니다.");
                },
                STOP, STOP
        );
    }

    @Test
    void 테스트_입력_이름_공백_제거와_중복_제거() {
        // given
        Input input = new Input();
        String carNames = "pobi, pobi , pobi, woni";
        List<String> result = Stream.of(carNames.split(",")).map(String::trim).distinct().toList();

        // when, then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void 테스트_중복이름_5개_초과() {
        // given
        Input input = new Input();
        String carNames = "pobi, pobi , pobi, woni, pobi  , june, pobi, pobi,pobi";
        List<String> result = Stream.of(carNames.split(",")).map(String::trim).distinct().toList();

        // when, then
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void 테스트_단수_우승() {
        // given
        List<String> carNames = List.of("woni", "pobi");
        int rounds = 2;
        RacingGame racingGame = new RacingGame(carNames);

        // when
        assertRandomNumberInRangeTest(
                () -> {
                    for (int round = 1; round <= rounds; round += 1){
                        racingGame.playNextRound();
                    }
                    RoundStatus finalRoundStatus = racingGame.getRoundStatus();

                    // then
                    CarStatus firstCarStatus = finalRoundStatus.getCarStatusList().get(0);
                    assertThat(firstCarStatus.getName()).isEqualTo("woni");
                    assertThat(firstCarStatus.getPosition()).isEqualTo(0);

                    CarStatus secondCardStatus = finalRoundStatus.getCarStatusList().get(1);
                    assertThat(secondCardStatus.getName()).isEqualTo("pobi");
                    assertThat(secondCardStatus.getPosition()).isEqualTo(2);
                },
                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 테스트_다수_우승자() {
        // given
        List<String> carNames = List.of("woni", "pobi", "mary");
        int rounds = 3;
        RacingGame racingGame = new RacingGame(carNames);

        // when
        assertRandomNumberInRangeTest(
                () -> {
                    for (int round = 1; round <= rounds; round += 1) {
                        racingGame.playNextRound();
                    }
                    RoundStatus finalRoundStatus = racingGame.getRoundStatus();

                    // then
                    assertThat(finalRoundStatus.getCarStatusList())
                            .allMatch(it -> it.getPosition() == 3);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트_이름_5글자_이상() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_출전_가능_차량_최대_5대() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,woni,june,bobb,joe", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_최대_10라운드() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java,woni,june", "11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
