package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingDto {
    private final List<Car> playerList = new ArrayList<>();
    private int raceMovement;

    public void setRace(String players, String raceMovement) {
        setPlayer(players);
        this.raceMovement = Integer.parseInt(raceMovement);
    }

    public List<Car> goRace() {
        for (Car player : playerList) {
            if(Randoms.pickNumberInRange(0, 9) > 3) player.move();
        }
        return playerList;
    }

    public String getWinner() {

        int maxDistance = getMaxDistance();
        List<String> winnerList = getWinnerList(maxDistance);

        return String.join(",", winnerList);
    }

    public int getRaceMovement() {
        return raceMovement;
    }

    private void setPlayer(String nameList) {
        for (String name : nameList.split(",")) {
            checkPlayer(name);
            playerList.add(new Car(name));
        }
    }

    private List<String> getWinnerList(int maxDistance) {
       return playerList.stream().filter(player -> player.getMovement() == maxDistance).map(Car::getCarName).collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return playerList.stream().mapToInt(Car::getMovement).max().orElse(0);
    }

    private void checkPlayer(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
