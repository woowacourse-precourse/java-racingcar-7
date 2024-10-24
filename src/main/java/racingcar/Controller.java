package racingcar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    Model model;
    InputView input = new InputView();
    OutputView output = new OutputView();

    ArrayList<Car> carList = new ArrayList<Car>();
    ArrayList<Integer> positionList;
    int count;

    public Controller() {
        setVar();
    }

    public void startGame() {
        startRace();
        output.printWinner(model.rtnWinner(carList));
    }

    public void startRace() {
        for (int i = 0; i < count ; i++) {
            model.checkMoveOrStop(carList);
            output.printGame(carList);
        }
    }

    public void setVar() {
        ArrayList<String> nameList = new ArrayList<String>(Arrays.asList(input.getName().split(",")));

        isInputValid(nameList);

        for (String s : nameList) {
            carList.add(new Car(s, 0));
        }
        count = input.getCount();
        model = new Model(input, output, carList, count);

    }

    public void isInputValid(ArrayList<String> nameList) {
        ArrayList<String> temp = new ArrayList<String>();
        for (String s : nameList) {
            if (temp.contains(s)) {
                throw new IllegalArgumentException("이미 존재하는 이름입니다.");
            }
            else if (s.length() > 5) {
                throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
            }
            else {
                temp.add(s);
            }
        }

    }

}
