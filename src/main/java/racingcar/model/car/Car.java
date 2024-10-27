package racingcar.model.car;

public class Car implements Comparable<Car>{
    private String name;
    private int status;

    public Car(String givenName) {
        this.name = givenName;
        this.status = 0;
    }

    public void forward() {
        increase();
    }

    public int getStatus(){
        return this.status;
    }

    public String getName(){
        return this.name;
    }

    private void setStatus(int givenStatus){
        this.status = givenStatus;
    }

    private void increase(){
        setStatus(getStatus()+1);
    }

    @Override
    public int compareTo(Car o) {
        return this.getStatus()-o.getStatus();
    }

    @Override
    public String toString(){
        return this.getName();
    }
}

