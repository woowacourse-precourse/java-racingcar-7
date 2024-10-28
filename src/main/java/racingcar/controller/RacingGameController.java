package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    Validation validation = new Validation();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public List<Car> cars = new ArrayList<>();
    int rounds = 0;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = splitCar(inputView.getCarsName());

        System.out.println("시도할 횟수는 몇 회 인가요?");
        rounds = inputView.getRoundNumber();

        System.out.println("\n실행 결과");
        for (int round = 0; round < rounds; round++) {
            moveCar();
            outputView.roundResult(cars);
        }
    }

    public List<Car> splitCar(String carList) {
        return Arrays.stream(carList.split(","))
                .map(String::trim)
                .map(name -> {
                    validation.carNameLength(name);
                    return new Car(name);
                })
                .collect(Collectors.toList());
    }

    public void moveCar() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }
}
