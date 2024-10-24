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

    public ArrayList<String> rtnWinner(ArrayList<Car> carList) {
        int max = getMax(carList);
        ArrayList<String> winners = new ArrayList<String>();

        for (Car car : carList) {
            if (car.position == max) {
                winners.add(car.name);
            }
        }

        return winners;

    }

    public int getMax(ArrayList<Car> carList) {
        int max = 0;

        for (Car car : carList) {
            if (max < car.position) {
                max = car.position;
            }
        }

        return max;

    }


}
