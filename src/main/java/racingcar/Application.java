package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarName = Console.readLine();

        List<Car> cars = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(CarName, ",");

        while (tokenizer.hasMoreTokens()) {
            String carName = tokenizer.nextToken();
            cars.add(new Car(carName));
        }


    }
}
