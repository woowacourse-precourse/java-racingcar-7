package racingcar.controller;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.service.ParsingService;
import racingcar.service.SeperatorService;
import racingcar.valid.Valid;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    public void start(){
        OutputView.requestCarsName();
        String input= InputView.getInput();
        SeperatorService seperator=new SeperatorService();
        ParsingService parsing=new ParsingService();
        Valid valid=new Valid();
        //이름 유효성 검사
        for (String name : seperator.getNames()) {
            valid.valid(name);
        }
        OutputView.requestTryNumber();
        int tryNum=parsing.parsingNum(input);








    }




}


