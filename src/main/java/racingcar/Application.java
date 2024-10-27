package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class Application {
    private static List<String> registerCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        List<String> carNames = new ArrayList<>();
        for (String name : names) {
            name = name.trim(); // 공백 제거
            validateCarName(name);
            carNames.add(name);
        }
        return carNames;
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력하세요.");
        }
    }

    private static int getMoveCount() {
        System.out.println("시도할 횟수");

        try {
           int moveCount = Integer.parseInt(Console.readLine());
           validateMoveCount(moveCount);
           return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
        }
    }

    private static void validateMoveCount(int moveCount) {
        if (moveCount < 1) {
            throw new IllegalArgumentException("이동 횟수는 1 이상의 숫자를 입력하세요.");
        }
    }

    private static List<Integer> startRace(List<String> carNames, int moveCount) {
        System.out.println("실행 결과");

        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            positions.add(0); // 각 자동차 초기 위치 설정
        }

        for (int i = 0; i < moveCount; i++) {
            updatePositions(positions);
            printRaceStatus(carNames, positions);
        }
        return positions;
    }

    private static void updatePositions(List<Integer> positions) {
        for (int j = 0; j < positions.size(); j++) {
            if (shouldMove()) {
                positions.set(j, positions.get(j) + 1);
            }
        }
    }

    private static boolean shouldMove() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber >= 4;
    }

    private static void printRaceStatus(List<String> carNames, List<Integer> positions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : ");
            System.out.println("-".repeat(positions.get(i)));
        }
        System.out.println();
    }

    private static void printWinners(List<String> carNames, List<Integer> positions) {
        int maxPosition = positions.stream().max(Integer::compareTo).orElse(0);
        List<String> winners = findWinners(carNames, positions, maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static List<String> findWinners(List<String> carNames, List<Integer> positions, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            if (positions.get(i) == maxPosition) {
                winners.add(carNames.get(i));
            }
        }
        return winners;
    }

    public static void main(String[] args) {
        List<String> carNames = registerCars();
        int moveCount = getMoveCount();
        List<Integer> finalPositions = startRace(carNames, moveCount);
        printWinners(carNames, finalPositions);
    }
}
