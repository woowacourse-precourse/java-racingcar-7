package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.model.CarInfo;
import racingcar.model.CarNameDelimiter;
import racingcar.model.RaceCars;


import static racingcar.view.InputView.printInputMessage;
import static racingcar.view.InputView.printLimitMessage;
import static racingcar.view.OutputView.printFinalWinner;
import static racingcar.view.OutputView.printDelimiter;

public class CarRaceController {

    public void startRace() {

        printInputMessage();
        String input = Console.readLine();

        CarNameDelimiter carNameDelimiter = new CarNameDelimiter();
        String[] carNameList = carNameDelimiter.NameDelimiter(input);

        RaceCars raceCars = new RaceCars();
        raceCars.createRaceCar(carNameList);

        printLimitMessage();
        raceCars.raceStart(Console.readLine());


    }


}
