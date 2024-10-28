package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_테스트() {
        final List<String> carNames = List.of("pobi", "woni", "jun");
        final int numRounds = 2;

        assertSimpleTest(
            () -> {
                run(String.join(",", carNames), String.valueOf(numRounds));

                final List<Integer> mileages = Stream.generate(() -> 0)
                        .limit(carNames.size())
                        .collect(Collectors.toCollection(ArrayList::new));

                final String[] lines = output().split("\n");
                for (int i = 0, j = 0; i != lines.length; i++, j = i % (carNames.size() + 1)) {
                    final String line = lines[i];

                    if (j == carNames.size()) {
                        assertThat(line.isBlank());
                        continue;
                    }

                    final String[] words = line.split(" : ");
                    assertEquals(2, words.length);

                    assertEquals(carNames.get(j), words[0]);

                    assertEquals("-".repeat(words[1].length()), words[1]);
                    assertThat(mileages.get(j) <= words[1].length());
                    mileages.set(j, words[1].length());
                }
                assertEquals(numRounds * (carNames.size() + 1) - 1, lines.length);
            }
        );
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
