package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Cars extends HashMap<String, Integer> {
    Cars(Set<String> carNames) {
        addCars(carNames);
    }

    public void addCars(Set<String> carsName) {
        for (String carName : carsName) {
            this.put(carName, 0);
        }
    }


    public String getWinnerNames(int winnerScore) {
        List<String> winnerNames = new ArrayList<>();
        for (String name : this.keySet()) {
            isWinner(winnerScore, name, winnerNames);
        }
        return String.join(",",winnerNames);
    }

    private void isWinner(int winnerScore, String name, List<String> winnerNames) {
        if(this.get(name) == winnerScore) {
            winnerNames.add(name);
        }
    }


    public int findWinScore() {
        int winnerScore = 0;
        for (String name : this.keySet()) {
            if (this.get(name) >= winnerScore) {
                winnerScore = this.get(name);
            }
        }
        return winnerScore;
    }

    public void go() {
        for (String name : this.keySet()) {
            int referenceNumber = Randoms.pickNumberInRange(0, 9);
            if(referenceNumber >3) {
                this.put(name, this.get(name)+1);
            }

        }
    }

    public void repeatGo(int attempts) {
        for (int i = 0; i < attempts; i++) {
            this.go();
        }
    }



}