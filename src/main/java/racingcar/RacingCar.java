package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import car.Car;
import io.RacingCarInputHandler;
import io.InputHandler;
import io.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private InputHandler inputHandler = new InputHandler();
    private OutputHandler outputHandler = new OutputHandler();
    private RacingCarInputHandler racingCarInputHandler = new RacingCarInputHandler();

    public void run() {
        try {
            outputHandler.showInputCarNameMessage();
            String inputCarName = inputHandler.getInputCarName();
            List<String> separatedCarNameList = racingCarInputHandler.getSeparatedCarNameList(inputCarName);

            outputHandler.showInputRacingCountMessage();
            String inputRacingCount = inputHandler.getInputRacingCount();
            int racingCount = racingCarInputHandler.getRacingCount(inputRacingCount);

            List<Car> carList = getCarList(separatedCarNameList);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Car> getCarList(List<String> separatedCarNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : separatedCarNameList) {
            carList.add(Car.of(carName));
        }
        return carList;
    }
}
