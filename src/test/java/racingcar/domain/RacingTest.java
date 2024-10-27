package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[유닛 테스트] - 자동차 경주")
class RacingTest {

    private final Racing racing = new Racing();
    private final HashMap<String, StringBuilder> racingLog = new HashMap<>();

    @BeforeEach
    void setRacingLog() {
        racingLog.put("pobi", new StringBuilder().append("-"));
        racingLog.put("woni", new StringBuilder());
    }

    @Test
    @DisplayName("자동차 경주 시작 - 경주 기록과 자동차 이름을 전달하여 경주 시작 시 경주 결과 기록")
    void racingLogAndCarName_startRacing_recordRacingResult() {
        //given
        List<String> carNameList = List.of("pobi", "woni", "jun");
        int loopCount = 5;

        //when
        for (int i = 0; i < loopCount; i++) {
            racing.start(racingLog, carNameList);
        }

        //then
        assertThat(racingLog.get("pobi")).contains("-");
        assertThat(racingLog.get("woni").length()).isLessThanOrEqualTo(5);
    }
}