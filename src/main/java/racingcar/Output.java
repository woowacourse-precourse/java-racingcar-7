package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Output {
    public Output(int num, List<Car> cars) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < num; i++) {
            raceGame(cars);
            System.out.println();
        }
    }

    private void raceGame(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            //0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
            markCar(car);
        }
    }

    private void markCar(Car car) {
        for (int k = 0; k < car.getLocation(); k++) {
            System.out.print("-");
        }
        System.out.println();
    }
}