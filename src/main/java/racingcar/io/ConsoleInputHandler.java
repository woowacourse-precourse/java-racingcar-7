package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler {

    public String getCarListInput(){
        String carListInput = Console.readLine();
        if(carListInput == null | carListInput.isBlank())
            throw new IllegalArgumentException("잘못된 입력입니다.");

        return carListInput;
    }

    public int getMoveTryCount(){
        try {
            String moveTryCount = Console.readLine();

            if(moveTryCount == null | moveTryCount.isBlank())
                throw new IllegalArgumentException("잘못된 입력입니다");

            return Integer.valueOf(moveTryCount);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

    }

}
