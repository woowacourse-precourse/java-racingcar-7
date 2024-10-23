package racingcar;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        String carNames = getCarNames();
        List<String> carNameList = getCarNameList(carNames);
        RacingCars racingCars = createRacingCars(carNameList);
        long tryCount = getTryCount();
    }

    private static RacingCars createRacingCars(List<String> carNameList) {
        return new RacingCars(carNameList.stream().map(RacingCar::new).toList());
    }

    private static List<String> getCarNameList(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    private static String getCarNames() {
        outputView.printInputCarNames();
        return inputView.getCarNames();
    }

    private static long getTryCount() {
        outputView.printInputTryCount();
        return inputView.getTryCount();
    }
}
