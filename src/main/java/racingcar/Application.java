package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttemptCount = Console.readLine();

        System.out.println();
        System.out.println("실행 결과");

        long attemptCount = Long.parseLong(inputAttemptCount);

        String[] carList = inputCars.split(",");

        List<Car> cars = new ArrayList<>();

        for (String s : carList) {
            cars.add(new Car(s, 0));
        }

        for (int i = 0; i < attemptCount; i++) {
            moveOrStop(cars);
        }

        printWinners(cars);

    }

    public static void moveOrStop(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                car.moveCount++;
            }
            System.out.println(car.name + " : " + "-".repeat(car.moveCount));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        cars.sort((o1, o2) -> o2.moveCount - o1.moveCount);

        System.out.print("최종 우승자 : ");

        System.out.print(cars.getFirst().name);

        for (int i = 1; i < cars.size(); i++) {
            if (cars.getFirst().moveCount != cars.get(i).moveCount) {
                break;
            }
            System.out.print(", " + cars.get(i).name);
        }
    }

}

