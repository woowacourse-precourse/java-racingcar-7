package racingcar.racing;

import racingcar.io.Input;
import racingcar.io.Output;
import java.util.List;

import static racingcar.io.Input.inputCarName;
import static racingcar.io.Input.inputNumberOfRound;

public class RacingManager {
    private CarFactory carFactory;
    private RoundRace roundRace;
    private Winner winner;
    private Output output;

    public RacingManager(CarFactory carFactory, RoundRace roundRace, Winner winner, Output output) {
        this.carFactory = carFactory;
        this.roundRace = roundRace;
        this.winner = winner;
        this.output = output;
    }

    public void Racing() {
        String carNames = inputCarName();
        int numberOfRounds = Integer.parseInt(inputNumberOfRound());
        Car[] cars = carFactory.createRacingCars(carNames);

        System.out.println("실행결과");

        for (int i = 0; i < numberOfRounds; i++) {
            roundRace.playRound(cars);
            output.printRaceResult(cars);  // 라운드 결과 출력
        }

        List<String> winners = winner.findWinners(cars);
        output.printWinner(winners);  // 우승자 출력
    }

}
