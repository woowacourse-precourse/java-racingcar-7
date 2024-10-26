package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserView {

    public String inputCarName() {
        return Console.readLine();
    }

    public int inputForwardCount() {
        return Integer.parseInt(Console.readLine());
    }

}
