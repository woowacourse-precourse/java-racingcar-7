package console;


import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static final String INPUT_CAR_NAME =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_COUNT =
            "시도할 횟수는 몇 회인가요?";

    public static String readCarName() {
        System.out.println(INPUT_CAR_NAME);
        return Console.readLine();
    }

    public static String readRacingCount() {
        System.out.println(INPUT_COUNT);
        return Console.readLine();
    }

    public static void closeConsole() {
        Console.close();
    }


}
