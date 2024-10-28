package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public static void RaceStartComment() {
        System.out.print(Constants.RACE_START);
    }
    public static void AskCountComment() {
        System.out.print(Constants.RACE_COUNT);
    }
    public static void RoundResult(String name, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append("-");
        }
        System.out.println(name + " : " + result.toString());
    }
    public static void ResultComment() {
        System.out.println(Constants.RACE_RESULT);
    }
    public static void FinalWinnerComment() {
        System.out.print(Constants.RACE_FINAL_WINNER);
    }
    public static String getRaceCars() {
        return Console.readLine();
    }
    public static int getRaceCount() {
        return Integer.parseInt(Console.readLine());
    }
}
