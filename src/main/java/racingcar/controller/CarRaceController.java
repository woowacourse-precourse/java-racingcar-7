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
        endRace(raceCars.findWinner());

        Console.close();


    }

    public static void endRace(ArrayList<CarInfo> winnerRacers) {
        printFinalWinner();
        int winnerRacersCount = winnerRacers.size();
        for (int i = 0; i < winnerRacersCount; i++) {
            System.out.print(winnerRacers.get(i).getCarName());
            if (i < winnerRacersCount - 1) {
                printDelimiter();
            }
        }
    }


}
