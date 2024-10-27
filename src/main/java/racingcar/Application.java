package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    public static void decideCarMove(Map<String, Integer> cars) {
        for (String car : cars.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                cars.replace(car, cars.get(car) + 1);
            }
        }
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

        for (int i = 0; i < tryCount; i++) {
            decideCarMove(cars);
        }

    }
}
