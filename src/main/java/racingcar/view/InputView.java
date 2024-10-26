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

    public int getNumberOfRounds(){
        String input = readLine();
        if(input.isEmpty()){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

}
