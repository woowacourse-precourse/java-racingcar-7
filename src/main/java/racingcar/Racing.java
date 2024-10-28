package racingcar;

import java.util.List;
import racingcar.domain.Stadium;
import racingcar.io.Input;
import racingcar.io.Output;

public class Racing {

    private Input input;
    private Output output;

    public Racing(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        List<String> names = nameInputView();
        int playCount = playCountInputView();
        Stadium stadium = new Stadium(names);

        for (int i = 0; i < playCount; i++) {
            gameView(stadium.updateCarPositions());
        }

        announceWinnersView(stadium);
    }

    private List<String> nameInputView() {
        output.carNamesInputMessage();
        List<String> names = input.readCarNames();
        return names;
    }

    private int playCountInputView() {
        output.playCountInputMessage();
        int playCount = input.readPlayCount();
        return playCount;
    }

    private void gameView(List<String> scores) {
        output.printScore(scores);
        System.out.println();
    }

    private void announceWinnersView(Stadium stadium) {
        List<String> winners = stadium.getWinners();
        output.announceWinners(winners);
    }


}
