package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarRunner {

    private List<RacingCar> carList = new ArrayList<>();
    private int n;
    private int maxDistance = 0;

    public RacingCarRunner(String[] cars, int n) {
        Arrays.stream(cars).forEach(carName -> this.carList.add(new RacingCar(carName)));
        this.n = n;
    }

    public void run() {
        System.out.println("\n실행 결과");
        while (n > 0) {
            for (RacingCar car : carList) {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random >= 4) {
                    int distance = car.moveForward();
                    if (distance >= maxDistance) {
                        maxDistance = distance;
                    }
                }
                System.out.println(car);
            }
            System.out.println();
            this.n--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).isSameDistance(maxDistance)) {
                sb.append(carList.get(i).getId());
                sb.append(", ");
            }
        }
        sb.append("\b\b");
        System.out.println(sb);
    }
}
