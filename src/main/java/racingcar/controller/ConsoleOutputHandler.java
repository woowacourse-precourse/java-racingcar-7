package racingcar.controller;

import java.util.HashMap;
import racingcar.view.ConsoleView;

public class ConsoleOutputHandler {
    private final ConsoleView consoleView = new ConsoleView();
    public void displayResultMessage(){
        consoleView.displayResult();
    }
    public void printRaceResult(HashMap<String, Integer> raceResults){
        raceResults.forEach(consoleView::printRaceDetails);
        System.out.println();
    }
//    public void printRaceWinner(){
//
//    }
}
