package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Racingcar {

    private String name;
    private String distance;

    public Racingcar(String name) {
        this.name = name;
        this.distance = "";
    }

    public Racingcar(String name, String distance){
        this.name = name;
        this.distance = distance;
    }

    public void move(StringBuilder middleResult) {
        randomMove();
        middleResult.append("\n").append(this.name).append(" : ").append(this.distance);
    }

    public int getDistanceLength() {
        return distance.length();
    }

    public String getName() {
        return this.name;
    }

    private void randomMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance += "-";
        }
    }
}
