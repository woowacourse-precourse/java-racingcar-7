package racingcar;

import java.util.ArrayList;

public class Model {

    InputView input;
    OutputView output;
    ArrayList<Car> carList;


    public Model(InputView input, OutputView output, ArrayList<Car> carList) {
        this.input = input;
        this.output = output;
        this.carList = carList;
    }



}
