package racingcar;

import java.util.List;

public class RacingGame {
    public void exec(){
        Race race = settingRace();
        playGame(race);
    }

    private static Race settingRace() {
        OutputHandler.displayCarsNameInputMessage();
        List<Car> cars = InputHandler.requestCarNames().stream().
                map(carName -> new Car(carName)).toList();
        return new Race(cars);
    }

    private static void playGame(Race race) {
        OutputHandler.displayTotalRoundsInputMessage();
        int totalRounds = InputHandler.requestTotalRounds();

        OutputHandler.displayExecResultMessage();
        for(int i = 0; i < totalRounds; i++){
            race.start();
            OutputHandler.displayRoundResult(race.getRoundResult());
        }
        OutputHandler.displayWinners(race.getFinalWinners());
    }

}
