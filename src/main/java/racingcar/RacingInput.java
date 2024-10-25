package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * The class {@code RacingInput} manages game input from {@code System.in}.
 *
 * <p>It receives two pieces of information: car names separated by commas,
 * and the total number of rounds for the gameplay.</p>
 */
public class RacingInput {
    private static final int MIN_ROUNDS = 1;

    /**
     * Receives car names separated by commas from {@code System.in} and returns them as a {@code List}. Leading and
     * trailing whitespace in each car name is automatically removed by {@link String#strip()}.
     *
     * @return a list of car names
     * @throws IllegalArgumentException if a car name is empty or exceeds 5 words
     */
    public List<String> receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawCarNames = Console.readLine();
        return extractCarNames(rawCarNames);
    }

    /**
     * Receives the total number of rounds for the game from {@code System.in} and returns it.
     *
     * @return the total number of rounds
     * @throws IllegalArgumentException if the total number of rounds is not a positive integer
     */
    public int receiveTotalRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String rawTotalRounds = Console.readLine();
        return extractTotalRounds(rawTotalRounds);
    }

    private List<String> extractCarNames(String rawCarNames) {
        emptyCheck(rawCarNames, "잘못된 입력: 자동차 이름은 5글자 이하이며 비어있을 수 없습니다.");

        List<String> carNames = new ArrayList<>();
        String[] names = rawCarNames.split(",");
        for (String name : names) {
            String strippedName = name.strip();
            if (strippedName.length() > 5 || strippedName.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력: 자동차 이름은 5글자 이하이며 비어있을 수 없습니다.");
            }
            carNames.add(strippedName);
        }
        return carNames;
    }

    private int extractTotalRounds(String rawTotalRounds) {
        emptyCheck(rawTotalRounds, "잘못된 입력: 총 라운드는 1~200사이의 정수여야 합니다.");

        int totalRounds;
        try {
            totalRounds = Integer.parseInt(rawTotalRounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력: 숫자만 입력할 수 있습니다. 숫자가 지나치게 클 수 없습니다.");
        }
        if (totalRounds < MIN_ROUNDS) {
            throw new IllegalArgumentException("잘못된 입력: 양의 정수만 입력할 수 있습니다.");
        }
        return totalRounds;
    }

    private void emptyCheck(String str, String errorMessage) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
