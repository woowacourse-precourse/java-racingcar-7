package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.util.InputOutputHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    private Game game;
    private MockInputOutputHandler ioHandler;

    @BeforeEach
    void setUp() {
        ioHandler = new MockInputOutputHandler();
        game = new Game(ioHandler);
    }

    @ParameterizedTest
    @CsvSource({
            "car1,car2,car3,5",
            "carA,carB,carC,3",
            "carX,carY,carZ,7"
    })
    void play(String car1, String car2, String car3, int round) {
        List<String> carNames = List.of(car1, car2, car3);
        ioHandler.setCarNames(carNames);
        ioHandler.setRound(round);

        game.play();

        assertEquals(round, ioHandler.getPrintCarsStatusCallCount());
        assertEquals(1, ioHandler.getPrintWinnersCallCount());
    }

    private static class MockInputOutputHandler extends InputOutputHandler {
        private List<String> carNames;
        private int round;
        private int printCarsStatusCallCount = 0;
        private int printWinnersCallCount = 0;

        void setCarNames(List<String> carNames) {
            this.carNames = carNames;
        }

        void setRound(int round) {
            this.round = round;
        }

        int getPrintCarsStatusCallCount() {
            return printCarsStatusCallCount;
        }

        int getPrintWinnersCallCount() {
            return printWinnersCallCount;
        }

        @Override
        public List<String> getCarNames() {
            return carNames;
        }

        @Override
        public int getRound() {
            return round;
        }

        @Override
        public void printCarsStatus(List<Car> cars) {
            printCarsStatusCallCount++;
        }

        @Override
        public void printWinners(List<Car> winners) {
            printWinnersCallCount++;
        }
    }
}
