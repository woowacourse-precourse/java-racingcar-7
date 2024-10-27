package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private String movedHistory;

    public RacingCar(String name) {
        this.name = name;
        movedHistory = "";
    }

    public void move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if(randomNum >= 4) {
            // move
            movedHistory += "-";
        }
        // else, don't move (stop)
    }

    public void showRacingStatus() {
        System.out.println(name + " : " + movedHistory);
    }

    public String getName() {
        return name;
    }

    public String getMovedHistory() {
        return movedHistory;
    }
}
