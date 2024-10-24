package racingcar.domain;

import racingcar.view.OutputView;

public class Car {
    private String name;
    private String position;

    public Car(String name) {
        this.name = name;
        this.position = "";
    }

    public String getName(){
        return name;
    }

    public void moveForward() {
        position = position+"-";
    }

    public void displayNowResult(){
        OutputView.nowResult(name,position);
    }
}
