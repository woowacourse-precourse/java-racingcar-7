package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.RacingRoundResult;
import racingcar.service.PlayArgument;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.Constants.RACING_CAR_MIN_MOVABLE_NUMBER;

class ApplicationTest extends NsTest {

    private final int MOVING_FORWARD = RACING_CAR_MIN_MOVABLE_NUMBER;
    private final int STOP = RACING_CAR_MIN_MOVABLE_NUMBER - 1;

    static Stream<PlayArgument> providePlayArguments() {
        return Stream.of(
                new PlayArgument(
                        List.of("a", "b", "c"),
                        3,
                        List.of(1, 2, 6, 3, 5, 6, 3, 3, 4)),

                new PlayArgument(
                        List.of("a", "b"),
                        2,
                        List.of(1, 4, 5, 2)),

                new PlayArgument(
                        List.of("a", "b", "c"),
                        1,
                        List.of(1, 2, 3))
        );
    }

    @ParameterizedTest(name = "playArguments: {0}")
    @MethodSource("providePlayArguments")
    @DisplayName("main() : 게임_결과_테스트")
    void 게임_결과_테스트(PlayArgument playArgument) {

        // given
        String carNamesInput = String.join(",", playArgument.getCarNames());
        String tryCountInput = String.valueOf(playArgument.getTryCount());

        Integer firstRandomNumber = playArgument.getRandomNumbers().getFirst();
        Integer[] remainRandomNumbers = playArgument.getRandomNumbers().stream().skip(1).toArray(Integer[]::new);
        String expectedWinnersNames = String.join(", ", playArgument.getExpectedWinnersNames());

        List<RacingRoundResult> racingRoundResults = playArgument.getRacingRoundResults();

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    run(carNamesInput, tryCountInput);
                    assertThat(output()).contains("최종 우승자 : " + expectedWinnersNames);
                    racingRoundResults.forEach(racingRoundResult -> {
                        List<String> expected = convertRacingRoundResultToString(racingRoundResult);
                        expected.forEach(message -> assertThat(output()).contains(message));
                    });
                },
                firstRandomNumber, remainRandomNumbers
        );
    }

    private List<String> convertRacingRoundResultToString(RacingRoundResult racingRoundResult) {
        return racingRoundResult.value().entrySet().stream()
                .map(entry -> entry.getKey() + " : " + "-".repeat(entry.getValue()))
                .toList();
    }

    /**
     * 기본 테스트로, 제출을 위해 남겨놓기로 한다.
     */
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
