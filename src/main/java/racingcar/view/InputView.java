package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public List<String> inputName(){
        String input = Console.readLine();
        String[] inputs = input.split(",");

        for(int i = 0; i < inputs.length; i++){
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
        if(input.length() >= 6)
            throw new IllegalArgumentException();
    }

}
