package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine();

        String[] carNames = carNamesInput.split(",");
        int tryCount = Integer.parseInt(tryCountInput);

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

    }
}
