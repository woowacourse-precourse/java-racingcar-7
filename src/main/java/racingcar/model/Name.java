package racingcar.model;
public class Name {
    private final String name;
    private Name(String name){
        validateNullAndBlank(name);
        validateLength(name);
        this.name = name;
    }
    public static Name from(String name){
        return new Name(name);
    }
    private void validateNullAndBlank(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("입력이 null이거나 빈 문자열일 수 없다.");
        }
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
