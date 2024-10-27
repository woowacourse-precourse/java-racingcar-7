package racingcar;

public class Car {
    String name;
    int distance;

    public Car(String name){
        this.name = name;
        distance = 0;
    }

    public void move(){
        if(canMove())
            distance++;
    }

    private boolean canMove(){
        return (int)(Math.random() * 10) >= 4;
    }

    public void printCurrentDistance(){
        System.out.print(name + " : ");
        for(int i = 0; i < distance; i++){
            System.out.print('-');
        }
        System.out.println();
    }
}
