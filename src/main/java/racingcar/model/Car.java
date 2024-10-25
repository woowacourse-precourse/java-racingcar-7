package racingcar.model;

public class Car {
    private String name;

    public Car(String name) {
        if(name==null) throw new IllegalArgumentException("이름이 null이 될 수 없습니다.");
        if(name.length()>5|| name.isEmpty()){
            throw new IllegalArgumentException("이름이 5자 이상 될 수 없습니다.");
        }
        if (!name.matches("^[a-zA-Z]+$")){
            throw new IllegalArgumentException("자동차 이름은 영어만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
