package racingcar.controller;

import racingcar.service.parser.ParsingService;
import racingcar.service.parser.ParsingServiceEmb;
import racingcar.view.InputHandler;
import racingcar.view.InputHandlerEmb;

import java.util.List;

public class InputControllerEmb implements InputController{
    private final ParsingService parsingService;
    private final InputHandler inputHandler;

    public InputControllerEmb() {
        this.parsingService =  new ParsingServiceEmb();
        this.inputHandler = new InputHandlerEmb();
    }

    @Override
    public List<String> getCarsInput(){
        return parsingService.parseCarsIntoList(inputHandler.getInput());
    }

    @Override
    public Long getRoundInput(){
        return parsingService.parseStringIntoLong(inputHandler.getInput());
    }
}
