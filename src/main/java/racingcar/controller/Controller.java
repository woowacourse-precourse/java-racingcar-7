package racingcar.controller;
import racingcar.seperator.Seperator;
import racingcar.valid.Valid;
import racingcar.view.InputView;

public class Controller {
    public void start(){
        String s= InputView.getInput();
        Seperator seperator=new Seperator(s);
        Valid valid=new Valid(s);
        for (String name : seperator.getNames()) {

        }

    }




}


