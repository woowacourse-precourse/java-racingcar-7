package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = getCarNames();
        int rounds = getRounds();

        List<Integer> positions = initializePositions(carNames.size());

        race(carNames, positions, rounds);
        announceWinners(carNames, positions);
    }

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> carNames = Arrays.asList(Console.readLine().split(","));
        validateCarNames(carNames);

        return carNames;
    }

    public static int getRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
            }
        }
    }

    public static List<Integer> initializePositions(int size) {
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            positions.add(0);
        }

        return positions;
    }

    public static void race(List<String> carNames, List<Integer> positions, int rounds) {
        System.out.println("실행 결과");

        for (int i = 0; i < rounds; i++) {
            playRound(carNames, positions);
            System.out.println(generateRoundResult(carNames, positions));
        }
    }

    public static void playRound(List<String> carNames, List<Integer> positions) {
        for (int i = 0; i < carNames.size(); i++) {
            if (canMove()) {
                positions.set(i, positions.get(i) + 1);
            }
        }
    }

    public static boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public static String generateRoundResult(List<String> carNames, List<Integer> positions) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < carNames.size(); i++) {
            sb.append(carNames.get(i)).append(" : ").append("-".repeat(positions.get(i)));
        }
        sb.append("\n");

        return sb.toString();
    }

    public static void announceWinners(List<String> carNames, List<Integer> positions) {
        int maxPosition = findMaxPosition(positions);
        List<String> winners = findWinners(carNames, positions, maxPosition);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static int findMaxPosition(List<Integer> positions) {
        int max = 0;

        for (int position : positions) {
            if (position > max) {
                max = position;
            }
        }

        return max;
    }

    public static List<String> findWinners(List<String> carNames, List<Integer> positions, int maxPosition) {
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            if (positions.get(i) == maxPosition) {
                winners.add(carNames.get(i));
            }
        }

        return winners;
    }
}
