package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constant.Constant;
import java.util.ArrayList;

public class InputView {
    private String players;
    private int trial;

    public void inputGameInfo() {
        System.out.println(Constant.INPUT_PLAYERS_PROMPT);
        players = Console.readLine();
        System.out.println(Constant.INPUT_TRIAL_PROMPT);
        trial = Integer.parseInt(Console.readLine());
    }

    private ArrayList<String> parseCarNames(String inputStr){
        if(inputStr == null) {
            return null;
        }
        return new ArrayList<String>(List.of(inputStr.split(Constant.DELIMITER)));
    }

    public ArrayList<String> getPlayersList(){
        return parseCarNames(players);
    }

    public int getTrial(){
        return trial;
    }
}
