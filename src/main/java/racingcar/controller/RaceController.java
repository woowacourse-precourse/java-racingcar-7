package racingcar.controller;

public interface RaceController {
    void readyForRace();
    void advanceCars();
    boolean isFinished();
    void announceWinner();
    void broadcastRace();
}
