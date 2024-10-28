package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.Queue;

public class Application {

    public static void main(String[] args) {

        RacingCar.start();

//        for (int i = 0; i < tryNum; i++) {
//            moveForward(carList);
//            outPutConsole(carList);
//            System.out.println();
//        }
//
//        winner(carList);
    }

    static void moveForward(LinkedList<Car> carList) {
        for (Car car : carList) {
            int tmpMoveDistance = Randoms.pickNumberInRange(0, 9);

            if (tmpMoveDistance >= 4) {
                car.moveOneStep();
            }
        }

    }

    static void outPutConsole(LinkedList<Car> carList) {
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