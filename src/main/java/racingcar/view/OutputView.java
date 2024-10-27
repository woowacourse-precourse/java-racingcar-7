package racingcar.view;

import racingcar.user.SettingGameUser;
import racingcar.user.UserObject;

public class OutputView {
    public static void printTurnResult() {
        for (UserObject user : SettingGameUser.user) {
            System.out.println(user.name + ":" + user.score);
        }
        System.out.println("");
    }

    public static void printResultSentence() {
        System.out.println("");
        System.out.println("실행 결과");
    }

    public static void printWinnerSentence() {
        System.out.print("최종 우승자 : ");
    }

    public static void printWinner(String s) {
        System.out.print(s);
    }

    public static void printRest() {
        System.out.print(" ,");
    }
}
