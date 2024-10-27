package racingcar;

import static racingcar.input.InputData.getInput;

import racingcar.input.InputData;

public class View {
    private View(){}

    public static void integrateView(){
        String input = getInput();

        System.out.println(input);
    }
}
