package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racer {
    private final RacerName name;
    private final Movement move;

    public Racer(String name) {
        this.name = new RacerName(name);
        this.move = new Movement(0);

    }

    public void random() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random > 3) {
            move.forward();
        }
    }

    public int getCurrentPlace() {
        return move.currentPlace();
    }

    public String getRacerName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return name + " : " + move;
    }
}
