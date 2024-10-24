package racingcar.model.validator;


import java.util.HashSet;

public class CarNameValidator implements Validator<String[]>{

    private static final int MAX_LENGTH = 5;
    private static final String REGEX = "[a-zA-Z ]"; // 우선은 알파벳 및 공백만 허용
    private String[] input;
    private HashSet<String> nameSet;

    @Override
    public void validate(String[] input){

        setInput(input);

        checkNull();
        checkEmpty();

        validateTokens();
    }

    private void setInput(String[] input){
        this.input = input;
    }

    private void checkNull(){
        if(input == null){
            throw new IllegalArgumentException();
        }
    }

    private void checkEmpty(){
        if(input.length == 0){
            throw new IllegalArgumentException();
        }
    }

    private void validateTokens(){
        for (String s : input) {
            checkEmptyToken(s);
            checkDuplicate(s);
            checkLength(s);
            checkFormat(s);
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

    private void checkLength(String token){
        if(token.length() > MAX_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    private void checkFormat(String token){
        if(!token.matches(REGEX)){
            throw new IllegalArgumentException();
        }
    }


}
