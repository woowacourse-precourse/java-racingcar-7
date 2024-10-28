package racingcar;

import static racingcar.ExceptionHandler.validateNaturalNum;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public final class Utils {
    private static List<String> parseString(String input, String delimiter) {
        List<String> result = Arrays.asList(input.split(delimiter));
        result.replaceAll(String::strip);
        return result;
    }

    public static List<String> enterCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return parseString(Console.readLine(), ",");
    }

    public static int enterRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String text = Console.readLine();
        return validateNaturalNum(text);
    }

    public static void printResult(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            String name = racingCar.getName();
            int count = racingCar.getCount();

            System.out.println(name + " : " + "-".repeat(count));
        }
    }

    public static void printWinner(List<String> winnerList) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }
}
