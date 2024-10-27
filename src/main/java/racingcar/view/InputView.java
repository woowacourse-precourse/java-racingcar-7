package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String getCarNames(){
        String input = readLine();
        if(input.isEmpty()){
            throw new IllegalArgumentException();
        }
        return input;
    }

    public String getNumberOfRounds(){
        String input = readLine();
        if(input.isEmpty()){
            throw new IllegalArgumentException();
        }
        return input;
    }

}
