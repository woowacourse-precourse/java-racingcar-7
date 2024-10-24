package racingcar;

public class Name {

    private final String name;
    private final String NAME_LENGTH_HAVE_TO_UNDER_FIVE = "입력한 이름의 길이는 5보다 클 수 없습니다.";

    public Name(String name) {
        if (name.length() > 5){
            throw new IllegalArgumentException(NAME_LENGTH_HAVE_TO_UNDER_FIVE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
