package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        Map<String, Integer> cars = registerCars(carNamesInput);


    }

    public static Map<String, Integer> registerCars(String carNamesInput) {
        //이름 각각에 대한 제한 사항은 아직 반영하지 않음
        Map<String, Integer> cars = new HashMap<>();
        for (String name : carNamesInput.split(",")) {
            if (cars.containsKey(name)) {
                throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요");
            }
            if (name.length() > 5 || name.length() < 1) {
                throw new IllegalArgumentException("이름은 1자리 이상 5자리 이하로 입력해주세요.");
            }
            cars.put(name, 0);
        }
        if (cars.size() < 2) {
            throw new IllegalArgumentException("2개 이상의 차 이름을 입력해주세요.");
        }

        return cars;
    }
}
