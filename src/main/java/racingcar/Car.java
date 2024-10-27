package racingcar;

public class Car {
    private String name;
    private Integer forward;

    public Car(String carName, int forward) {
        this.name = carName;
        this.forward = forward;
    }

    public void moveForward(){
        forward = getForward() + 1;
    }

    public void printForward(){
        System.out.print(getName() + " : ");
        for(int i=0; i<forward; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    private String getName(){
        return name;
    }
    private Integer getForward(){
        return forward;
    }

}
