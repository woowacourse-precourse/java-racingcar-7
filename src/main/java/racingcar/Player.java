package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.function.Supplier;

public class Player {
    private final String playerName;
    private int place;
    private final Supplier<Integer> pickUpLogic;

    public Player(String playerName, Supplier<Integer> pickUpLogic) {
        if(playerName.isEmpty() || playerName.length() > 5) throw new IllegalArgumentException();
        this.playerName = playerName;
        this.place = 0;
        this.pickUpLogic = pickUpLogic;
    }

    public void move() {
        int pick = pickUpLogic.get();
        if (pick >= 4) {
            place++;
        }
    }

    public void printPlace() {
        String positionMark = "-".repeat(place);
        System.out.println(playerName + " : " + positionMark);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlace() {
        return place;
    }
}
