package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
// 각 자동차 입력받기

public class Application {
    private static List<String> registerCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        String[] names = input.split(",");

        List<String> carNames = new ArrayList<>();
        for (String name : names) {
            name = name.trim(); // 공백 제거
            if (name.length() <= 5) {
                carNames.add(name);
            } else {
                System.out.println("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNames;
    }

    private static int getMoveCount() {
        System.out.println("시도할 횟수");
        int moveCount = 0;

        try {
            moveCount = Integer.parseInt(Console.readLine());
            if (moveCount < 1) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return moveCount;
    }

    private static void startRace(List<String> carNames, int moveCount) {
        System.out.println("실행 결과");

        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            positions.add(0); // 각 자동차 초기 위치 설정
        }

        for (int i = 0; i < moveCount; i++) {
            updatePositions(positions);
            printRaceStatus(carNames, positions);
        }
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

    public static void main(String[] args) {
        // 자동차 입력받기
        List<String> carNames = registerCars();
        // 횟수 입력받기
        int moveCount = getMoveCount();
        startRace(carNames, moveCount);
    }
}
