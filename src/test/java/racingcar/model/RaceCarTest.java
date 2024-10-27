package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RaceCarTest {

    @ParameterizedTest
    @MethodSource("provideRaceCarNames")
    void 자동차_이름_생성_테스트(String inputName, String expectedName) {
        RaceCar raceCar = RaceCar.fromName(inputName);

        assertThat(raceCar.getName()).isEqualTo(expectedName);
    }

    @Test
    void 자동차_이동_테스트() {
        RaceCar raceCar = RaceCar.fromName("car");
        raceCar.move();

        assertThat(raceCar.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, true", "1, false"})
    void 우승자_판별_테스트(int winPosition, boolean result) {
        RaceCar raceCar = RaceCar.fromName("car");

        assertThat(raceCar.isWinner(winPosition)).isEqualTo(result);
    }

    static Stream<Arguments> provideRaceCarNames() {
        return Stream.of(
                Arguments.of("po bi", "po bi"),
                Arguments.of(" pobi", "pobi"),
                Arguments.of("pobi ", "pobi")
        );
    }
}
