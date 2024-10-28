package racingcar.display;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.ErrorMessage;
import racingcar.car.CarImpl;
import racingcar.car.ICar;

public class WtcGameSettingDisplay implements IGameSettingDisplay {

    @Override
    public List<ICar> settingCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNameMass = Console.readLine();

        if (carNameMass == null || carNameMass.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_INPUT_EMPTY.getMessage());
        }

        String[] carNames = carNameMass.split(",");

        List<ICar> carList = new ArrayList<>();
        for (final String carName : carNames) {
            carList.add(new CarImpl(carName));
        }

        return carList;
    }

    @Override
    public int settingRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundStr = Console.readLine();

        if (roundStr == null || roundStr.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_INPUT_EMPTY.getMessage());
        }
        if (!roundStr.matches("-?\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_INPUT_TYPE_NOT_MATCH.getMessage());
        }

        return Integer.parseInt(roundStr);
    }
}
