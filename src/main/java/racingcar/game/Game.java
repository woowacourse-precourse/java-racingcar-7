package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.vehicle.Car;

public class Game {

    public List<Car> gameStart(String carNames, String cnt) {
        List<Car> playerCars = assignPlayer(carNames);

        System.out.println("실행 결과");

        for (int i = 0; i < Integer.parseInt(cnt); i++) {
            playerCars.forEach(car ->
                    car.run(Randoms.pickNumberInRange(0, 9))
            );
            System.out.println();
        }
        return playerCars;
    }

    public void winnerPlayer(List<Car> player) {
        int max = playerMaxCnt(player);

        List<String> winner = new ArrayList<>();
        for (Car car : player) {
            if (car.getCnt() == max) {
                winner.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }

    private List<Car> assignPlayer(String carName) {
        return Arrays.stream(carName.split(","))
                .map(Car::new)
                .toList();
    }

    private int playerMaxCnt(List<Car> player) {
        return player.stream()
                .mapToInt(Car::getCnt)
                .max()
                .getAsInt();
    }
}
