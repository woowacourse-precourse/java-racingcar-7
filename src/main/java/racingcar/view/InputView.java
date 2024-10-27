package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorCode;

public class InputView {

    public String racingCarNamesWithDelimeter(){

        String carNamesWithDelimeter = Console.readLine();

        return carNamesWithDelimeter;
    }

    public int countOfTry(){

        String countOfTry = Console.readLine();

        try{
            return Integer.valueOf(countOfTry);
        }catch(Exception e){
            throw new IllegalArgumentException(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage());
        }
    }


}
