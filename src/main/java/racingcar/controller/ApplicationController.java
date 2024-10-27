package racingcar.controller;

import java.util.List;
import racingcar.view.ViewInput;

public class ApplicationController {

    private final ViewInput viewInput;


    public ApplicationController(ViewInput viewInput) {
        this.viewInput = viewInput;
    }


    public void run(){
        List<String> carNames = viewInput.receiveCarNames();

        for(String carName : carNames) {
            System.out.println(carName.trim());
        }

    }

}
