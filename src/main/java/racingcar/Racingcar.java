package racingcar;

public class Racingcar {
    private final String name;
    private int position;

    public Racingcar(String name){
        if(name.length() > 5 || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = 0;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void move(){
        position++;
    }
}
