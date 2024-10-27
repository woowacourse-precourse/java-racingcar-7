package racingcar;

import java.util.ArrayList;
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
        printResult(cars);
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

    public void printResult(List<Car> cars){
        List<String> winners = printWinners(cars);
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));

    }

    private List<String> printWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int max = maxLocation(cars);
        for (Car car : cars) {
            if (car.getLocation() == max)
                winners.add(car.getName());
        }
        return winners;
    }

    private int maxLocation(List<Car> cars) {
        int max = 0;

        for (Car car : cars) {
            if(car.getLocation() > max){
                max = car.getLocation();
            }
        }
        return max;
    }
}