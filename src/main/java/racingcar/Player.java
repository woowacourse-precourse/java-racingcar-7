package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Player {
    private final String playerName;
    private int place;

    public Player(String playerName) {
        this.playerName = playerName;
        this.place = 0;
    }

    public void move(int pick) {
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
