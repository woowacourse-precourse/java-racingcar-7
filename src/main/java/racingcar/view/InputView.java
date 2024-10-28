package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.constant.OutputMessage;

public class InputView {

    private static InputView inputView;
    private String inputCarNames;
    private Integer totalRacingRound;

    private InputView(){}

    public static InputView getInputViewInstance() {
        if(inputView == null) {
            inputView = new InputView();
            return inputView;
        }
        return inputView;
    }


    public void printInputView() {
        System.out.println(OutputMessage.CAR_NAME.getMessage());
        inputCarNames = readLine();

        System.out.println(OutputMessage.TOTAL_RACING_ROUND.getMessage());
        totalRacingRound = Integer.parseInt(readLine());
        System.out.println();
    }


    public String getCarNames() {
        return inputCarNames;
    }

    public Integer getTotalRacingRound() {
        return totalRacingRound;
    }


}
