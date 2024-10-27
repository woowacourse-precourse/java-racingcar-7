package racingcar;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class CarRaceSimulator {

    List<String> carNames;
    int tryNum;
    List<Integer> carMoves;

    CarRaceSimulator(List<String> carNames, int tryNum) {
        this.carNames = carNames;
        this.tryNum = tryNum;
        this.carMoves = new ArrayList<>();
        for(int i = 0; i < carNames.size(); i++) {
            this.carMoves.add(0);
        }
    }

    public void runOneTime() { // 1회 실행
        for(int i = 0; i < carNames.size(); i++) {
            if(Randoms.pickNumberInRange(0, 9) >= 4) {
                carMoves.set(i, carMoves.get(i) + 1);
            }
        }
    }

    public void printOneTimeResult() {
        
    }

    public void printWinner() {

    }
}
