package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.convertor.CarConvertor;
import racingcar.dto.CarPositionDTO;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    public void run() {
        String[] carNames = InputView.getInstance().getCarNames();
        int moveCount = InputView.getInstance().getMoveCount();

        Cars cars = new Cars(carNames);

        OutputView.getInstance().println("\n실행 결과");

        while (moveCount-- > 0) {
            cars.moveCars();
            printCarPositions(cars.getCars());
        }

        List<String> winnerList = cars.findWinner();

        OutputView.getInstance().printWinnerName(winnerList);
    }

    private void printCarPositions(final List<Car> carList) {
        List<CarPositionDTO> carPositionDTOList = carList.stream().
                map(CarConvertor::toCarPosition).collect(Collectors.toList());

        OutputView.getInstance().printCarPositions(carPositionDTOList);
    }

}
