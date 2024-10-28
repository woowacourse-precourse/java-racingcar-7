package racingcar.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.Car;
import racingcar.RandomMoveStrategy;

public class InputHandler {

    public List<Car> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = readLine().split(",");

        List<Car> cars = new ArrayList<>();
        createCar(names, cars);
        return cars;
    }

    public int getTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return validateTrialCount(readLine());
    }

    private void createCar(String[] names, List<Car> cars) {
        for (String name : names) {
            name = name.trim();
            validateCarName(name);
            cars.add(new Car(name, new RandomMoveStrategy()));
        }
    }

    private void validateCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    private static int validateTrialCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

}
