package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static String[] getUserinfo(){
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분) : ");
        String User = Console.readLine();
        String[] listUser = User.split(",");
        return listUser;
    }

    public static int getRoundinfo(){
        System.out.print("시도할 횟수를 정수로 입력하세요 : ");
        String strRound = Console.readLine();
        int round = Integer.parseInt(strRound);
        return round;
    }


}
