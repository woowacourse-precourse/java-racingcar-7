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

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        // set initial value for each car name as 0
        for(String name : nameInput.split(",")) {
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
