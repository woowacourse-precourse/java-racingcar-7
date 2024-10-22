package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.io.RacingCarIOHandler;

public class RacingCarGame {

    private final RacingCarIOHandler ioHandler = new RacingCarIOHandler();
    private List<RacingCar> racingCars = new ArrayList<>();
    public void run(){
        // 입력에 대한 검증 필요
        String carNamesString = ioHandler.askCarNames();
        String roundString = ioHandler.askRound();

        String[] split = carNamesString.split(",");

        for (String s : split) {
            racingCars.add(new RacingCar(s, 0));
        }

        int round = Integer.parseInt(roundString);

        for (int i = 0; i < round; i++) {
            for (int j = 0; j < racingCars.size(); j++) {
                int pickedNumber = Randoms.pickNumberInRange(0, 9);
                if (pickedNumber >= 4) {
                    racingCars.get(j).increaseMoveCount();
                }
                ioHandler.showRacingCarsProgress(racingCars);
            }
        }
    }
}
