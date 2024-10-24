package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {

    public String[] getUserinfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분) : ");
        String User = Console.readLine();
        String[] listUser = User.split(",");
        return listUser;
    }

    public int getRoundinfo() {
        System.out.println("시도할 횟수를 정수로 입력하세요 : ");
        String strRound = Console.readLine();
        int round = Integer.parseInt(strRound);
        return round;
    }

    public void displayResult(List listWinner) {
        System.out.print("최종 우승자 : " + String.join(",", listWinner));
    }

}
