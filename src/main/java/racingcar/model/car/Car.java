package racingcar.model.car;

public class Car {

    private final String name;
    private int progress = 0;
    private static final String SEPARATOR = " : ";
    private static final String PROGRESS_BAR = "-";

    public Car(String name){
        this.name = name;
    }

    public int getProgress(){
        return progress;
    }

    public String getName(){
        return name;
    }

    public void updateProgress(){
        progress++;
    }
}
