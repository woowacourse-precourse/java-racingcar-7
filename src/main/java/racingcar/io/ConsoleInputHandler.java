package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler {

    public String getCarListInput(){
        String carListInput = Console.readLine();

        return carListInput;
    }

    public int getMoveTryCount(){
        String moveTryCount = Console.readLine();

        return Integer.valueOf(moveTryCount);
    }

}
