package racingcar.controller;

import racingcar.service.GameRule;
import racingcar.service.Separation;
import racingcar.view.View;
import racingcar.service.Verification;
import racingcar.car.RacingCar;
import racingcar.service.MakeCar;

public class GameController {
    private final View view;
    private final Separation separation;
    private final Verification verification;
    private final MakeCar makeCar;
    private final GameRule gameRule;

    public GameController() {
        this.view = new View();
        this.separation = new Separation();
        this.verification = new Verification();
        this.makeCar = new MakeCar();
        this.gameRule = new GameRule();
    }

    public void run() {
        view.Message();
        String userInput = view.userInput(); // 사용자 입력
        verification.special_characters(userInput); // 특수문자 확인

        String[] splitUserInput = separation.split(userInput); // 자동차 이름을 쉼표(,)로 구분하여 배열에 저장
        Verification.verifyCarNames(splitUserInput); // 자동차 이름이 5자 이하인지 확인

        RacingCar[] racingCar = makeCar.makeCar(splitUserInput); // 자동차 이름을 객체로 만들어 배열에 저장

        View.RoundAskMessage();
        String roundInput = view.userInput();
        int round = verification.Round(roundInput); // 라운드 검증

        gameRule.startGame(racingCar, round); // 게임 시작

    }
}
