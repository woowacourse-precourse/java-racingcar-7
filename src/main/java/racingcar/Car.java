package racingcar;

public class Car {
    String name;
    int distance;

    public Car(String name){
        this.name = name;
        distance = 0;
    }

    public void Move(){
        distance++;
    }

    public void PrintCurrentDistance(){
        System.out.print(name + " : ");
        for(int i = 0; i < distance; i++){
            System.out.print('-');
        }
        System.out.println();
    }
}
