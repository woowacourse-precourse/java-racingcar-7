package console;


import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_COUNT = "시도할 횟수는 몇 회인가요?";
    public static final String OUTPUT_WINNERS = "최종 우승자 : ";
    public static final String NAME_LENGTH_ROLE = "이름은 5자 이하만 가능합니다.";

    public static String readCarName() {
        System.out.println(INPUT_CAR_NAME);
        return Console.readLine();
    }

    public static int readRacingCount() {
        System.out.println(INPUT_COUNT);
        String racingCount = Console.readLine();
        return checkCountException(racingCount);

    }

    public static void closeConsole() {
        Console.close();
    }

    public static void generateExceptionIfNameAbove5(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ROLE);
        }
    }

    public static int checkCountException(String racingCount) {
        try {
            boolean onlyNumber = racingCount.matches("[0-9]+");
            if (!onlyNumber) {
                throw new IllegalArgumentException("1이상의 정수만 출력 가능합니다.");
            }
            int value = Integer.parseInt(racingCount);
            if (value == 0) {
                throw new IllegalArgumentException("1이상의 정수만 출력 가능합니다.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 너무 큽니다.");
        }
    }


}
