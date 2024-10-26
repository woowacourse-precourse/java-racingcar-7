package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptCount = Console.readLine();

        if (!isValidName(carNamesInput) || !isValidAttemptCount(attemptCount)) {
            throw new IllegalArgumentException();
        }

        List<Car> carList = createCarList(carNamesInput);

        Racing racing = new Racing();
        racing.start(carList, attemptCount);

        List<Car> winnerList = racing.determineWinner(carList);

        printWinnerName(winnerList);

        Console.close();
    }

    public static boolean isValidName(String carNamesInput) {
        if (carNamesInput.isEmpty()) {
            return false;
        }

        if (!carNamesInput.contains(",")) {
            return false;
        }

        String[] carNameList = carNamesInput.split(",", -1);
        if (carNameList.length == 1) {
            return false;
        }

        if (hasDuplicates(carNameList)) {
            return false;
        }

        for (String carName : carNameList) {

            if (carName.isBlank() || carName.trim().length() > 5) {
                return false;
            }

        }

        return true;
    }

    public static boolean hasDuplicates(String[] nameList) {
        Set<String> verifiedList = new HashSet<>();

        for (String name : nameList) {

            if (!verifiedList.add(name)) {
                return true;
            }

        }
        return false;
    }

    public static boolean isValidAttemptCount(String input) {
        if (input.isBlank()) {
            return false;
        }

        if (input.contains(".")) {
            return false;
        }

        try {
            return Integer.parseInt(input.trim()) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<Car> createCarList(String carNamesInput) {
        List<Car> carList = new ArrayList<>();
        String[] carNameList = carNamesInput.split(",", -1);

        for (String carName : carNameList) {
            carList.add(new Car(carName.trim()));
        }

        return carList;
    }

    public static void printWinnerName(List<Car> winnerList) {
        System.out.println("\n실행 결과");
        System.out.print("최종 우승자 : ");

        String result = String.join(", ",
                winnerList.stream()
                        .map(Car::getName)
                        .toList());

        System.out.print(result);
    }
}