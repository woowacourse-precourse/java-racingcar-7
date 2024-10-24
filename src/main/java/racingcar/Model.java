package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Model {

    InputView input;
    OutputView output;
    ArrayList<Car> carList;
    int count;


    public Model(InputView input, OutputView output, ArrayList<Car> carList, int count) {
        this.input = input;
        this.output = output;
        this.carList = carList;
        this.count = count;
    }

    public void checkMoveOrStop(ArrayList<Car> carList) {
        for (Car car : carList) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.position++;
            }
        }
    }



}
