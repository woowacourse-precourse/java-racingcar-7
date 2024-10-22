package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView INPUT_VIEW = new InputView();
    private InputView() {
    }

    public static InputView getInstance() {
        return INPUT_VIEW;
    }

    public String inputString(String message){
        if(!message.isBlank())
            System.out.println(message);
        String input = Console.readLine();
        return input;
    }
    public void close(){
        Console.close();
    }
}
