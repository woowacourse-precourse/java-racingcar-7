package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.util.UserInputUtil;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<Car> getNames() {
        List<Car> cars = new ArrayList<>();
        String names = Console.readLine();

        List<String> nameList = UserInputUtil.splitNames(names);
        //TODO: 이름 검증 로직 추가

        for(String name: nameList) {
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


