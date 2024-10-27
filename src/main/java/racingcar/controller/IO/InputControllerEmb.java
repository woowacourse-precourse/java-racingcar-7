package racingcar.controller.IO;

import racingcar.service.parser.ParsingService;
import racingcar.service.parser.ParsingServiceEmb;
import racingcar.service.parser.ValidCheck;
import racingcar.service.parser.ValidCheckEmb;
import racingcar.view.InputHandler;
import racingcar.view.InputHandlerEmb;

import java.util.List;

public class InputControllerEmb implements InputController{
    private final ParsingService parsingService;
    private final InputHandler inputHandler;
    private final ValidCheck validCheck;

    public InputControllerEmb() {
        this.parsingService =  new ParsingServiceEmb();
        this.inputHandler = new InputHandlerEmb();
        this.validCheck = new ValidCheckEmb();
    }

    @Override
    public List<String> getCarsInput(){
        List<String> cars = parsingService.parseCarsIntoList(inputHandler.getInput());
        validCheck.areCarNamesValid(cars);
        validCheck.isDuplicate(cars);
        return cars;
    }

    @Override
    public Long getRoundInput(){
        Long round = parsingService.parseStringIntoLong(inputHandler.getInput());
        return round;
    }
}
