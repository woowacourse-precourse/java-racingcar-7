package racingcar.core;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.creator.RacingCarGameCreator;
import racingcar.domain.RacingCar;

public class RacingCarGame {

    private final List<RacingCar> carList;
    private final int numOfAttempts;

    public RacingCarGame(RacingCarGameCreator creator) {
        this.carList = creator.getCarList();
        this.numOfAttempts = creator.getNumOfAttempts();
    }

    public void start() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append("실행 결과\n");
        int cnt = 0;
        while (cnt < numOfAttempts) {
            carList.forEach(car -> {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random >= 4) {
                    car.moveForward();
                }
                sb.append(car + "\n");
            });
            sb.append("\n");
            cnt++;
        }
        System.out.print(sb);
    }

    public void printWinner() {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        carList.forEach(car -> {
            if (car.isWinner()) {
                sb.append(car.getId());
                sb.append(", ");
            }
        });
        sb.append("\b\b");
        System.out.println(sb);
    }
}
