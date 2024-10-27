package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int gameRoundInput = Integer.parseInt(Console.readLine());

        List<String> carNames = List.of(carNamesInput.split(","));
        HashMap<String, Integer> cars = new HashMap<String, Integer>();

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }

            cars.put(carName, 0);
        }

        System.out.println("\n실행 결과");

        race(gameRoundInput, cars);

        List<String> winners = new ArrayList<>();
        for (String car : cars.keySet()) {
            int maxDistance = Collections.max(cars.values());
            int distance = cars.get(car);

            if (distance >= maxDistance) {
                winners.add(car);
            }
        }

        System.out.println("최종 우승자 : " + java.lang.String.join(", ", winners));
    }

    public static final String MOVE_SYMBOL = "-";

    public static int race(final int round, HashMap<String, Integer> cars) {
        if (round == 0) {
            return 0;
        }

        boolean movedCarFound = false;

        for (String car : cars.keySet()) {
            int distance = cars.get(car);
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                distance++;
                cars.put(car, distance);
                movedCarFound = true;
            }

            if (movedCarFound == false) {
                return race(round, cars);
            }

            System.out.println(java.lang.String.join(" : ", car, MOVE_SYMBOL.repeat(cars.get(car))));
        }

        System.out.println();

        return race(round - 1, cars);
    }
}
