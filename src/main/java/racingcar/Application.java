package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptsNum = Integer.parseInt(Console.readLine());

        List<Car> cars = new ArrayList<>();
        for (String carName : userInput.split(",")) {
            cars.add(Car.from(carName));
        }

        System.out.println("실행 결과");
        for (int cnt = 0; cnt < attemptsNum; cnt++) {
            forwardWithRandomCondition(cars);
            outputStatus(cars);
        }
    }

    private static void forwardWithRandomCondition(List<Car> cars) {
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                car.forward();
            }
        }
    }

    private static void outputStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.name() + " : ");
            for (int j = 0; j < car.status(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
