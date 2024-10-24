package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        // 입력된 자동차 이름 저장 후 검증
        String[] names = inputCarName.split(",");
        for (String name : names) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름의 길이는 1부터 5까지만 가능합니다.");
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Console.readLine();

        System.out.println(inputCarName + " " + inputCount);

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }
}
