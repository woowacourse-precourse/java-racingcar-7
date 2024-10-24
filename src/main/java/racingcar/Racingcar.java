package racingcar;

import java.util.ArrayList;

public class Racingcar {
    private ArrayList<Car> array;
    private int count;
    private int max = 0;

    public Racingcar(String inputString, String count){
        CustomString customString = new CustomString();
        this.array = customString.arrayToList(inputString);
        this.count = customString.stringToInt(count);
    }

    public void racing(){
        for(int i = 0; i< count; i++){
            for(Car car : array){
                update(car);
            }
            System.out.println("");
        }
    }
    private void update(Car car){
        final int value = car.upValue();
        if(max < value)
            max = value;
        printStatusEachCar(car);
    }

    private static void printStatusEachCar(Car car){
        StringBuilder stringBuilder = new StringBuilder(car.name + " : ");
        for(int i = 0; i< car.value; i++){
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    public String getResult(){
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for(Car car : array){
            if(car.value == max)
                result.append(car.name).append(", ");
        }
        result.setLength(result.length()-2);
        return result.toString();
    }
}
