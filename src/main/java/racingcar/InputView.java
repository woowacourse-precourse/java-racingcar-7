package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return parseCarNames(input);
    }

    public static int getTryCountInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return parseTryCount(input);
    }

    static String[] parseCarNames(String input){
        String[] carNames = input.split(",");
        if (carNames.length < 2) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분해야 합니다.");
        }

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNames;
    }

    static int parseTryCount(String input){
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        int num = Integer.parseInt(input);
        if (num < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return num;
    }
}
