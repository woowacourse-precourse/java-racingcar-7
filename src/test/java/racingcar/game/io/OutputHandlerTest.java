package racingcar.game.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.game.model.Car;
import racingcar.game.model.RaceSnapshot;
import racingcar.game.model.Winners;

class OutputHandlerTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private OutputHandler outputHandler;

    @BeforeEach
    void setUpOutput() {
        System.setOut(new PrintStream(output));
        outputHandler = new OutputHandler();
    }

    @AfterEach
    void restOutput() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("중간 이동 횟수를 출력한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "pobi,woni,jun/2,2,0/pobi : --woni : --jun :",
            "pobi,woni,jun/3,3,1/pobi : ---woni : ---jun : -",
            "pobi,woni,jun/4,4,2/pobi : ----woni : ----jun : --"
    }, delimiter = '/')
    public void testShowCurrentRaceSnapshot(String carNames, String counts, String expected) {
        // given
        List<Car> cars = createCars(carNames);
        List<Integer> moveCounts = createMoveCounts(counts);
        List<RaceSnapshot> snapshots = IntStream.range(0, cars.size())
                .mapToObj(index -> new RaceSnapshot(cars.get(index).getName(), moveCounts.get(index)))
                .toList();

        // when
        outputHandler.showCurrentRaceSnapshot(snapshots);

        // then
        assertThat(output.toString().replace("\n", "").strip()).isEqualTo(expected);

    }

    @DisplayName("자동차 경주 우승자를 출력한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "pobi/최종 우승자 : pobi",
            "pobi,woni/최종 우승자 : pobi, woni",
            "pobi,woni,jun/최종 우승자 : pobi, woni, jun"
    }, delimiter = '/')
    void testShowWinners(String winnerNames, String expected) {
        // given
        System.setOut(new PrintStream(output));
        Winners winners = new Winners(createCars(winnerNames));

        // when
        outputHandler.showWinners(winners);

        // then
        assertThat(output.toString().trim()).isEqualTo(expected);
    }

    private List<Car> createCars(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
    }

    private List<Integer> createMoveCounts(String counts) {
        return Arrays.stream(counts.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}