package racingcar.view;

import racingcar.user.SettingGameUser;
import racingcar.user.UserInfo;

public class OutputView {
    public void ShowResult() {
        for (UserInfo user : SettingGameUser.user) {
            System.out.println(user.name + ":" + user.score);
        }
        System.out.println("");
    }

    public void PrintResultSentence() {
        System.out.println("");
        System.out.println("실행 결과");
    }
    
    public void PrintWinnerSentence() {
        System.out.print("최종 우승자 : ");
    }

    public void PrintWinner(String s) {
        System.out.print(s);
    }

    public void PrintRest() {
        System.out.print(" ,");
    }
}
