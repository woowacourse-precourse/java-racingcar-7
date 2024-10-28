package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import racingcar.raceInterface.Observer;
import racingcar.raceInterface.Subject;

public class Cars extends HashMap<String, Integer> implements Subject {
    public static final int GO_CONDITION = 3;
    private final List<Observer> observers = new ArrayList<>();
    private int trial = 0;

    public void addCars(Set<String> carsName) {
        for (String carName : carsName) {
            this.put(carName, 0);
        }
    }

    public String getWinnerNames(int winnerScore) {
        List<String> winnerNames = new ArrayList<>();
        getWinners(winnerScore, winnerNames);
        return String.join(", ", winnerNames);
    }

    private void getWinners(int winnerScore, List<String> winnerNames) {
        for (String name : this.keySet()) {
            isWinner(winnerScore, name, winnerNames);
        }
    }

    private void isWinner(int winnerScore, String name, List<String> winnerNames) {
        if (this.get(name) == winnerScore) {
            winnerNames.add(name);
        }
    }

    public int findWinScore() {
        int winnerScore = 0;
        for (String name : this.keySet()) {
            winnerScore = isWinScore(name, winnerScore);
        }
        return winnerScore;
    }

    private int isWinScore(String name, int winnerScore) {
        if (this.get(name) >= winnerScore) {
            winnerScore = this.get(name);
        }
        return winnerScore;
    }

    public void go() {
        for (String name : this.keySet()) {
            int referenceNumber = Randoms.pickNumberInRange(0, 9);
            isOverCondition(name, referenceNumber);
        }
        notifyObservers();
    }

    private void isOverCondition(String name, int referenceNumber) {
        if (referenceNumber > GO_CONDITION) {
            this.put(name, this.get(name) + 1);
        }
    }

    public void repeatGo() {
        for (int i = 0; i < this.trial; i++) {
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

    public void setTrialCount(int i) {
        this.trial = i;
    }
}