package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.convertor.CarConvertor;
import racingcar.dto.CarPositionDTO;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    public void run() {
        String[] carNames = InputView.getInstance().getCarNames();
        int moveCount = InputView.getInstance().getMoveCount();

        List<Car> carList = createCar(carNames);

        OutputView.getInstance().println("\n실행 결과");

        while (moveCount-- > 0) {
            moveCars(carList);
            printCarPositions(carList);
        }

        List<String> winnerList = findWinner(carList);

        OutputView.getInstance().printWinnerName(winnerList);
    }

    private List<Car> createCar(String[] carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    private void moveCars(List<Car> carList) {
        for (Car car : carList) {
            car.move();
        }
    }

    private void printCarPositions(List<Car> carList) {
        List<CarPositionDTO> carPositionDTOList = carList.stream().
                map(CarConvertor::toCarPosition).collect(Collectors.toList());

        OutputView.getInstance().printCarPositions(carPositionDTOList);
    }

    private List<String> findWinner(List<Car> carList) {
        int maxPosition = -1;
        List<String> nameList = new ArrayList<>();

        for (Car car : carList) {
            int curPosition = car.getPosition();
            if (curPosition > maxPosition) {
                maxPosition = curPosition;
                nameList.clear();
                nameList.add(car.getName());
            } else if (curPosition == maxPosition) {
                nameList.add(car.getName());
            }
        }

        return nameList;
    }


}
