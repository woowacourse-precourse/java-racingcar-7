package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler {

    public String getCarListInput(){
        String carListInput = Console.readLine();

        return carListInput;
    }

    public int getMoveTryCount(){
        try {
            String moveTryCount = Console.readLine();
            return Integer.valueOf(moveTryCount);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

    }

}
