package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingCarService {

    private static final int MINIMUM_TRY_COUNT = 1;

    public List<String> startRacingGame(List<Car> cars, int tryCount) {

        while (tryCount-- >= MINIMUM_TRY_COUNT) {
            for (Car car : cars) {
                int ramdomNumber = Randoms.pickNumberInRange(0, 9);

                System.out.print(car.getName() + " : ");

                if (ramdomNumber >= 4) {      // 전진
                    car.go();
                }
                for (int i = 0; i < car.getPos(); i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        // 게임 결과 산출
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPos());
        }

        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPos() == max) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }
}
