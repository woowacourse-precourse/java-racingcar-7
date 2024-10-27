package racingcar;

public interface Observer {
    void displayOneTrial();

    void displayWinner();

    void updateGoTrial(Cars goTrialResult);

    void updateWinner(Cars winnerResult);
}
