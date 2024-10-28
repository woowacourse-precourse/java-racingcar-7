package racingcar;

import camp.nextstep.edu.missionutils.Console;
import utils.ExceptionMessages;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = readString();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int moveAttemptsCount = readNaturalNumber();

        Race race = new Race(names, moveAttemptsCount);

    }


    private static String readString() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessages.UNEXPECTED_INPUT);
        }
    }

    private static int readNaturalNumber() {
        try {
            String str = Console.readLine();
            int num = Integer.parseInt(str);
            if (num < 0)
                throw new IllegalArgumentException();
            return num;
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessages.NON_NATURAL_NUMBER);
        }
    }

}
