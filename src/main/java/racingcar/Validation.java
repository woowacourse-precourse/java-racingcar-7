package racingcar;

public class Validation {
    public void carsValidation(String cars){
        String[] car_names = cars.split(",");
        for(int i=0;i<car_names.length;i++){
            if(car_names[i].length()>=6){
                throw new IllegalArgumentException();
            }
        }
    }

    public void attemptsValidation(String attempts){
        if(!attempts.matches("[+-]?\\d*(\\.\\d+)?")){
            throw new IllegalArgumentException();
        }
    }
}
