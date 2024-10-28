package racingcar;

import racingcar.controller.PlayStation;
import racingcar.repository.ListRacingCarRepository;
import racingcar.service.RacingCarGame;

import java.util.List;

import static racingcar.view.UserView.*;
import static racingcar.view.UserView.printResult;

public class Application {
    public static void main(String[] args) {

        RacingCarGame racingCarGame = new RacingCarGame(ListRacingCarRepository.getInstance());

        PlayStation playStation = turnOnPlayStation(racingCarGame);
        List<String> result = playStation.run(printAndGetNames(), printAndGetRound());

        printResult(result);
    }
}
