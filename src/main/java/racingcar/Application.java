package racingcar;

import camp.nextstep.edu.missionutils.Console;

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
    }
}
