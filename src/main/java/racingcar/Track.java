package racingcar;

import java.util.List;

public class Track {

    public void start() {
        Output.printStartMessage();
        String rawCarNamesString = Input.getCarNames();

        List<String> carNames = new CarNameExtractor(rawCarNamesString).extractCarNames(rawCarNamesString);
        Garage garage = new Garage(carNames);

        Output.printRoundMessage();
        String rawRound = Input.getRound();

        int round = new RoundExtractor(rawRound).extractRound(rawRound);
        Referee referee = new Referee();

        raceAndAnnounceWinner(round, garage, referee);
    }

    private void raceAndAnnounceWinner(int round, Garage garage, Referee referee) {
        Output.printBlankLine();

        Output.printResultMessage();
        for (int i = 0; i < round; i++) {
            garage.requestAllCarDecision();
            Output.printCarNameAndPosition(garage.tellAllCarDecision());
            Output.printBlankLine();
        }
        Output.printWinner(referee.judgmentWinner(garage.tellAllCarDecision()));
    }
}
