package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] cars = input.split(",");
        return checkCarNames(cars);
    }

    private static List<String> checkCarNames(String[] cars) {
        List<String> carList = new ArrayList<>();
        for(String car : cars) {
            if (car.isEmpty()) {
                continue;
            }
            if (car.length() > 5) {
                throw new IllegalArgumentException("Invalid String length");
            }
            carList.add(car);
        }
        return carList;
    }

    public static int getMoveCount() {
        int cnt = 0;
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            cnt = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format");
        }
        return cnt;
    }

}
