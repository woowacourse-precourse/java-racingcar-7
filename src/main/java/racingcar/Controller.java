package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    Model model;
    InputView input = new InputView();
    OutputView output = new OutputView();

    ArrayList<String> nameList;
    int count;

    public Controller() {

    }

    public void start() {
        setVar();
    }

    public void setVar() {
        nameList = new ArrayList<String>(Arrays.asList(input.getName().split(",")));
        count = input.getCount();
        model = new Model(input, output, nameList);
    }


}
