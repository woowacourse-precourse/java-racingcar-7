package racingcar;

import java.util.LinkedList;
import java.util.Queue;

public class OutConsole {
    static void outPutProgress(LinkedList<Car> carList) {
        System.out.println("실행 결과");
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            int distance = car.getMoveDistance();

            for (int i = 0; i < distance; i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }

    static void winner(LinkedList<Car> carList) {
        int max = Integer.MIN_VALUE;

        Queue<Car> maxCarList = new LinkedList<>();
        for (Car car : carList) {
            if (car.getMoveDistance() == max) {
                maxCarList.add(car);
            } else if (car.getMoveDistance() > max) {
                max = car.getMoveDistance();

                maxCarList.clear();
                maxCarList.add(car);
            }
        }

        System.out.print("최종 우승자 : ");
        while (!maxCarList.isEmpty()) {
            Car pollCar = maxCarList.poll();
            System.out.print(pollCar.getName());

            if (!maxCarList.isEmpty()) {
                System.out.print(", ");
            }
        }
    }
}
