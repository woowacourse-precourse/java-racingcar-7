package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.vehicle.Car;

public class Game {
    ArrayList<Car> player = new ArrayList<>();

    public ArrayList<Car> gameStart(String carNames, String cnt) {
        for (String carName : carNames.split(",")) {
            Car car = new Car(carName);
            player.add(car);
        }
        System.out.println("실행 결과");

        for (int i = 0; i < Integer.parseInt(cnt); i++) {
            player.forEach(car -> car.run(Randoms.pickNumberInRange(0, 9)));
            System.out.println();
        }
        return this.player;
    }

    public void winnerPlayer(ArrayList<Car> player) {
        int max = Integer.MIN_VALUE;
        for (Car car : player) {
            if (car.getCnt() > max) {
                max = car.getCnt();
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        int i = 0;
        for (Car car : player) {
            if (car.getCnt() == max) {
                arr.add(car.getName());
            }
        }
        String answer = String.join(", ", arr);
        System.out.println("최종 우승자 : " + answer);
    }
}
