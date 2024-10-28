package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    void 입력값_검증_테스트() {
        assertAll(
                () -> assertThatThrownBy(() -> Application.validateInput("woni,pobi", "1a"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Application.validateInput("", "1"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Application.validateInput(null, "1"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Application.validateInput("woni,pobi", ""))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Application.validateInput("woni,pobi", null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Nested
    class 자동차_경주_테스트 {

        @Test
        void 자동차_이동_테스트() {
            // Given
            List<String> carNames = Arrays.asList("pobi", "woni", "gray");
            LinkedHashMap<String, Integer> carDistanceResults = new LinkedHashMap<>();

            for (String carName : carNames) {
                carDistanceResults.put(carName, 0);
            }

            // When
            Application.updateDistance(carDistanceResults, "pobi", MOVING_FORWARD);
            Application.updateDistance(carDistanceResults, "woni", MOVING_FORWARD);
            Application.updateDistance(carDistanceResults, "gray", STOP);

            // Then: 결과 검증
            assertThat(carDistanceResults.get("pobi")).isEqualTo(1);
            assertThat(carDistanceResults.get("woni")).isEqualTo(1);
            assertThat(carDistanceResults.get("gray")).isEqualTo(0);

        }

        @Test
        void 자동차_경주_결과_테스트() {
            // Given
            List<String> carNames = Arrays.asList("pobi", "woni", "gray");
            int numberOfMoves = 5;

            // When
            List<String> winners = Application.playGame(carNames, numberOfMoves);

            // Then
            assertThat(winners).isNotEmpty();
            assertThat(output()).contains("pobi", "woni", "gray");
        }

        @Test
        void 자동차_경주_출력_테스트() {
            //Given
            LinkedHashMap<String, Integer> carDistanceResults = new LinkedHashMap<>() {{
                put("pobi", 3);
                put("woni", 5);
            }};
            //When
            Application.printRoundScores(carDistanceResults);

            //Then
            String expectedOutput = "pobi : ---\n" + "woni : -----";
            assertThat(output()).contains(expectedOutput);
        }
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
