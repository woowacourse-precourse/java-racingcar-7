package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void decideCarMove(Map<String, Integer> cars) {
        for (String car : cars.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                cars.replace(car, cars.get(car) + 1);
            }
        }
    }

    public static void printRacingStatus(Map<String, Integer> cars) {
        for (String car : cars.keySet()) {
            System.out.println(car + " : " + "-".repeat(cars.get(car)));
        }
        System.out.println();
    }

    public static void findWinner(Map<String, Integer> cars) {
        int maxValue = 0;
        List<String> winners = new ArrayList<>();

        for (int value : cars.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        for (String car : cars.keySet()) {
            if (cars.get(car) == maxValue) {
                winners.add(car);
            }
        }

        System.out.println(String.join(", ", winners));
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Map<String, Integer> cars = new LinkedHashMap<>();
        int tryCount;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameInput = Console.readLine();

        if (nameInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 아무런 입력을 하지 않았습니다!");
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            tryCount = Integer.parseInt(Console.readLine());
            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도 횟수에 0 또는 음수 값을 입력했습니다!");
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수에 잘못된 값을 입력했습니다!");
        }


        // set initial value for each car name as 0
        for(String name : nameInput.split(",")) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름이 5글자를 초과합니다!");
            }
            cars.put(name, 0);
        }

        System.out.println("\n실행 결과");

        for (int i = 0; i < tryCount; i++) {
            decideCarMove(cars);
            printRacingStatus(cars);
        }

        System.out.print("최종 우승자 : ");
        findWinner(cars);
    }
}
