package racingcar.model;

public class Car {
    private String name;
    private StringBuilder dashes;

    public Car(String name){
        this.name=name;
        this.dashes=new StringBuilder();
    }
    public String getName(){
        return name;
    }

    public String getDashes(){
        return dashes.toString();
    }

    public void addDash(){
        dashes.append("-");
    }

    public int getDashCount(){
        return dashes.length();
    }
}
