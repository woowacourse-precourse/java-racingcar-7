package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.service.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    //멤버
    private final SeparatorService separator = new SeparatorService();
    private final NumberParsingService parsing = new NumberParsingService();
    private final ValidService valid = new ValidService();
    private final RacingGame racingGame = new RacingGame();
    private final RandomGameService randomGameService = new RandomGameService();
    private final WinnerService winnerService = new WinnerService();

    //Controller 구동함수
    public void start() {
        OutputView.requestCarsName();
        String input = InputView.getInput();

        //이름 분리
        separator.separateName(input);

        //이름 유효성 검사
        for (String name : separator.getNames()) {
            valid.valid(name);
        }
        // RacingGame에 차 추가
        for (String name : separator.getNames()) {
            racingGame.addCar(name);
        }

        // 시도 횟수 입력받고 파싱
        OutputView.requestTryNumber();
        String tryNumber = InputView.getInput();
        int tryNum = parsing.parseNum(tryNumber);

        //게임 진행
        OutputView.printStart();
        for (int i = 0; i < tryNum; i++) {
            randomGameService.startRandomGame(racingGame.getCars());
            OutputView.printEachResult(racingGame.getCars());
        }

        //최종 우승자 가리기
        winnerService.searchWinners(racingGame.getCars());

        //최종 우승자 출력
        OutputView.printWinners(winnerService.getWinners());
    }
}





