package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.constant.OutputMessage;

public class InputView {

    private static InputView inputView;
    private String inputCarNames;
    private String totalRacingRound;

    private InputView(){}

    public static InputView getInputViewInstance() {
        if(inputView == null) {
            inputView = new InputView();
            return inputView;
        }
        return inputView;
    }


    public void printInputView() {
        System.out.println(OutputMessage.CAR_NAME);
        inputCarNames = readLine();

        System.out.println(OutputMessage.TOTAL_RACING_ROUND + "\n");
        totalRacingRound = readLine();
    }


    public String getCarNames() {
        return inputCarNames;
    }

    public String getTotalRacingRound() {
        return totalRacingRound;
    }


}
