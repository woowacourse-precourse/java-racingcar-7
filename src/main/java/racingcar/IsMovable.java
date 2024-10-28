package racingcar;

import racingcar.IO.CarNamesOutput;

public class IsMovable {
    String[] carNames;
    int iteration;
    int numberOfCars;
    int[] result;

    IsMovable(String[] carNames, int iteration){
        this.carNames = carNames;
        this.numberOfCars = carNames.length;
        this.iteration = iteration;
        this.result = new int[numberOfCars];
    }

    int[] getIsMovable(){
        for(int i=0; i<iteration; i++){
            for(int j=0; j<numberOfCars; j++){
                int randomNumber = RandomNumber.getRandomNumber();
                result[j] += IsMoreThan4.getIsMoreThan4(randomNumber);
            }
            //전진 유무값이 담긴 result를 자동차 출력 함수로 전달
            new CarNamesOutput(result, carNames).carOutput();
        }
        return result;
    }
}
