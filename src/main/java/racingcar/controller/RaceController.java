package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.stream.ConsoleOutput;

import java.util.List;

public class RaceController {

    private final ConsoleOutput output = new ConsoleOutput();

    public void doRace() {
        output.writeCarNameGuide();
        List<String> names = inputNames();

        output.writeRoundCountGuide();
        int roundCount = inputRoundCount();

        output.writeWhiteLine();

        RacingCars racingCars = createRacingCars(names);
        runGame(roundCount, racingCars.getRacingCars());

        List<String> winners = findWinnersName(racingCars);
        output.writeWinners(winners);
    }

    private List<String> inputNames() {
        String input = Console.readLine();
        return List.of(input.split(","));
    }

    private int inputRoundCount() {
        String count = Console.readLine();
        return Integer.parseInt(count);
    }

    private RacingCars createRacingCars(List<String> names) {
        RacingCars racingCars = new RacingCars();

        for (String name : names) {
            RacingCar racingCar = new RacingCar(name);
            racingCars.addRacingCar(racingCar);
        }

        return racingCars;
    }

    private void runGame(int roundCount, List<RacingCar> racingCarList) {
        output.writeResultTitle();
        for (int i = 0; i < roundCount; i++) {
            startOneRace(racingCarList);
            outputRoundResult(racingCarList);
        }
    }

    private void startOneRace(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            int number = Randoms.pickNumberInRange(0, 10);
            racingCar.move(number);
        }
    }

    private void outputRoundResult(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            output.writeRacingCarPosition(racingCar);
        }
        output.writeWhiteLine();
    }

    private List<String> findWinnersName(RacingCars racingCars) {
        int position = racingCars.findWinnerPosition();
        return racingCars.findNamesByPosition(position);
    }

}
