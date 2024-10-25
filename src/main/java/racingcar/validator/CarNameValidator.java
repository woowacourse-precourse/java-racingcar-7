package racingcar.validator;


import java.util.HashSet;

public class CarNameValidator implements Validator<String[]>{

    private static final int MAX_LENGTH = 5;
    private static final int ZERO = 0;
    private static final String REGEX = "^[a-zA-Z]+$";
    private String[] input;
    private HashSet<String> nameSet;

    @Override
    public void validate(String[] input){

        setInput(input);
        nameSet = new HashSet<>();

        checkNull();
        checkEmpty();

        validateTokens();
    }

    private void setInput(String[] input){
        this.input = input;
    }

    private void checkNull(){
        if(input == null){
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }
    }

    private void checkEmpty(){
        if(input.length == ZERO){
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
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
            throw new IllegalArgumentException("자동차 이름에 빈 값이 포함되어 있습니다.");
        }
    }

    private void checkDuplicate(String token){
        if(!nameSet.add(token)){
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + token);
        }
    }

    private void checkLength(String token){
        if(token.length() > MAX_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 " + MAX_LENGTH + "자를 초과할 수 없습니다: " + token);
        }
    }

    private void checkFormat(String token){
        if(!token.matches(REGEX)){
            throw new IllegalArgumentException("자동차 이름은 알파벳만 포함할 수 있습니다: " + token);
        }
    }
}
