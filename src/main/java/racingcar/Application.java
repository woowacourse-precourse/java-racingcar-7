package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        //outputView.printRacingCarNameFormat();
        //String names = inputView.readCarNames();
        //outputView.printRacingRoundRequest();
        //int round = inputView.readRacingRound();

        //String[] splitNames = names.split(",");
        //List<Car> cars = Arrays.stream(splitNames).map(Car::from).toList();

        //while(round-- > 0) {
        //    cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
        //    outputView.printMovingCarsWithPositions(cars);
        //}

        //우승자 결정
//        List<Integer> positions = cars.stream().map(Car::getPosition).toList();
//        int maxPosition = Collections.max(positions);
//        List<String> winners = cars.stream()
//            .filter(car -> car.getPosition() == maxPosition)
//            .map(Car::getName)
//            .toList();
//
//        outputView.printRacingWinners(winners);
    }
}
