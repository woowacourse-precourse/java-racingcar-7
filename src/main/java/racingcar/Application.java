package racingcar;

public class Application {
    public static void main(String[] args) {

        RaceControl raceControl = new RaceControl();
        raceControl.enroll();
        raceControl.confirmRoster();
        raceControl.decideRound();

        raceControl.race();
    }

}