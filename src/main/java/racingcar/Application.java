package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> cars = new LinkedHashMap<>();

        String carNamesRaw = getCarNamesRaw();
        List<String> carNames = parseCarNamesRaw(carNamesRaw);

        if (!isDistinctCarNames(carNames)) {
            throw new IllegalArgumentException("[ERROR] Duplicate names not allowed");
        }

        // Enroll carNames into cars with value 0
        for (String carName : carNames) {
            cars.put(carName, 0);
        }

        // Check if cars is empty
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] You need to register at least one car.");
        }

        String iterationNumberRaw = getIterationNumberRaw();
        int iterationNumber = parseIterationNumberRaw(iterationNumberRaw);

        playRound(cars, iterationNumber);

        List<String> winnerCars = getFinalResult(cars);
        showFinalResult(winnerCars);
    }

    private static String getCarNamesRaw() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<String> parseCarNamesRaw(String carNamesRaw) {
        if (carNamesRaw == null) {
            throw new IllegalArgumentException("[ERROR] Enter valid car name(s separated by comma).");
        }

        List<String> carNames = new ArrayList<>();
        for (String carName : carNamesRaw.split("\\s*,\\s*")) {
            carName = carName.strip();
            validateCarName(carName);

            // Allow empty carName. Just ignore it.
            if (carName.isEmpty()) {
                continue;
            }

            carNames.add(carName);
        }
        return carNames;
    }

    private static void validateCarName(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException("[ERROR] Enter not-null car name.");
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException(
                    MessageFormat.format(
                            "[ERROR] Length limit(5) exceeded: \"{0}\"({1})",
                            carName, carName.length()));
        }
    }

    private static boolean isDistinctCarNames(List<String> carNames) {
        Set<String> nonDuplicateCarNames = new HashSet<>(carNames);
        return nonDuplicateCarNames.size() == carNames.size();
    }

    private static String getIterationNumberRaw() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    private static int parseIterationNumberRaw(String iterationNumberRaw) {
        if (iterationNumberRaw == null) {
            throw new IllegalArgumentException("[ERROR] Enter not-null iteration number.");
        }

        iterationNumberRaw = iterationNumberRaw.strip();
        int iterationNumber;
        try {
            iterationNumber = Integer.parseInt(iterationNumberRaw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "[ERROR] Failed to parse \"{0}\" into integer.",
                    iterationNumberRaw));
        }
        validateIterationNumber(iterationNumber);
        return iterationNumber;
    }

    private static void validateIterationNumber(int iterationNumber) {
        if (iterationNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] You must enter positive integer.");
        }
    }

    private static void playRound(Map<String, Integer> cars, int iterationNumber) {
        System.out.println("실행 결과");
        for (int i = 0; i < iterationNumber; i++) {
            for (Map.Entry<String, Integer> car : cars.entrySet()) {
                car.setValue(car.getValue() + randomDistanceToMove());
            }
            showRoundResult(cars);
        }
    }

    private static int randomDistanceToMove() {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            return 1;
        }
        return 0;
    }

    private static void showRoundResult(Map<String, Integer> cars) {
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            String distanceBar = "-".repeat(car.getValue());
            System.out.println(car.getKey() + " : " + distanceBar);
        }
        System.out.println();
    }

    private static List<String> getFinalResult(Map<String, Integer> cars) {
        List<String> winnerCars = new ArrayList<>();
        int maxDistance = Collections.max(cars.values());

        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            if (car.getValue() == maxDistance) {
                winnerCars.add(car.getKey());
            }
        }
        return winnerCars;
    }

    private static void showFinalResult(List<String> winnerCars) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerCars));
    }
}
