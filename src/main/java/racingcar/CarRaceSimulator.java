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
        for(int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            for(int j = 0; j < carMoves.get(i); j++) { //자동차가 움직인 만큼 "-" 출력
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner() {
        List<String> winnerList = new ArrayList<>();
        for(int i = 0; i < carMoves.size(); i++) { //carMoves의 i번째 값이 tryNum과 같다면 carNames의 i번째 이름 winnerList에 추가
            if(carMoves.get(i) == tryNum) {
                winnerList.add(carNames.get(i));
            }
        }

        if(winnerList.isEmpty()) {
            System.out.println("결승선을 통과한 자동차가 없습니다. \n우승자는 없습니다.");
        }else {
            String winner = String.join(", ", winnerList);
            System.out.println("최종 우승자 : " + winner);
        }
    }
}
