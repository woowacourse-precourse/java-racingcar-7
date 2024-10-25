package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] tokens = input.split(",");
        List<String> cars = new ArrayList<>();
        for (String token : tokens) {
            String car = token.trim();
            if (car.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있지 않아야 합니다.");
            }
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(car);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String turns = Console.readLine();
    }
}