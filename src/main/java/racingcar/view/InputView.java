package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.util.message.ErrorMessages.ERROR_INVALID_MOVE_COUNT;

public class InputView {
    public String getPlayer(){
        return Console.readLine();
    }
    public int getMoveCount(){
        try{
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_MOVE_COUNT);
        }
    }
}
