package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[유닛 테스트] - 우승자 결정")
class WinnerDeterminerTest {

    private final WinnerDeterminer winnerDeterminer = new WinnerDeterminer();

    @Test
    @DisplayName("우승자 결정 - 최대 이동 거리가 0일 경우 null 반환")
    void maxMoveCountIsZero_winnerDeterminer_returnNull() {
        //given & when
        HashMap<String, Integer> racingLog = new HashMap<>();
        racingLog.put("pobi", 0);
        racingLog.put("woni", 0);

        List<String> carNameList = List.of("pobi", "woni");

        List<String> winner = winnerDeterminer.determineWinner(racingLog, carNameList);

        //then
        assertThat(winner).isNull();
    }

    @Test
    @DisplayName("우승자 결정 - 최대 이동 거리와 같은 거리를 이동한 자동차가 있을 경우 우승자 목록 반환")
    void carsAtMaxMoveCount_winnerDeterminer_returnWinnerList() {
        //given
        HashMap<String, Integer> racingLog = new HashMap<>();
        racingLog.put("pobi", 2);
        racingLog.put("woni", 2);
        racingLog.put("jun", 1);

        List<String> carNameList = List.of("pobi", "woni", "jun");

        //when
        List<String> winner = winnerDeterminer.determineWinner(racingLog, carNameList);

        //then
        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.get(0)).isEqualTo("pobi");
        assertThat(winner.get(1)).isEqualTo("woni");
    }
}