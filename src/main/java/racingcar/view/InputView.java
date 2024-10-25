package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.service.RaceService;

public class InputView {

    public static List<Car> getCarNames() {
        String[] value = Console.readLine().split(",");
        return CarService.convertToCarList(value);
    }

    public static int getRound() {
        String value = Console.readLine();
        return RaceService.converToIntRound(value);
    }


}
