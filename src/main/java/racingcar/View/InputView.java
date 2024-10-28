package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.View.Model.RacingCar;

public class InputView {

    public List<RacingCar> inputCarNames() {
        List<RacingCar> carList = new ArrayList<RacingCar>();
        carList.add(new RacingCar(0, Console.readLine()));
        return carList;
    }

    public int inputNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
