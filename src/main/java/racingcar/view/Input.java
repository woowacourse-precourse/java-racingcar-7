package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Input {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        List<String> carList = List.of(carNames);
        return carList;
    }

    public int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public List<Car> convertToCar(List<String> carNames) {
        List<Car> racingCars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            car.validateNotExceedMaxLength();
            racingCars.add(new Car(name));
        }
        return racingCars;
    }
}
