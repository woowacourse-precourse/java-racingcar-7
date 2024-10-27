package controller;

import model.CarGame;
import model.GameRecordsManager;
import model.RaceCarParicipant;
import model.WinnerSelecter;
import view.CarInputView;
import view.WinnerOutputView;
import java.util.List;

public class RacingcarController {
  private final CarInputView carInputView;
  private final WinnerOutputView winnerOutputView;
  private final CarGame carGame;
  private final GameRecordsManager gameRecordsManager;
  private final RaceCarParicipant raceCarParicipant;
  private final WinnerSelecter winnerSelecter;
  private List<String> winner;

  public RacingcarController(){
    this.carInputView = new CarInputView();
    this.winnerOutputView = new WinnerOutputView();
    this.carGame = new CarGame();
    this.gameRecordsManager = new GameRecordsManager();
    this.raceCarParicipant = new RaceCarParicipant();
    this.winnerSelecter = new WinnerSelecter();
  }

  public void run(){
    carInputView.CarInput();
    raceCarParicipant.validateCars(carInputView.carInput);

    carInputView.repeatFrequency();
    gameRecordsManager.createCarGameRecords(raceCarParicipant.cars);

    carGame.showGame(gameRecordsManager.carGameRecords,carInputView.frequency);

    this.winner = winnerSelecter.selectWinner(gameRecordsManager.carGameRecords);
    winnerOutputView.showWinner(this.winner);
  }


}
