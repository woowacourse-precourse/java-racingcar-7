package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class CarRacing {
    public static List<RacingCar> start(RacingCarTrace racingCarTrace, int tryCount) {
        System.out.println("실행 결과");
        carRacingByTryCount(tryCount, racingCarTrace);
        return racingCarTrace.getBiggestDistanceRacingCar();
    }

    private static void carRacingByTryCount(int tryCount, RacingCarTrace racingCarTrace) {
        IntStream.range(0, tryCount).forEach(index -> {
            forwardCarByRandomNumber(racingCarTrace);
            Prompt.tracePrint(racingCarTrace);
        });
    }

    private static void forwardCarByRandomNumber(RacingCarTrace racingCarTrace) {
        IntStream.range(0, racingCarTrace.size()).forEach(index -> {
            forwardCarLogic(racingCarTrace, index);
        });
    }

    private static void forwardCarLogic(RacingCarTrace racingCarTrace, int index) {
        var racingCar = racingCarTrace.getRacingCar(index);
        var randomNumber = Randoms.pickNumberInRange(0, 9);
        racingCarTrace.forwardOrStop(racingCar, randomNumber);
    }
}