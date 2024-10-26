package racingcar.application;

import racingcar.common.InputController;
import racingcar.common.OutputController;
import racingcar.model.CarName;
import racingcar.model.RaceCount;
import racingcar.model.RacingCarList;
import racingcar.model.RawInput;

import java.util.Set;

public class RacingCarServiceImpl implements RacingCarService {

    private final Parser parser = new CarNameParser();

    @Override
    public void run() {
        //input
        RawInput rawInput = InputController.getCarNamesInput();
        RaceCount raceCount = InputController.getRaceCountInput();

        //parsing
        Set<CarName> carNameSet = parser.getParsedCarNameList(rawInput);

        //racing
        RacingCarList racingCarList = RacingCarList.of(carNameSet);
        racingCarList.gameStartPerRound(raceCount);

        //output
        OutputController.printWinnerName(racingCarList.getWinningCars());
    }
}
