package racingcar.raceInterface;

public interface Subject {
    void registerObserver(Observer observer);

    void notifyObservers();

}
