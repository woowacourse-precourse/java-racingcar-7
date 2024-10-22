package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String countInput = readLine();

        List<String> carNameList = validCarNames(carNames);
        int gameCount = validGameCount(countInput);
    }

    public static List<String> validCarNames(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
        List<String> carName = List.of(carNames.split(",", -1));
        for (String name : carName) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름을 5자 이하로 적어주세요.");
            }
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
            }
        }
        return carName;
    }

    public static int validGameCount(String gameCount) {
        try {
            int count = Integer.parseInt(gameCount);
            if (count < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
