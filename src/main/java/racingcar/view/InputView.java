package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.UserInputUtil;
import racingcar.util.Validator;

public class InputView {

    public List<Car> getNames() {
        List<Car> cars = new ArrayList<>();
        String names = Console.readLine();

        List<String> nameList = UserInputUtil.splitCarNames(names);
        Validator.validateCarNames(nameList, names);

        for (String name : nameList) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getTrialNumber() {
        String trialNum = Console.readLine();
        Validator.validateTrialNumber(trialNum);
        return Integer.parseInt(trialNum);
    }
}


