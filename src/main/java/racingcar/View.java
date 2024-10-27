package racingcar;

import racingcar.input.DataInput;
import racingcar.input.MatchInput;

public class View {
    private View(){}

    public static void integrateView(){
        String playerinput = DataInput.getInput();
        System.out.println(playerinput);
        Integer matchinput = MatchInput.getMatches();
        System.out.println(matchinput);
    }
}
