package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    public static Racingcar[] createRacingcars(String[] carsName){   // 입력받은 레이싱카의 이름으로 n대의 레이싱카 초기화
        Racingcar[] racingcars = new Racingcar[carsName.length];
        for (int i = 0; i < racingcars.length; i++) {
            racingcars[i] = new Racingcar(carsName[i]);
        }

        return racingcars;
    }

    public static int createRandom(){   
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void checkMove(Racingcar[] racingcar){ // 전진하는 조건이 맞으면 레이싱카를 전진시키고 아니면 멈춰있는다.
        for (int i = 0; i < racingcar.length; i++) {
            if (createRandom()>=4) {
                Racingcar.moveRacingcar(racingcar[i]);
            }
        }
    }

    public static List<Racingcar> findWinner(Racingcar[] racingcars){   // 우승자를 전부 찾아서 반환
        int maxMoveCount = -1;
        List<Racingcar> winner = new ArrayList<>();

        for (Racingcar racingcar : racingcars) {
            if (racingcar.getMoveCount() > maxMoveCount) {
                maxMoveCount = racingcar.getMoveCount();
            }
        }

        for (Racingcar racingcar : racingcars) {
            if (racingcar.getMoveCount() == maxMoveCount) {
                winner.add(racingcar);
            }
        }

        return winner; 
    }
}
