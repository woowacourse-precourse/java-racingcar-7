package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class MainController {
    public static void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        List<String> splitNames = Arrays.asList(carNames.split(","));

        List<Car> cars = new ArrayList<>();
        for (String inputname : splitNames) {
            Car car = new Car(inputname);
            cars.add(car);
        }

    }


}
