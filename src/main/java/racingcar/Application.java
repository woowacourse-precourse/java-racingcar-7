package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class RacingCar {
    private String name;
    private int moves;

    public RacingCar(String name) {
        this.name = name;
        this.moves = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoves() {
        return moves;
    }

    public void addMoves() {
        moves++;
    }

    public boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
