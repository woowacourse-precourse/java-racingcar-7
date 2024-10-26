package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class RacingCar {
    private String name;
    private int moves;

    public RacingCar(String name) {
        this.name = name;
        this.moves = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoves() {
        return moves;
    }

    public void addMoves() {
        moves++;
    }

    public void moveRandomly() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            addMoves();
        }
    }
}

public class Application {
    public static void main(String[] args) {
        String[] carNames = getNameOfCars();
        RacingCar[] racingCars = createCars(carNames);

        int numberOfTry = getNumberOfTry();

        runGame(racingCars, numberOfTry);
        printFinalWinner(racingCars);
    }

    private static String[] getNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputSequence = Console.readLine();

        String[] carNames = inputSequence.split(",");

        isInputValid(carNames);
        return carNames;
    }

    private static void isInputValid(String[] carNames) {
        for (String carName: carNames) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("입력이 없습니다.");
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요. => " + carName);
            }
        }
    }
    
    private static RacingCar[] createCars(String[] carNames) {
        int numberOfRacingCars = carNames.length;
        RacingCar[] racingCars = new RacingCar[numberOfRacingCars];

        for (int i = 0; i < numberOfRacingCars; i++) {
            racingCars[i] = new RacingCar(carNames[i]);
        }
        return racingCars;
    }

    private static int getNumberOfTry() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfTry = 0;
        try {
            numberOfTry = Integer.parseInt(Console.readLine());
            if (numberOfTry < 1) {
                throw new IllegalArgumentException("양수를 입력해주세요.");
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
        return numberOfTry;
    }

    private static void runGame(RacingCar[] racingCars, int numberOfTry) {
        System.out.println("");
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTry; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.moveRandomly();
            }
            printResult(racingCars);
            System.out.println("");
        }
    }

    private static void printResult(RacingCar[] racingCars) {
        for (RacingCar racingCar : racingCars) {
            // Express moves to dash
            StringBuilder printDashes = new StringBuilder();
            for (int i = 0; i < racingCar.getMoves(); i++) {
                printDashes.append('-');
            }

            String printEachCars = racingCar.getName() + " : " + printDashes.toString();
            System.out.println(printEachCars);
        }
    }

    private static void printFinalWinner(RacingCar[] racingCars) {
        // Find Max Moves
        int maxMoves = findMaxMoves(racingCars);
        
        // Build Strings
        StringBuilder finalWinner = new StringBuilder();
        finalWinner.append("최종 우승자 : ");
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getMoves() == maxMoves) {
                finalWinner.append(racingCar.getName());
                finalWinner.append(", ");
            }
        }
            // Cut off the last ", "
        int lengthOfFinalWinner = finalWinner.length();
        finalWinner.delete(lengthOfFinalWinner - 2, lengthOfFinalWinner);

        System.out.println(finalWinner);
    }

    private static int findMaxMoves(RacingCar[] racingCars) {
        int maxMoves = 0;
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getMoves() > maxMoves) {
                maxMoves = racingCar.getMoves();
            }
        }
        return maxMoves;
    }
}
