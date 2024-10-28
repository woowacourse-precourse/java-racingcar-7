package racingcar.controller;


import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.util.NumberConverter;
import racingcar.util.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController{

    private final InputView inputView;
    private final OutputView outputView;
    private final StringParser stringParser;
    private final NumberConverter numberConverter;

    public RacingGameController(InputView inputView, OutputView outputView, StringParser stringParser, NumberConverter numberConverter){
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringParser = stringParser;
        this.numberConverter = numberConverter;
    }

    public void run(){
        String nameInput = inputView.name();

        String[] names = stringParser.parse(nameInput);

        List<Car> cars = new ArrayList<>();
        for(String name : names) {
            cars.add(new Car(name));
        }

        String roundInput = inputView.round();
        int round = numberConverter.convert(roundInput);

        RacingGame racingGame = new RacingGame(cars, round);

        for(int i = 0; i < round; i++) {
            outputView.resultOfRound(racingGame.progress());
        }

        outputView.winner(racingGame.selectWinner());
    }

}
