package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.stream.Input;
import racingcar.stream.Output;

import java.util.List;

public class RaceController {

    private final Output output;
    private final Input input;

    public RaceController(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    public void doRace() {
        output.writeCarNameGuide();
        List<String> names = input.inputNames();

        output.writeRoundCountGuide();
        int roundCount = input.inputRoundCount();

        output.writeWhiteLine();

        RacingCars racingCars = RacingCars.from(names);
        runGame(roundCount, racingCars.getRacingCars());

        List<String> winners = findWinnersName(racingCars);
        output.writeWinners(winners);
    }

    private void runGame(int roundCount, List<RacingCar> racingCarList) {
        output.writeResultTitle();
        for (int i = 0; i < roundCount; i++) {
            startOneRace(racingCarList);
            output.outputRoundResult(racingCarList);
        }
    }

    private void startOneRace(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            int number = Randoms.pickNumberInRange(0, 10);
            racingCar.move(number);
        }
    }

    private List<String> findWinnersName(RacingCars racingCars) {
        int position = racingCars.findWinnerPosition();
        return racingCars.findNamesByPosition(position);
    }

}
