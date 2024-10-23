package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    public static void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        List<String> splitNames = Arrays.asList(carNames.split(","));

        List<Car> cars = new ArrayList<>();
        for (String inputname : splitNames) {
            Car car = new Car(inputname);
            cars.add(car);
        }


        System.out.println("시도할 횟수는 몇 회인가요?");
        int inputTryCount = Integer.parseInt(Console.readLine());

        for (int i = 0; i < inputTryCount; i++) {
            for (Car car : cars) {
                car.randomlyMove(if60PercentChance());
            }
        }

        System.out.println("실행 결과");
        for (Car car : cars) {
            String carResult = car.getName() + " : " +"-".repeat(car.getPosition());
            System.out.println(carResult);
        }

        int maxPosition = cars.get(0).getPosition();
        for (int i = 0; i < cars.size(); i++) {
            int comparedPosition = cars.get(i).getPosition();
            if (maxPosition < comparedPosition ) {
                maxPosition = comparedPosition;
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        String winnerResult = "최종 우승자" + " : " + String.join(", ", winners);
        System.out.println(winnerResult);

    }
    private static boolean if60PercentChance() {
        int pickNumberInRange = Randoms.pickNumberInRange(0, 9);
        if (pickNumberInRange >= 4) {
            return true;
        }
        return false;
    }
}
