package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.strategy.MaxValueIntGeneratorStrategy;

public class RacingResultTest {

    private RacingResult racingResult;
    private Cars cars;

    @BeforeEach
    void setUp() {
        racingResult = new RacingResult();
        final List<String> carNames = Arrays.asList("car1", "car2", "car3");
        cars = new Cars(carNames, new MaxValueIntGeneratorStrategy());
    }

    @Test
    public void Given_한명의_우승자_When_호출시_Expect_우승자_이름을_반환한다() {

        cars.getCars().get(0).tryMove();

        List<String> expectedWinners = Arrays.asList("car1");
        List<String> actualWinners = racingResult.getWinnerNames(cars);
        assertThat(actualWinners).hasSize(expectedWinners.size());
        assertThat(actualWinners).isEqualTo(expectedWinners);
    }

    @Test
    public void Given_여러_명의_우승자_When_호출시_Expect_Car_우승자_명단을_반환한다() {

        cars.getCars().get(0).tryMove();
        cars.getCars().get(1).tryMove();

        List<String> expectedWinners = Arrays.asList("car1", "car2");
        List<String> actualWinners = racingResult.getWinnerNames(cars);
        assertThat(actualWinners).hasSize(expectedWinners.size());
        assertThat(actualWinners).isEqualTo(expectedWinners);
    }
}