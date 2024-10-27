package racingcar.view.OutputView;

import racingcar.model.Car.Car;
import racingcar.model.Util.WinnerCalculate;
import racingcar.model.Util.StringGenerator;

import java.util.List;

public class Output {
    private final WinnerCalculate winnerCalculate;
    private final StringGenerator stringGenerator;

    public Output(WinnerCalculate winnerCalculate, StringGenerator stringGenerator) {
        this.winnerCalculate = winnerCalculate;
        this.stringGenerator = stringGenerator;
    }

    public void printWinner(List<Car> cars) {
        List<Car> winnerCars = winnerCalculate.winnerCars(cars);
        System.out.println(stringGenerator.generateWinnerResult(winnerCars));
    }

    public void printRaceResult(List<Car> cars) {
        System.out.println(stringGenerator.generateRaceResult(cars));
    }
}
