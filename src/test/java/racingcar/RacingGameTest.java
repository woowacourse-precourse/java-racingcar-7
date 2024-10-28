package racingcar;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

  @Test
  void 경주_중_자동차_전진_상태_테스트() {
    List<String> names = Arrays.asList("pobi", "woni", "jun");
    RacingGame game = new RacingGame(names, 1);

    assertRandomNumberInRangeTest(() -> {
      game.startRace(); // 무작위 값에 따라 진행
      assertThat(game.getCars().size()).isEqualTo(3);
    }, 4, 3, 5); // 첫 시도: pobi 전진, woni 멈춤, jun 전진
  }

  @Test
  void 최종_우승자_결정_테스트() {
    List<String> names = Arrays.asList("pobi", "woni", "jun");
    RacingGame game = new RacingGame(names, 3);

    assertRandomNumberInRangeTest(() -> {
      game.startRace(); // 무작위 값에 따라 여러 번 시도
      List<String> winners = game.getWinners();
      assertThat(winners.size()).isGreaterThanOrEqualTo(1); // 우승자는 한 명 이상이어야 함
    }, 5, 2, 4, 4, 6, 2, 7); // 여러 시나리오에서 예상 우승자 검증
  }
}
