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
            cars.add(car);
        }
    }
}