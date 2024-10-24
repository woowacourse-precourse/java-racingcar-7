package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarsName(){
        try{
            return Console.readLine();
        }
        catch(Exception e){
            throw new IllegalArgumentException("getCarsName에서 에러가 발생했습니다.");
        }
    }

    public int getCarMoveNumber(){
        try{
            return Integer.parseInt(Console.readLine());
        }
        catch(Exception e){
            throw new IllegalArgumentException("getCarMoveNumber에서 에러가 발생했습니다.");
        }
    }

    public void closeConsole(){
        Console.close();
    }
}
