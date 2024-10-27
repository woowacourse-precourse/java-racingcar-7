package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private String moveRecord;

    public RacingCar(String name) {
        this.name = name;
        moveRecord = "";
    }

    public void move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if(randomNum >= 4) {
            // move
            moveRecord += "-";
        }
        // else, don't move (stop)
    }

    public void showRacingStatus() {
        System.out.println(name + " : " + moveRecord);
    }

    public String getName() {
        return name;
    }

    public String getMoveRecord() {
        return moveRecord;
    }
}
