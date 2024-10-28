package racingcar.controller;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingGame;
import racingcar.service.ParsingService;
import racingcar.service.RandomGameService;
import racingcar.service.SeperatorService;
import racingcar.service.ValidService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final SeperatorService seperator= new SeperatorService();
    private final ParsingService parsing=new ParsingService();
    private final ValidService valid=new ValidService();
    private final RacingGame racingGame=new RacingGame();
    private final RandomGameService randomGameService=new RandomGameService();
    public void start(){
        OutputView.requestCarsName();
        String input= InputView.getInput();
        //이름 분리
        seperator.seperateName(input);

        //이름 유효성 검사
        for (String name : seperator.getNames()) {
            valid.valid(name);
        }
        // RacingGame에 차 추가
        for (String name : seperator.getNames()) {
            racingGame.addCar(name);
        }

        // 시도 횟수 입력받고 파싱
        OutputView.requestTryNumber();
        String tryNumber=InputView.getInput();
        int tryNum=parsing.parseNum(tryNumber);

        //게임 진행
        for (int i=0;i<tryNum;i++){
            randomGameService.RandomGame(racingGame.getCars());
            OutputView.printEachResult(racingGame.getCars());

        }

        //최종 우승자 가리기


        }







    }





