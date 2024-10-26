package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.RacingResult;
import racingcar.dto.RacingRoundResult;
import racingcar.mock.model.dependency.validator.MockedRacingCarValidator;
import racingcar.mock.service.dependency.random_maker.MockedRandomNumberMaker;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.service.dependency.random_maker.RandomNumberMaker;
import racingcar.util.RacingCarsUtil;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("RacingService 테스트")
public class RacingServiceTest {

    private final RandomNumberMaker randomNumberMaker = () -> 5;
    private final MockedRacingCarValidator racingCarValidator = new MockedRacingCarValidator();
    private final RacingService racingService = new RacingService(randomNumberMaker, racingCarValidator);

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

    @BeforeEach
    void setUp() {
        racingCarValidator.clear();
        racingCarValidator.setIsValidateNameWillPass(true);
    }

    @Test
    @DisplayName("getRacingCars() : 자동차_이름_리스트를_받아_자동차_일급_컬렉션_객체를_반환한다.")
    void 자동차_이름_리스트를_받아_자동차_일급_컬렉션_객체를_반환한다() {

        // given
        List<String> carNames = List.of("a", "b", "c");

        // when
        RacingCars actual = racingService.getRacingCars(carNames);

        // then
        List<RacingCar> expected = carNames.stream()
                .map(name -> new RacingCar(name, racingCarValidator))
                .toList();

        assertEquals(new RacingCars(expected), actual);
    }

    @ParameterizedTest(name = "playArguments: {0}")
    @MethodSource("providePlayArguments")
    @DisplayName("play() : 레이싱_게임을_수행한다.")
    void 레이싱_게임을_수행한다(PlayArgument playArgument) {

        // given
        MockedRandomNumberMaker mockedRandomNumberMaker =
                new MockedRandomNumberMaker(playArgument.getRandomNumbers());

        RacingService racingService = new RacingService(mockedRandomNumberMaker, racingCarValidator);
        RacingCars racingCars = racingService.getRacingCars(playArgument.getCarNames());

        // when
        RacingResult actual = racingService.play(racingCars, playArgument.getTryCount());
        List<RacingRoundResult> racingRoundResults = actual.roundResults();
        RacingCars winners = actual.winners();
        List<RacingCar> winnerCars = RacingCarsUtil.parseValues(winners);

        // then
        verifyRoundResults(racingRoundResults, playArgument.getTryCount(), playArgument.getRacingRoundResults());
        verifyWinners(winnerCars, playArgument.getExpectedWinnersNames());
    }

    // 각 라운드 별 position 이 올바르게 저장되었는지 확인.
    private void verifyRoundResults(
            List<RacingRoundResult> roundResults,
            int tryCount,
            List<RacingRoundResult> racingRoundResults) {

        assertThat(racingRoundResults.size()).isEqualTo(tryCount);

        assertThat(roundResults.size()).isEqualTo(racingRoundResults.size());

        assertThat(roundResults).containsExactlyElementsOf(racingRoundResults);
    }

    // 최종 승자가 올바르게 선정되었는지 확인.
    private void verifyWinners(List<RacingCar> winnerCars, List<String> expectedWinnersNames) {
        assertThat(winnerCars)
                .extracting(RacingCar::getName)
                .containsExactlyElementsOf(expectedWinnersNames);
    }
}
