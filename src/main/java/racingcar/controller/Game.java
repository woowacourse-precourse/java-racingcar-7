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
    private InputView inputView;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String[] carNames = inputView.getCarNames();
        int moveCount = inputView.getMoveCount();

        List<Car> carList = createCar(carNames);

        OutputView.getInstance().println("실행 결과");

        while (moveCount-- > 0) {
            moveCars(carList);
            printCarPositions(carList);
        }


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

}
