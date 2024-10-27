package racingcar.controller;
import racingcar.seperator.Seperator;
import racingcar.view.InputView;

public class Controller {
    public void start(){
        String s= InputView.getInput();
        Seperator seperator=new Seperator(s);

    }




}


