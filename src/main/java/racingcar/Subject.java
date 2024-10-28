package racingcar;

public interface Subject {
    void registerObserver(Observer observer);

    void notifyObservers();

}
