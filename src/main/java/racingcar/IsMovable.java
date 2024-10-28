package racingcar;

public class IsMovable {
    int iteration;
    int numberOfCars;
    int[] result;

    IsMovable(int numberOfCars, int iteration){
     this.iteration = iteration;
     this.numberOfCars = numberOfCars;
     this.result = new int[numberOfCars];
    }

    int[] getIsMovable(){
        for(int i=0; i<iteration; i++){
            for(int j=0; j<numberOfCars; j++){
                int randomNumber = RandomNumber.getRandomNumber();
                result[j] += IsMoreThan4.getIsMoreThan4(randomNumber);
            }
        }
        return result;
    }
}
