package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleInputHandler implements InputHandler {

    private final RacingCarInputConverter racingCarInputConverter = new RacingCarInputConverter();

    @Override
    public List<String> getCarNamesFromUser() {
        String userInput = Console.readLine();
        return racingCarInputConverter.getUserCarName(userInput);
    }

    @Override
    public int getCarNumberFromUser() {
        String userInput = Console.readLine();
        return racingCarInputConverter.getUserCarNumber(userInput);
    }

}
