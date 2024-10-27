package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.management.Query.or;

public class Application {
    public static int moveCar(int random, int movements) {
        if (random >= 4) {
            movements += 1;
        }
        return movements;
    }

    public static void calculateMovement(List<String> cars, Map<String, Integer> carMoves) {
        for (String car: cars) {
            int random = Randoms.pickNumberInRange(0, 9);
            int movements = carMoves.get(car);
            movements = moveCar(random, movements);

            System.out.println(car + " : " + "-".repeat(movements));
            carMoves.put(car, movements);
        }
    }
    public static void main(String[] args) {
        Map<String, Integer> carMoves = new HashMap<>();
        int count;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = new ArrayList<>(List.of(Console.readLine().split(",")));

        for (String car: cars) {
            if (car.length() > 5 || car.trim().isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            carMoves.put(car, 0);
            // System.out.println(car);
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            count = Integer.parseInt(Console.readLine());
            //System.out.println(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 숫자만 입력해주세요.");
        }

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            calculateMovement(cars, carMoves);
            System.out.println();
        }

        // TODO: 최종 우승자 출력
        System.out.println("최종 우승자 : ");
    }
}
