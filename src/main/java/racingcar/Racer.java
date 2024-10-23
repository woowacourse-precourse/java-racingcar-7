package racingcar;

public class Racer {
    private String name;
    private int position = 0;

    public Racer(String name){
        if(name.length()>5){
            throw new IllegalArgumentException(name + "의 길이가 5를 초과했습니다.");
        }
        this.name = name;
    }
}
