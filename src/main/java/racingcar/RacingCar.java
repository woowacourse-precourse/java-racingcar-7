package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import car.Car;
import io.RacingCarInputHandler;
import io.InputHandler;
import io.OutputHandler;
import io.RacingCarOutputHandler;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final RacingCarInputHandler racingCarInputHandler = new RacingCarInputHandler();
    private final RacingCarOutputHandler racingCarOutputHandler = new RacingCarOutputHandler();

    public void run() {
        try {
            outputHandler.showInputCarNameMessage();
            String inputCarName = inputHandler.getInputCarName();
            List<String> separatedCarNameList = racingCarInputHandler.getSeparatedCarNameList(inputCarName);

            outputHandler.showInputRacingCountMessage();
            String inputRacingCount = inputHandler.getInputRacingCount();
            int racingCount = racingCarInputHandler.getRacingCount(inputRacingCount);

            List<Car> carList = getCarList(separatedCarNameList);

            racingMachine(carList, racingCount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }

    public List<Car> getCarList(List<String> separatedCarNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : separatedCarNameList) {
            carList.add(Car.of(carName));
        }
        return carList;
    }

    public void racingMachine(List<Car> carList, int racingCount) {
        while (racingCount > 0) {
            racing(carList, Randoms.pickNumberInRange(0, 9));
            racingCarOutputHandler.displayRaceResultsByRound(carList);
            racingCount--;
        }
        racingCarOutputHandler.displayFinalResult(carList);
    }

    private void racing(List<Car> carList, int randomResult) {
        for (Car car : carList) {
            carMove(car, randomResult);
        }
    }

    private void carMove(Car car, int randomResult) {
        if (randomResult >= 4) {
            car.move();
        }
    }
}
