package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import racingcar.raceInterface.Observer;
import racingcar.raceInterface.Subject;

public class Cars extends HashMap<String, Integer> implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    public Cars(Set<String> carNames) {
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
        return String.join(", ", winnerNames);
    }

    private void isWinner(int winnerScore, String name, List<String> winnerNames) {
        if (this.get(name) == winnerScore) {
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
            if (referenceNumber > 3) {
                this.put(name, this.get(name) + 1);
            }
        }
        notifyObservers();
    }

    public void repeatGo(int attempts) {
        for (int i = 0; i < attempts; i++) {
            this.go();
        }
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.updateGoTrial(this);
        }
    }

}