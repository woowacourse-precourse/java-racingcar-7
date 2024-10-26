package racingcar.controller;


import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public void start() {
        outputView.askCarName();
        String userInput = inputView.getCarNames();

        ArrayList<String> carNames = extractCarName(userInput);
        inputView.validateCarNames(carNames);
        ArrayList<Car> carList = generateCarList(carNames);

        outputView.askTurn();
        int numberOfTurn = inputView.getNumberOfTurn();

        outputView.printResult();
        processCarGame(numberOfTurn, carList);

        outputView.printWinner(isWinner(carList));

    }

    public int isMaxPosition(ArrayList<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public ArrayList<String> isEqual(ArrayList<Car> carList, int maxPosition) {
        ArrayList<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (maxPosition == car.getPosition()) {
                winnerList.add(car.getCarName());
            }
        }
        return winnerList;
    }

    public ArrayList<String> isWinner(ArrayList<Car> carList) {
        int maxPosition = isMaxPosition(carList);
        ArrayList<String> winnerList = isEqual(carList, maxPosition);
        return winnerList;
    }

    public ArrayList<String> extractCarName(String input) {
        String[] items = input.split(",", -1);
        return new ArrayList<>(List.of(items));
    }

    public static ArrayList<Car> generateCarList(ArrayList<String> carNames) {
        ArrayList<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public static void processCarGame(int numberOfTurn, ArrayList<Car> carList) {
        for (int i = 0; i < numberOfTurn; i++) {
            processTurnOfNumber(carList);
            outputView.printCarPostion(carList);
        }

    }

    public static void processTurnOfNumber(ArrayList<Car> carList) {
        for (Car car : carList) {
            car.movePosition();
        }
    }


}
