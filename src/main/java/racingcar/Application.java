package racingcar;


import java.util.List;
import racingcar.car.ICar;
import racingcar.display.IGameSettingDisplay;
import racingcar.display.IOutputDisplay;
import racingcar.display.OutputDisplayImpl;
import racingcar.display.WtcGameSettingDisplay;

public class Application {

    public static void main(String[] args) {
        IGameSettingDisplay gameSettingDisplay = new WtcGameSettingDisplay();

        List<ICar> carList = gameSettingDisplay.settingCarList();
        int round = gameSettingDisplay.settingRound();

        IOutputDisplay outputDisplay = new OutputDisplayImpl();
        CarRacingGame carRacingGame = new CarRacingGame(outputDisplay, carList, round);

        carRacingGame.start();
    }
}
