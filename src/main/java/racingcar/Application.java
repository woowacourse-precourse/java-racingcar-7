package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Application {

    public static HashMap<String, Integer> carMoveStatus = new HashMap<>();

    public static ArrayList<String> splitCarNames(String userInput) {
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(userInput.split(",")));

        for (String carName : carNames) {
            if (carName.length() > 5)
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

        return carNames;
    }

    public static ArrayList<String> getCarNames() {
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

    public static void initializeCarStatus(ArrayList<String> carNames) {
        carMoveStatus.clear();

        for (String carName : carNames) {
            carMoveStatus.put(carName, 0);
        }
    }

    public static boolean canMoveCar() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public static void moveCars(ArrayList<String> carNames) {
        for (String carName : carNames) {
            int currentPosition = carMoveStatus.get(carName);
            if (canMoveCar()) carMoveStatus.put(carName, currentPosition + 1);
        }
    }

    public static void printCarStatus(ArrayList<String> carNames) {
        for (String carName: carNames) {
            int currentPosition = carMoveStatus.get(carName);
            System.out.println(carName + " : " + "-".repeat(currentPosition));
        }
        System.out.println();
    }

    public static ArrayList<String> getFinalWinner(ArrayList<String> carNames) {
        ArrayList<String> winner = new ArrayList<>();
        int maxPosition = 0;

        for (String carName: carNames) {
            int position = carMoveStatus.get(carName);

            if (maxPosition < position) {
                maxPosition = position;
                winner.clear();
                winner.add(carName);
            }

            else if (maxPosition == position) {
                winner.add(carName);
            }
        }

        return winner;
    }

    public static void printFinalWinner(ArrayList<String> carNames) {
        ArrayList<String> winner = getFinalWinner(carNames);
        System.out.print("최종 우승자 : " + String.join(",", winner));
    }

    public static void racingCarGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> carNames = getCarNames();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int iteration = getIteration();

        System.out.println("실행 결과");
        initializeCarStatus(carNames);
        while (iteration-- > 0) {
            moveCars(carNames);
            printCarStatus(carNames);
        }

        printFinalWinner(carNames);
    }

    public static void main(String[] args) {

        racingCarGame();

    }
}
