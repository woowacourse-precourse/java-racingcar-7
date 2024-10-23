package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String input = Console.readLine();
        List<Car> cars = new ArrayList<>();
        String[] carNames = input.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        int T = Integer.parseInt(Console.readLine());

    }

}
