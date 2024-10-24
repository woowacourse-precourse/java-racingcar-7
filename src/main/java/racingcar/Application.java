package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();

        List<Car> cars = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(carNamesInput, ",");

        while (tokenizer.hasMoreTokens()) {
            String carName = tokenizer.nextToken();

            if (carName.length() >= 6) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
            }

            cars.add(new Car(carName));
        }

    }
}
