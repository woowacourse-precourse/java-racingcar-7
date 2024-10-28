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
        final int numRounds = 10;

        assertSimpleTest(
            () -> {
                run(String.join(",", carNames), String.valueOf(numRounds));

                final List<Integer> mileages = Stream.generate(() -> 0)
                        .limit(carNames.size())
                        .collect(Collectors.toCollection(ArrayList::new));

                final String[] lines = output().split("\n");
                for (int i = 0, j = 0; i < lines.length - 1; i++, j = i % (carNames.size() + 1)) {
                    assertThat(i <= 5);
                    final String line = lines[i];

                    if (j == carNames.size()) {
                        assertThat(line.isBlank());
                        continue;
                    }

                    final String[] words = line.split(" : ");
                    assertEquals(carNames.get(j), words[0]);

                    if (words.length == 1) {
                        assertEquals(mileages.get(j), 0);
                        continue;
                    }
                    assertThat(words.length == 2);
                    assertEquals("-".repeat(words[1].length()), words[1]);
                    assertThat(words[1].length() - mileages.get(j) >= 0);
                    mileages.set(j, words[1].length());
                }
                assertEquals(numRounds * (carNames.size() + 1) + 1, lines.length);

                final String lastLine = lines[lines.length - 1];
                assertThat(lastLine.startsWith(Application.lastPrefix));
                
                final String[] winnerNames = lastLine.substring(Application.lastPrefix.length())
                        .split(", ");

                int maxMileage = -1;
                for (int i = 0, j = 0; i != carNames.size(); i++) {
                    final String carName = carNames.get(i);

                    if (j == winnerNames.length || ! carName.equals(winnerNames[j])) {
                        continue;
                    }
                    j++;

                    if (maxMileage == -1) {
                        maxMileage = mileages.get(i);
                    }
                    assertThat(maxMileage == mileages.get(i));
                }
                
                for (int i = 0, j = 0; i != carNames.size(); i++) {
                    final String carName = carNames.get(i);

                    if (j != winnerNames.length && carName.equals(winnerNames[j])) {
                        j++;
                        continue;
                    }
                    assertThat(maxMileage > mileages.get(i));
                }
                
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
