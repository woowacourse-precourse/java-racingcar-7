package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private final int limitNumber = 6;
    private final String splitString = ",";
    private final int startNum = 0;

    public List<String> inputName(){
        String input = Console.readLine();
        String[] inputs = input.split(splitString);

        for(int i = startNum; i < inputs.length; i++){
            wrongInput(inputs[i]);
        }

        List<String> inputList;
        inputList = List.of(inputs);

        return inputList;
    }

    public String stringInput(){
        String input = Console.readLine();

        return input;
    }

    public int integerInput(){
        String input = Console.readLine();
        int intInput;
        try {
            intInput = Integer.parseInt(input);
        }
        catch(IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        return intInput;
    }

    private void wrongInput(String input){
        if(input.length() >= limitNumber)
            throw new IllegalArgumentException();
    }

}
