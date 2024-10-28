package racingcar;

import static racingcar.input.DataParsing.parseData;

import racingcar.input.DataInput;
import racingcar.input.DataParsing;
import racingcar.input.MatchInput;

public class View {
    private View(){}

    public static void integrateView(){
        String playerinput = DataInput.getInput();
        System.out.println(playerinput);
        String[] players = parseData(playerinput);
        Integer matchinput = MatchInput.getMatches();
        System.out.println(matchinput);
    }
}
