package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.util.UserInputUtil;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<Car> getNames() {
        List<Car> cars = new ArrayList<>();
        String names = Console.readLine();

        List<String> nameList = UserInputUtil.splitCarNames(names);

        for(String name: nameList) {
            Validator.validateCarName(name);
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getTrialNumber() {
        String trialNum = Console.readLine();
        //TODO: 숫자가 제대로 들어오는지 검증 로직
        return Integer.parseInt(trialNum);
    }

}


