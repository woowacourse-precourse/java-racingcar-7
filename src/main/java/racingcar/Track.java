package racingcar;

import java.util.List;
import racingcar.extractor.CarNameExtractor;
import racingcar.extractor.Extractor;
import racingcar.extractor.RoundExtractor;

public class Track {

    public void start() {
        Output.printStartMessage();
        String rawCarNamesString = Input.getCarNames();
        Extractor<List<String>> carNameExtractor = new CarNameExtractor();
        List<String> carNames = carNameExtractor.extract(rawCarNamesString);
        Garage garage = new Garage(carNames);

        Output.printRoundMessage();
        String rawRound = Input.getRound();
        Extractor<Integer> roundExtractor = new RoundExtractor();
        int round = roundExtractor.extract(rawRound);

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
