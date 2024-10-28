package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Separator separator = new Separator();
        Racing racing = new Racing();

        String[] names = getCarNames(separator);
        int count = getAttemptCount();

        racing.run(names, count);
    }

    private static String[] getCarNames(Separator separator) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();

        if (inputNames == null || inputNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }

        return separator.separate(inputNames);
    }

    private static int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            String stringCount = Console.readLine();
            return Integer.parseInt(stringCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }
}

