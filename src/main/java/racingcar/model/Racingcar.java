package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Racingcar {

    private String name;
    private String distance;

    public Racingcar(String name) {
        this.name = name;
        this.distance = "";
    }

    public void move(StringBuilder middleResult) {
        randomMove();
        middleResult.append(this.name).append(" : ").append(this.distance).append("\n");
    }

    private void randomMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance += "-";
        }
    }
}
