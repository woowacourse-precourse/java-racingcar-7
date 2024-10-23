package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final int maxLen = 5;
    public void getInput(){
        String carNames = Console.readLine();
        String tryNums = Console.readLine();

    }
    public boolean isValidateCarName(String input){
        if(input.isBlank()){
            return false;
        }
        return true;
    }
    public boolean isValidateTryNum(String input){
        if(input.isBlank()){
           return false;
        }
        return true;
    }

}
