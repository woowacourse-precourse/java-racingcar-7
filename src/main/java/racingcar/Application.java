package racingcar;


import java.util.ArrayList;
import java.util.List;
import racingcar.car.CarImpl;
import racingcar.car.ICar;
import racingcar.display.IInputDisplay;
import racingcar.display.IOutputDisplay;
import racingcar.display.OutputDisplayImpl;
import racingcar.display.WtcInputDisplay;

public class Application {

    private static IInputDisplay inputDisplay;

    public static void main(String[] args) {
        inputDisplay = new WtcInputDisplay();

        List<ICar> carList = settingCarList();
        int round = settingRound();

        IOutputDisplay outputDisplay = new OutputDisplayImpl();
        CarRacingGame carRacingGame = new CarRacingGame(outputDisplay, carList, round);

        carRacingGame.start();
    }

    private static List<ICar> settingCarList() {
        String carNameMass = inputDisplay.getPromptInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        if (carNameMass == null || carNameMass.isBlank()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 입력하여야 합니다");
        }

        String[] carNames = carNameMass.split(",");

        List<ICar> carList = new ArrayList<>();
        for (final String carName : carNames) {
            carList.add(new CarImpl(carName));
        }

        return carList;
    }

    private static int settingRound() {
        String roundStr = inputDisplay.getPromptInput("시도할 횟수는 몇 회인가요?\n");
        if (roundStr == null || roundStr.isBlank()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해야 합니다");
        }

        return Integer.parseInt(roundStr);
    }
}
