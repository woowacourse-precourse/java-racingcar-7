package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Input;
import racingcar.CarRace;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String[] carNames = Input.inputCarNames();
        int tryCount = Input.inputTryCount();
        List<Car> cars = CarRace.initializeCars(carNames);//자동차 초기화

        CarRace.race(cars, tryCount);

    }



}
