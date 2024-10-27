package racingcar.modle.vehicle.car;

public class Name {
    private final String name;

    public Name(String name){
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("이름을 null 또는 공백으로 잘못 입력하셨습니다.");
        }
    }
}
