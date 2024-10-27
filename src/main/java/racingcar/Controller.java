package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    Model model;
    InputView input = new InputView();
    OutputView output = new OutputView();

    ArrayList<Car> carList = new ArrayList<Car>();

    int count;

    public Controller() {
        setVar();
    }

    public void startGame() {
        output.printFirst();
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
        if (count <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }
        model = new Model(input, output, carList, count);

    }

    public void isInputValid(ArrayList<String> nameList) {
        ArrayList<String> temp = new ArrayList<String>();
        for (String s : nameList) {
            s = s.trim();
            if (temp.contains(s)) {
                throw new IllegalArgumentException("이미 존재하는 이름입니다.");
            }
            else if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
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
