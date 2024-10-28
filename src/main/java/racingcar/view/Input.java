package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public List<Car> getCars() {
        List<String> carNames = getCarNames();
        isDuplicated(carNames);
        atLeastTwoCar(carNames);
        return convertToCar(carNames);
    }

    public List<Car> convertToCar(List<String> carNames) {
        List<Car> racingCars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            car.validateNotExceedMaxLength();
            racingCars.add(car);
        }
        return racingCars;
    }

    public void atLeastTwoCar(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 적어도 2개의 자동차를 입력해주세요");
        }
    }

    public void isDuplicated(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);

        if (uniqueNames.size() < carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }
}
