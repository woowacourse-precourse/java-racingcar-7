package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCar {

    Map<String, Integer> cars = new LinkedHashMap<>();

    public void run() {
        inputCarName();
        int tryTimes = inputTryTimes();
        tryMoving(tryTimes);
    }

    private void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        for (String carName : carNames) {
            cars.put(carName, 0);
        }
    }

    private int inputTryTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryTimes = Integer.parseInt(Console.readLine());
        return tryTimes;
    }

    private void tryMoving(int tryTimes) {
        System.out.println("\n" + "실행 결과");
        for (int i = 0; i < tryTimes; i++) {
            for (String carName : cars.keySet()){

                if (Randoms.pickNumberInRange(0, 9) >= 4)
                    cars.put(carName, cars.get(carName) + 1);

                System.out.println(carName + " : " + hyphen(cars.get(carName)));
            }
            System.out.println();
        }
    }

    private String hyphen(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
