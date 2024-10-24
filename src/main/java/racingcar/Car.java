package racingcar;

public class Car {
    private String Name;
    private int count;
    private final int MAX_LENGTH = 5;
    private final int MIN_LENGTH = 1;

    public void setName(String name) {
        validationName(name);
        this.Name = name;
    }

    public String getName(){
        return Name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void validationName(String name) {
        //이름 길이는 1~5
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("이름 값이 없습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이가 5보다 큽니다.");
        }
    }
}
