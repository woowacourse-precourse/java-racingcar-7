package racingcar;

import java.util.List;
import racingcar.io.ConsoleInputHandler;
import racingcar.util.Separator;

public class RacingCar {

    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    private final Separator separator = new Separator();

    public void run(){
        String carListInput = consoleInputHandler.getCarListInput();
        int tryCount = consoleInputHandler.getMoveTryCount();
        List<String> carList = separator.separateCarList(carListInput);
    }

}
