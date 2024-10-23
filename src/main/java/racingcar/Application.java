package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class Application {

    public static void moveCars(LinkedHashMap<String, Integer> cars) {
        for (Entry<String, Integer> car : cars.entrySet()) {
            if (canMove()) {
                cars.put(car.getKey(), car.getValue() + 1);
            }
            System.out.println(car.getKey() + " : " + "-".repeat(car.getValue()));
        }
        System.out.println();
    }

    public static boolean canMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = Arrays.asList(Console.readLine().split(","));

        System.out.println("시도할 횟수는 몇 회인가요?");
        int totalMoves = Integer.parseInt(Console.readLine());

//        List<String> names = List.of("pobi","woni","jun");
//        int totalMoves = 5;

        System.out.println("실행 결과");

        LinkedHashMap<String,Integer> cars = new LinkedHashMap<>();

        for (String name: names) {
            cars.put(name, 0);
        }

        for (int indexMoves = 0; indexMoves < totalMoves; indexMoves++) {
            moveCars(cars);
        }
    }
}
