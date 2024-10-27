package racingcar;

public class Application {
    public static void main(String[] args) {

        RaceControl raceControl = new RaceControl();

        String enrolledNames = raceControl.enroll();
        raceControl.verifyName(enrolledNames);

        raceControl.confirmRoster();

        raceControl.decideRound();

        raceControl.race();

        raceControl.selectWinner();
    }

}