package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
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
    void 자동차_이동_테스트() {
        // Given
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        LinkedHashMap<String, Integer> carDistanceResults = new LinkedHashMap<>();

        for (String carName : carNames) {
            carDistanceResults.put(carName, 0);
        }

        // When
        Application.updateDistance(carDistanceResults, "pobi", MOVING_FORWARD);
        Application.updateDistance(carDistanceResults, "woni", MOVING_FORWARD);
        Application.updateDistance(carDistanceResults, "jun", STOP);

        // Then: 결과 검증
        assertThat(carDistanceResults.get("pobi")).isEqualTo(1);
        assertThat(carDistanceResults.get("woni")).isEqualTo(1);
        assertThat(carDistanceResults.get("jun")).isEqualTo(0);

    }

    @Test
    void 자동차_경주_결과_테스트() {
        // Given: 자동차 이름과 이동 횟수 설정
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        int numberOfMoves = 5;

        // When: playGame() 메서드 호출
        List<String> winners = Application.playGame(carNames, numberOfMoves);

        // Then: 결과 검증
        assertThat(winners).isNotEmpty();
        assertThat(output()).contains("pobi", "woni", "jun");
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
