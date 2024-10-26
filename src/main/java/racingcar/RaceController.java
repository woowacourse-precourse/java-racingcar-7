package racingcar;

public class RaceController {

    private Race race;
    private UserView userView;

    public RaceController(UserView userView) {
        this.userView = userView;
    }

    public void run() {
        String[] carNames = userView.createCars();
        int round = userView.inputRoundCount();

        race = new Race(carNames);
        race.proceedRace(round);

        userView.displayRace(race.getCars());
        userView.displayWinner(race.getWinners());
    }
}
