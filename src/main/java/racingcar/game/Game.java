package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import racingcar.exception.DuplicateCarException;
import racingcar.io.OutputManager;
import racingcar.vehicle.Car;

public class Game {

    public HashMap<String, Car> gameStart(String carNames, String cnt) {
        HashMap<String, Car> playerCars = assignPlayer(carNames);

        OutputManager.getInstance().print("실행 결과");

        for (int i = 0; i < parseCntNumber(cnt); i++) {
            playerCars.values().forEach(car ->
                    car.run(Randoms.pickNumberInRange(0, 9))
            );
            OutputManager.getInstance().print("");
        }
        return playerCars;
    }

    public List<String> winnerPlayer(HashMap<String, Car> player) {
        int max = playerMaxCnt(player);
        return player.
                values()
                .stream()
                .filter(car -> car.getCnt() == max)
                .map(Car::getName)
                .toList();
    }

    public HashMap<String, Car> assignPlayer(String message) throws DuplicateCarException {
        HashMap<String, Car> players = new LinkedHashMap<>();
        Arrays.stream(message.split(","))
                .forEach(name -> {
                    if (players.containsKey(name)) {
                        throw new DuplicateCarException("Player with name '" + name + "' already exists.");
                    }
                    players.put(name, new Car(name));
                });
        return players;
    }

    private int playerMaxCnt(HashMap<String, Car> player) {
        return player.values()
                .stream()
                .mapToInt(Car::getCnt)
                .max()
                .orElseThrow();
    }

    private int parseCntNumber(String cnt) throws IllegalArgumentException {
        try {
            return Integer.parseInt(cnt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }
}
