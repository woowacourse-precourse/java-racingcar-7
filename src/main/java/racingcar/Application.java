package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {

    public static ArrayList<String> splitCarNames(String userInput) {
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(userInput.split(",")));

        for (String carName : carNames) {
            if (carName.length() > 5)
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

        return carNames;
    }

    public static ArrayList<String> getRacingCars() {
        String userInput = Console.readLine();
        return splitCarNames(userInput);
    }

    public static int getIteration() {
        String iterationInput = Console.readLine();
        try {
            return Integer.parseInt(iterationInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시행 횟수는 숫자만 입력할 수 있습니다.");
        }
    }

    public static void racingCarGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> racingCars = getRacingCars();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int iteration = getIteration();
    }

    public static void main(String[] args) {

        racingCarGame();

    }
}
