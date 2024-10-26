package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private final int limitNumber = 6;
    private final String splitString = ",";
    private final int startNum = 0;

    public List<String> inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] inputs = input.split(splitString);

        for(int i = startNum; i < inputs.length; i++){
            wrongInput(inputs[i]);
        }

        return List.of(inputs);
    }

    public String stringInput(){
        String input = Console.readLine();

        return input;
    }

    public int integerInput(){
        System.out.println("시도할 횟수는 몇 회인가요?");
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
