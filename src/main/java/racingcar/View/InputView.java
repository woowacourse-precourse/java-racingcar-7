package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.Model.RacingCar;

public class InputView {

    public List<RacingCar> inputCarNames() {
        List<RacingCar> carList = new ArrayList<>();

        Arrays.stream(Console.readLine().split(","))
            .map(name -> new RacingCar(0, name))
            .distinct()
            .forEach(carList::add);

        return carList;
    }

    public int inputNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
