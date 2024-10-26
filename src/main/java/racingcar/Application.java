package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<String> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        String[] inputArray = input.split(",");

        for (String car : inputArray) {
            if (car.length() > 5)
                throw new IllegalArgumentException();
        }

        List<String> cars = Arrays.asList(input.split(","));

        return cars;
    }

    public static Integer getMovementCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String input = Console.readLine();

        if (!input.chars().allMatch(Character::isDigit))
            throw new IllegalArgumentException();

        Integer movemmetCount = Integer.parseInt(input);

        if (movemmetCount <= 0)
            throw new IllegalArgumentException();

        return movemmetCount;
    }
}
