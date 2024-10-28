package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class View {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Arrays.asList(Console.readLine().split(","));

        validateDuplication(carNames);

        return carNames;
    }

    public static void validateDuplication(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public static String printRoundResult(List<Car> cars) {
        String positionStatus = "";
        for (Car car : cars) {
            positionStatus = car.getName() + " : " + "-".repeat(car.getPosition());
            System.out.println(positionStatus);
        }
        System.out.println();
        return positionStatus;
    }

    public static String printWinners(List<String> winners) {
        String winnerInformation = "최종 우승자 : " + String.join(", ", winners);
        System.out.println(winnerInformation);
        return winnerInformation;
    }
}
