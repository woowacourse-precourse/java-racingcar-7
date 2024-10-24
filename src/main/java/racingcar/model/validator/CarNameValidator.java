package racingcar.model.validator;


import java.util.HashSet;

public class CarNameValidator {

    private String[] input;
    private HashSet<String> nameSet;
    public void validateCarNames(String[] input){

        setInput(input);

        checkNull();

        for (String s : input) {
            checkEmptyToken(s);
            checkDuplicate(s);
        }
    }

    private void setInput(String[] input){
        this.input = input;
    }

    private void checkNull(){
        if(input == null){
            throw new IllegalArgumentException();
        }
    }

    private void checkEmptyToken(String token){
        if(token.isEmpty() || token.equals(" ")){
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(String token){

        if(!nameSet.add(token)){
            throw new IllegalArgumentException();
        }
        nameSet.add(token);
    }


}
