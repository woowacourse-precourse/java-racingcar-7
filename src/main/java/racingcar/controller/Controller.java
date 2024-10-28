package racingcar.controller;


import racingcar.service.Service;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final Integer INITIAL_NUMBER = 0;

    private final Service service = new Service();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run(){
        initGame();
        playGame();
        quitGame();
    }

    private void initGame(){
        service.setCarName(Parser.convertStringToList(inputView.readCarName()));
    }

    private void playGame(){
        Integer count = inputView.readRaceCount();
        outputView.printGameResultMessage();

        for(int i=INITIAL_NUMBER; i<count; i++) {
            outputView.printGameResult(service.playGame());
        }
    }

    private void quitGame(){
        outputView.printFinalWinner(service.getWinner());
    }


}
