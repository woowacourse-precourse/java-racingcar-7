package racingcar.controller;
import racingcar.service.SeperatorService;
import racingcar.valid.Valid;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {


    public void start(){
        OutputView.requestCarsName();
        String s= InputView.getInput();
        SeperatorService seperator=new SeperatorService(s);
        Valid valid=new Valid();
        //이름 유효성 검사
        for (String name : seperator.getNames()) {
            valid.valid(name);
        }
        OutputView.requestTryNumber();




    }




}


