package controller;

import race.Race;
import racingcar.Car;
import racingcar.Round;
import util.Constants;
import util.StringParser;
import view.InputView;
import view.OutputView;

public class RaceController {
    public static void run(){
        String[] inputs = InputView.inputWindow();
        String[] names = StringParser.parseString(inputs[0], ",");
        int tryCount = Integer.parseInt(inputs[1]);

        Race race = new Race();
        for(String name : names)
            race.addPlayer(new Car(name));

        for(int i = 0; i < tryCount; i++){
            race.playRound();
        }

        StringBuilder roundResult = new StringBuilder();
        StringBuilder raceWinner = new StringBuilder();

        for(Round round : race.getRounds()){
            roundResult.append(round.printResult()).append("\n");
        }

        raceWinner.append(race.printFinalResult());

        OutputView.outputWindow(new String[]{Constants.NOTICE_OUTPUT_ROUND_RESULT + "\n" + roundResult.toString()
                , Constants.NOTICE_OUTPUT_FINAL_RESULT + raceWinner.toString()});
    }
}
