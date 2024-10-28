package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final InputView instance = new InputView();

    private InputView() {}

    public static InputView getInstance() {
        return instance;
    }

    public String getCarNames(){
        String input = readLine();
        if(input.isEmpty()){
            throw new IllegalArgumentException();
        }
        return input;
    }

    public String getTryCounts(){
        String input = readLine();
        if(input.isEmpty()){
            throw new IllegalArgumentException();
        }
        return input;
    }
}
