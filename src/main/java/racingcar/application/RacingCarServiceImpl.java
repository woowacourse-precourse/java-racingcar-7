package racingcar.application;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.InputController;
import racingcar.common.OutputController;
import racingcar.model.CarName;
import racingcar.model.RaceCount;
import racingcar.model.RacingCarList;
import racingcar.model.RawInput;

import java.util.List;

public class RacingCarServiceImpl implements RacingCarService {

    private final Parser parser = new CarNameParser();

    @Override
    public void run() {
        //input
        RawInput rawInput = InputController.getCarNamesInput();
        RaceCount raceCount = InputController.getRaceCountInput();
        Console.close();

        //parsing
        List<CarName> carNameSet = parser.getParsedCarNameList(rawInput);

        //racing
        RacingCarList racingCarList = RacingCarList.of(carNameSet);
        racingCarList.gameStartPerRound(raceCount);

        //output
        OutputController.printWinnerName(racingCarList.getWinningCars());
    }
}
