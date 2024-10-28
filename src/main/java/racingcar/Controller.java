package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Controller {
    public int randomInt() {
        return Randoms.pickNumberInRange(0,9);
    }

    public String moveThreshold(int moveNum) {
        if (moveNum < 4) {
            return "stop";
        } else {
            return "go";
        }
    }

    private List<Car> findFastestCar(List<Car> cars) {
        final int maxLength = cars.stream()
                .map(Car::getMoveStatus)
                .map(String::length)
                .max(Integer::compareTo)
                .orElse(0);

        return cars.stream()
                .filter(c -> c.getMoveStatus().length() == maxLength)
                .toList();
    }

    public void movingProcess(List<Car> cars) {
        for (Car c : cars) {
            String direction = moveThreshold(randomInt());
            c.moveCar(direction);
            System.out.println(c.getName() + " : " + c.getMoveStatus());
        }
    }

    public List<Car> startMove(List<Car> cars, int n) {
        System.out.println("실행 결과");
        for (int i=0; i<n; i++) {
            movingProcess(cars);
            System.out.println();
        }
        return findFastestCar(cars);
    }
}
