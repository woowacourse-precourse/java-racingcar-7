package racingcar;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputHandler inputHandler = new InputHandler();
        List<String> carNames = inputHandler.getCarNames();
        Integer tryCount = inputHandler.getTryCount();

        RacingSimulation racingSimulation = new RacingSimulation();
        RaceAnalyzer raceAnalyzer = new RaceAnalyzer();
        List<CarRecord> carRecords = racingSimulation.simulateRace(carNames, tryCount);
        List<String> winners = raceAnalyzer.findWinners(carRecords, tryCount);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.getResult(carRecords, winners, tryCount);
    }
}
