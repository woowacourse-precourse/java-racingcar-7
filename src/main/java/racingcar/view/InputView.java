package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getPlayer(){
        return Console.readLine();
    }
    public int getMoveCount(){
        try{
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
