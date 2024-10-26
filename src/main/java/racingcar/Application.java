package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Input;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String[] carNames = Input.inputCarNames();
        int tryCount = Input.inputTryCount();
        List<Car> cars = initializeCars(carNames);//자동차 초기화

    }

    public static List<Car> initializeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));//자동차를 자동차 객체로 만드는 과정
        }
        return cars;
    }

}
