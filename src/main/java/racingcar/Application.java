package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = getCarNames();
        int numberOfTries = getNumberOfTries();
        raceCars(carNames, numberOfTries);
    }

    // 01. 자동차 이름 입력 기능
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        // 사용자 입력 받기
        String input = Console.readLine();

        // 쉼표로 구분된 자동차 이름 리스트 생성
        List<String> carNames = Arrays.asList(input.split(","));

        // 입력된 자동차 이름이 유효한지 검증
        validateCarNames(carNames);
        return carNames;
    }

    // 01-1. 자동차 이름 예외 검증
    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다: " + name);
            }
        }
    }

    // 02. 이동 횟수 입력 기능
    public static int getNumberOfTries() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String input = Console.readLine();
        return validateTries(input);
    }

    // 02-1. 입력된 시도 횟수 검증
    public static int validateTries(String input) {
        int numberOfTries;

        try {
            numberOfTries = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
        }

        if (numberOfTries <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 큰 숫자여야 합니다.");
        }

        return numberOfTries;
    }

    // 03. 자동차 이동
    public static void raceCars(List<String> carNames, int numberOfTries) {
        String[] carPositions = new String[carNames.size()];
        Arrays.fill(carPositions, "");

        for (int i = 0; i < numberOfTries; i++) {
            updateAndPrintCarPositions(carNames, carPositions);
        }
        // 05. 경주가 끝난 후 우승자 출력
        printWinners(carNames, carPositions);
    }

    // 04. 자동차 위치 업데이트
    private static void updateAndPrintCarPositions(List<String> carNames, String[] carPositions) {
        for (int j = 0; j < carNames.size(); j++) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                carPositions[j] += "-";
            }
            System.out.println(carNames.get(j) + " : " + carPositions[j]);
        }
        System.out.println();
    }

    // 05. 우승자 결정
    private static void printWinners(List<String> carNames, String[] carPositions) {
        // 1. 가장 많이 전진한 거리 찾기
        int maxPosition = findMaxPosition(carPositions);

        // 2. 가장 많이 전진한 자동차 찾기
        List<String> winners = findWinners(carNames, carPositions, maxPosition);

        // 3. 우승자 출력
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    // 05-1. 가장 많이 전진한 거리 찾기
    private static int findMaxPosition(String[] carPositions) {
        int maxPosition = 0;
        for (String position : carPositions) {
            if (position.length() > maxPosition) {
                maxPosition = position.length();
            }
        }
        return maxPosition;
    }

    // 05-2. 가장 많이 전진한 자동차 찾기
    private static List<String> findWinners(List<String> carNames, String[] carPositions, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            if (carPositions[i].length() == maxPosition) {
                winners.add(carNames.get(i));
            }
        }
        return winners;
    }

}
