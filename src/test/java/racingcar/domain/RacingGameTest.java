package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class RacingGameTest {

    private static final Map<String, Integer> testValues = Map.of(
            "A", 2,
            "B", 9,
            "C", 6,
            "D", 9
    );
    private static final int ROUNDS = 5;

    private ByteArrayOutputStream outputStream;
    private RacingCars racingCars;

    private void setAllCarsDistance() {
        for (Car car : racingCars.getCars()) {
            for (int i = 0; i < testValues.get(car.getName()); i++) {
                car.forward(true);
            }
        }
    }

    @BeforeEach
    void setUp() {
        racingCars = RacingCars.from(testValues.keySet());
    }

    /*
     * 1. 참가자 내에 우승자가 존재하는가?
     * 2. 가장 먼 거리를 간 참가자가 우승하였는가?
     */
    @Test
    void 우승자_판정_테스트() {
        //given
        RacingGame racingGame = RacingGame.of(racingCars, ROUNDS);
        setAllCarsDistance();
        String[] expectWinnersName = {"B", "D"};

        //when
        racingGame.judge();

        //then
        Integer maxDistance = testValues.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(-1);

        assertThat(testValues.get(expectWinnersName[0])).isEqualTo(maxDistance);
        assertThat(testValues.keySet()).contains(expectWinnersName);
    }
}