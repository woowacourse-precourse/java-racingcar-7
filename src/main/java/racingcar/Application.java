package racingcar;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        Validation validation = new Validation();

        String car = inputManager.inputCar();
        validation.carsValidation(car);

        String numberOfAttempts=inputManager.inputNumberOfAttempts();
        validation.attemptsValidation(numberOfAttempts);

        RandomNumberGenerator randomNumberGenerator =new RandomNumberGenerator();

        SplitString splitString = new SplitString();
        String[] commaSplitString = splitString.commaSplit(car);

        Conversion conversion = new Conversion();
        int numberOfAttempts_int = conversion.stringToInt(numberOfAttempts);

        RacingTrack racingTrack = new RacingTrack();
        racingTrack.setCarNumber(commaSplitString.length);
        racingTrack.startRacing();
        String[] currentTrack ;

        Comparison comparison = new Comparison();
        String trackCharacter;

        System.out.println("실행 결과");
        for(int i=0;i<numberOfAttempts_int;i++){
            for(int j=0;j<commaSplitString.length;j++){
                trackCharacter=comparison.intCompare(randomNumberGenerator.randomNumber(),4);
                racingTrack.moveCar(j,trackCharacter);
                currentTrack = racingTrack.getTrack();
                System.out.print(commaSplitString[j]+" : "+currentTrack[j]+"\n");
            }
            System.out.print("\n");
        }

        WinningIndex winningIndex = new WinningIndex();
        currentTrack = racingTrack.getTrack();
        int[] resultIndex = winningIndex.processingResult(currentTrack);
        String[] result = new String[resultIndex.length];

        for (int i = 0;i<resultIndex.length;i++){
            result[i]=commaSplitString[resultIndex[i]];
        }

        System.out.print("최종 우승자 : "+String.join(",", result));
    }
}
