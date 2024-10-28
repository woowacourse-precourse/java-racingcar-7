package racingcar.IO;

public class CarNamesOutput {
    int[] isMovable;
    String[]carNames;

    public CarNamesOutput(int[]isMovable, String[]carNames){
        this.isMovable = isMovable;
        this.carNames = carNames;
    }

    public void carOutput(){
        for(int i =0; i< carNames.length; i++){
            System.out.print(carNames[i] + " : ");
            if(0<isMovable[i]){
                System.out.println("-".repeat(isMovable[i]));
                continue;
            }
            System.out.println();
        }
        System.out.println();
    }
}
