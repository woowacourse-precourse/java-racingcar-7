package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;

    public GameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        String carNames = getCarNames();
        List<Car> cars = createCarsFromNames(carNames);
        int round = getRacingRound();

        while(round > 0) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            playRound(cars, randomNum);
            --round;
        }
    }

    private void playRound(List<Car> cars, int randomNum) {
        cars.forEach(car -> car.move(randomNum));
        outputView.printMovingCarsWithPositions(cars);
    }

    private String getCarNames() {
        outputView.printRacingCarNameFormat();
        return inputView.readCarNames();
    }

    private int getRacingRound() {
        outputView.printRacingRoundRequest();
        return inputView.readRacingRound();
    }

    private List<Car> createCarsFromNames(String names) {
        String[] splitNames = names.split(",");
        return Arrays.stream(splitNames).map(Car::from).toList();
    }
}
