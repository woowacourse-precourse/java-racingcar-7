package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        int repeat = Integer.parseInt(Console.readLine());
        Racing racing = new Racing();
        Arrays.stream(input.split(","))
                .map(Car::new)
                .forEach(racing::addCar);
        System.out.println(racing.race(repeat));
    }
}
