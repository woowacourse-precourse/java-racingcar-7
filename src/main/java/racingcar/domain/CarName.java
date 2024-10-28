package racingcar.domain;

public class CarName {
    private final int MAX_LENGTH = 5;
    private final String NAME_LENGTH_OVER_ERROR_MESSAGE = "자동차 이름의 길이는 5 이하여야만 합니다";
    private final String EMPTY_NAME_ERROR_MESSAGE = "자동차의 이름은 비어있을 수 없습니다."

    private String name;

    public CarName(String name){
        checkCarNameisBlank(name);
        checkCarNamelength(name);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void checkCarNamelength(String name){
        if(name.length() > MAX_LENGTH){
            throw new IllegalArgumentException(NAME_LENGTH_OVER_ERROR_MESSAGE);
        }
    }

    public void checkCarNameisBlank(String name){
        if(name.isBlank()){
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }
    }
}
