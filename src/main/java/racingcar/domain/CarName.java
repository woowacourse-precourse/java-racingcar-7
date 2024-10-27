package racingcar.domain;

public class CarName {
    private final int MAX_LENGTH = 5;
    private final String NAME_LENGTH_OVER_ERROR = "자동차 이름의 길이는 5 이하여야만 합니다";

    private String name;

    public CarName(String name){
        if(name.length() > MAX_LENGTH){
            throw new IllegalArgumentException(NAME_LENGTH_OVER_ERROR);
        }
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
