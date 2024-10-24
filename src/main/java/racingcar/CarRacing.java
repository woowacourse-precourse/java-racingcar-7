package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class CarRacing {
    public static List<RacingCar> start(RacingCarTrace racingCarTrace) {
        var tryCount = Prompt.racingTryCount();
        System.out.println("실행 결과");
        IntStream.range(0, tryCount).forEach(i -> {
                    IntStream.range(0, racingCarTrace.size()).forEach(index -> {
                        var racingCar = racingCarTrace.getRacingCar(index);
                        var randomNumber = Randoms.pickNumberInRange(0, 9);
                        if (randomNumber >= 4) {
                            racingCarTrace.forward(racingCar);
                        }
                    });
                    Prompt.tracePrint(racingCarTrace);
                }
        );
        return racingCarTrace.getBiggestDistanceRacingCar();
    }
}