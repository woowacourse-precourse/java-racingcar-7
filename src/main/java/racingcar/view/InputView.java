package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getPlayer(){
        return Console.readLine();
    }
    public int getRoundNumber(){
        return Integer.parseInt(Console.readLine());
    }
}
