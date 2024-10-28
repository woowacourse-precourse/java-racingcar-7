package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.domain.NumberGenerator;
import racingcar.domain.PlayersCars;
import racingcar.domain.RoundNumber;
import racingcar.domain.WoowaRandomNumberGenerator;
import racingcar.io.Printer;
import racingcar.io.UserInputHandler;
import racingcar.io.WoowaUserInput;

public class Controller {

    public void run() {
        UserInputHandler userInputHandler = new WoowaUserInput();
        NumberGenerator numberGenerator = new WoowaRandomNumberGenerator();
        Printer printer = new Printer();

        PlayersCars playersCars = new PlayersCars(userInputHandler.makeUserInputNames());
        RoundNumber roundNumber = new RoundNumber(userInputHandler.makeUserInputRoundNumber());

        IntStream.range(0, roundNumber.getRoundNumber()).forEach(index -> {
            playersCars.moveSequence(numberGenerator);
            printer.printRoundResult(playersCars.getPlayersCars());
        });

        printer.printFinalResult(playersCars.findMaximumScoreCars());
    }
}
