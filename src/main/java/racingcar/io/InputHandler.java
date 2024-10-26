package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.io.request.CarsRequest;
import racingcar.io.request.TryCountRequest;

public class InputHandler {

    public CarsRequest getCarNamesFromUser() {
        String userInput = Console.readLine();
        return new CarsRequest(userInput);
    }

    public TryCountRequest getTryCountFromUser() {
        String userInput = Console.readLine();
        return new TryCountRequest(userInput);
    }

}
