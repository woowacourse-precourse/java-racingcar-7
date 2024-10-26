package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.io.OutputManager;
import racingcar.vehicle.Car;

public class Game {

    public List<Car> gameStart(String carNames, String cnt) {
        List<Car> playerCars = assignPlayer(carNames);

        OutputManager.getInstance().print("실행 결과");

        for (int i = 0; i < parseCntNumber(cnt); i++) {
            playerCars.forEach(car ->
                    car.run(Randoms.pickNumberInRange(0, 9))
            );
            OutputManager.getInstance().print("");
        }
        return playerCars;
    }

    public void winnerPlayer(List<Car> player) {
        int max = playerMaxCnt(player);

        List<String> winner = player.stream()
                .filter(car -> car.getCnt() == max)
                .map(Car::getName)
                .toList();
        OutputManager.getInstance().print("최종 우승자 : " + String.join(", ", winner));
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
                .orElseThrow();
    }

    private int parseCntNumber(String cnt) {
        try {
            return Integer.parseInt(cnt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }
}
