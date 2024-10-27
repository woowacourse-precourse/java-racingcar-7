package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constant.Constant;
import java.util.ArrayList;
import racingcar.util.Validation;

public class InputView {
    private String players;
    private int trial;
    private final Validation validation;

    public InputView() {
        this.validation = new Validation();
    }

    public void inputGameInfo() {
        System.out.println(Constant.INPUT_PLAYERS_PROMPT);
        players = Console.readLine();

        validation.isPlayerInputBlank(players);
        validation.isPlayerInputNull(players);
        validation.isPlayerInputDelimiterWrong(players);

        System.out.println(Constant.INPUT_TRIAL_PROMPT);
        String inputTrial = Console.readLine();

        validation.isTrialInputValid(inputTrial);
        validation.isTrialInputDouble(inputTrial);
        validation.isTrialInputNegative(inputTrial);

        trial = Integer.parseInt(inputTrial);
    }

    private ArrayList<String> parseCarNames(String inputStr) {
        if (inputStr == null) {
            return null;
        }

        ArrayList<String> nameArray = new ArrayList<String>(List.of(inputStr.split(Constant.DELIMITER)));
        int count = 0;

        for (String name : nameArray) {
            validation.isNameLengthValid(name);
            count++;
        }
        validation.isPlayerCountValid(count);

        return nameArray;
    }

    public ArrayList<String> getPlayersList() {
        return parseCarNames(players);
    }

    public int getTrial() {
        return trial;
    }
}
