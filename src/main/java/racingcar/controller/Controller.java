package racingcar.controller;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingGame;
import racingcar.service.ParsingService;
import racingcar.service.SeperatorService;
import racingcar.service.ValidService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final SeperatorService seperator= new SeperatorService();
    private final ParsingService parsing=new ParsingService();
    private final ValidService valid=new ValidService();
    private final RacingGame racingGame=new RacingGame();
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


        OutputView.requestTryNumber();
        int tryNum=parsing.parseNum(input);



        }







    }




}


