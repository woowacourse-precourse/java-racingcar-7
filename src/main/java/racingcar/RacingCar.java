package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;
import racingcar.util.Separator;

public class RacingCar {

    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
    private final Separator separator = new Separator();

    public void run(){
        consoleOutputHandler.printCarNameInstruction();
        String carListInput = consoleInputHandler.getCarListInput();
        consoleOutputHandler.printTryCountInstruction();
        int tryCount = consoleInputHandler.getMoveTryCount();
        List<String> carList = separator.separateCarList(carListInput);
        List<Car> cars = new ArrayList<>();

        for(int i=0;i<carList.size();i++){
            cars.add(new Car(carList.get(i),tryCount));
        }

        for(int i=0;i<cars.size();i++){
            cars.get(i).moveForward();
        }

    }

}
