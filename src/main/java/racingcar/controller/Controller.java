package racingcar.controller;
import racingcar.service.ParsingService;
import racingcar.service.SeperatorService;
import racingcar.service.ValidService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final SeperatorService seperator= new SeperatorService();
    private final ParsingService parsing=new ParsingService();
    private final ValidService valid=new ValidService();
    public void start(){
        OutputView.requestCarsName();
        String input= InputView.getInput();
        //이름 분리
        seperator.seperateName(input);

        //이름 유효성 검사
        for (String name : seperator.getNames()) {
            valid.valid(name);
        }
        OutputView.requestTryNumber();
        int tryNum=parsing.parseNum(input);








    }




}


