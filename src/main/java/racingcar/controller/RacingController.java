package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarDto;
import racingcar.service.ParseCarNames;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ParseCarNames parseCarNames;

    public RacingController(InputView inputView, OutputView outputView, ParseCarNames parseCarNames) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parseCarNames = parseCarNames;
    }

    public void run() {
        Cars cars = RacingStart();

        moveCar(cars);

        List<String> winner = getWinner(cars);

        printWinner(winner);

        inputView.closeConsole();
    }

    public void printWinner(List<String> winner){
        outputView.printWinner(winner);
    }

    public List<String> getWinner(Cars cars) {
        List<CarDto> winner = cars.findWinner();
        return winner.stream().
                map(CarDto::getName)
                .toList();
    }

    public void moveCar(Cars cars) {
        outputView.moveNumber();
        int tryMove = inputView.getCarMoveNumber();
        if(tryMove<=0){
            throw new IllegalArgumentException();
        }
        for(int i=0; i<tryMove; i++){
            List<CarDto> carDto = cars.moveCars();
            outputView.printCarsInfo(carDto);
        }
    }

    public Cars RacingStart() {
        outputView.startRacing();
        String msg = inputView.getCarsName();
        List<String> carName = parseCarNames.parse(msg);
        List<Car> cars = carName.stream()
                .map(Car::from)
                .toList();
        return Cars.from(cars);
    }

}
