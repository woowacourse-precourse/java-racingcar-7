package racingcar.model;
public class Name {
    private final String name;
    private Name(String name){
        validate(name);
        validateLength(name);
        this.name = name;
    }
    public static Name from(String name){
        return new Name(name);
    }

    private void validateLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
        }
    }

    public String getName(){
        return name;
    }
}
