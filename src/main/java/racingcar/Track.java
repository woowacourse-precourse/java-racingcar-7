package racingcar;

public class Track {

    public void start() {
        Output.printStartMessage();
        String rawCarNamesString = Input.getCarNames();
        CarNameExtractor carNameExtractor = new CarNameExtractor(rawCarNamesString);
        Garage garage = new Garage(carNameExtractor.extractCarNames(rawCarNamesString));

        Output.printRoundMessage();
        Referee referee = new Referee(Input.getRound());

        Output.printBlankLine();

        Output.printResultMessage();
        for (int i = 0; i < referee.getRound(); i++) {
            garage.requestAllCarDecision();
            Output.printCarNameAndPosition(garage.tellAllCarDecision());
            Output.printBlankLine();
        }
        Output.printWinner(referee.judgmentWinner(garage.tellAllCarDecision()));
    }
}
