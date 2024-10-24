package racingcar.model.validator;

import racingcar.model.util.StringProcessor.;
public class CarNameValidator {

    String input;
    public void validateCarNames(String input){

        setInput(input);

        checkEmpty();
        checkNull();

    }

    private void setInput(String input){
        this.input = input;
    }

    private void checkEmpty(){
        input = input.trim();
        if(input.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private void checkNull(){
        if(input == null){
            throw new IllegalArgumentException();
        }
    }
}
