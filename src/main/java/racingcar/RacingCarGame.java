package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
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


        if (carNamesString == null || roundString == null) {
            throw new IllegalArgumentException();
        }

        // 자동차 이름에 대한 검증 로직
        List<String> carNames = Arrays.asList(carNamesString.split(","));
        carNames.stream()
                .filter(carName -> carName.isEmpty() || carName.length() >= 5)
                .findAny()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException();
                });

        // 시도할 횟수에 대한 검증 로직
        int round = 0;

        try {
            round = Integer.parseInt(roundString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (round <= 0) {
            throw new IllegalArgumentException();
        }


        for (String s : carNames) {
            racingCars.add(new RacingCar(s, 0));
        }


        for (int i = 0; i < round; i++) {
            for (int j = 0; j < racingCars.size(); j++) {
                int pickedNumber = Randoms.pickNumberInRange(0, 9);
                if (pickedNumber >= 4) {
                    racingCars.get(j).increaseMoveCount();
                }
                ioHandler.showRacingCarsProgress(racingCars);
            }
        }
        int max = racingCars.stream()
                .mapToInt(RacingCar::getMoveCount)
                .max().orElseThrow(() -> new RuntimeException("최대값을 찾을 수 없습니다."));
        List<String> winnersName = new ArrayList<>(racingCars.stream()
                .filter(racingCar -> racingCar.isWinner(max))
                .map(racingCar -> racingCar.getName())
                .toList());
        ioHandler.showWinners(winnersName);

    }
}
