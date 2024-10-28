package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Game {
    private final Input input;
    private final Output output;
    private final List<Car> carList;

    public Game() {
        input = new Input();
        output = new Output();
        carList = new ArrayList<>();
    }

    public void receiveInput() {
        output.carInputComment();
        input.carNamesWithComa();
        List<String> carNameList = StringProcessing.extractCarNames(input.getNamesWithComa());
        ExceptionCheck.lengthExceedFive(carNameList);
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        output.tryCountComment();
        input.tryCount();
        ExceptionCheck.intRangeAndNotNegative(input.getTryCount());
    }

    public void run() {
        output.executionResultComment();
        for (int tryCount = 0; tryCount < Integer.parseInt(input.getTryCount()); tryCount++) {
            for (Car car : carList) {
                car.moveForwardOrNot();
            }
            output.resultByOrder(executionResultByOrder());
        }
    }

    private String executionResultByOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carList) {
            stringBuilder.append(car.getName()).append(" : ");
            stringBuilder.append("-".repeat(car.getLocation())).append("\n");
        }
        return stringBuilder.toString();
    }

    public void finalWinner() {
        Collections.sort(carList);
        StringBuilder stringBuilder = new StringBuilder(carList.getFirst().getName());
        int winnerLocation = carList.getFirst().getLocation();
        for (int index = 1; index < carList.size(); index++) {
            Car car = carList.get(index);
            if (winnerLocation != car.getLocation()) {
                break;
            }
            stringBuilder.append(", ").append(car.getName());
        }
        output.finalWinner(stringBuilder.toString());
    }
}
