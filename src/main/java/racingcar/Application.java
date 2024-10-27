package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final String START_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_TIME_TEXT = "시도할 횟수는 몇 회인가요?";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_CAR_COUNT = 10;
    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_GAME_COUNT = 10;

    private static String getInput(){
        String inputString = Console.readLine();
        return inputString;
    }

    private static ArrayList<String> splitCarNames(String input){
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",",0)));
        return carNames;
    }

    private static String isEnglishOnlyName(String carName){
        if(!Pattern.matches("[a-zA-Z]+", carName)){
            throw new IllegalArgumentException("자동차 이름은 알파벳으로만 구성되어야 합니다.");
        }
        return carName.toLowerCase();
    }

    private static void isValidlengthName(String carName){
        if (carName.length() > MAX_CAR_NAME_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private static void validCarNames(ArrayList<String> carNames){
        for(int i=0; i<carNames.size(); i++){
            carNames.set(i,isEnglishOnlyName(carNames.get(i)));
            isValidlengthName(carNames.get(i));
        }
    }

    private static void validCarCount(ArrayList<String> carNames){
        if ((carNames.size() < MIN_CAR_COUNT) || (carNames.size() > MAX_CAR_COUNT)){
            throw new IllegalArgumentException("자동차 대수는 2대 이상 10대 이하여야 합니다.");
        }
    }

    private static Car[] checkDuplicateName(ArrayList<String> carNames){
        ArrayList<Car> carList = new ArrayList<>();
        for(String carName:carNames){
            if(!carList.contains(carName)){
                carList.add(new Car(carName));
            }
        }

        if (carList.size() != carNames.size()){
            throw new IllegalArgumentException("중복된 자동차 이름은 사용할 수 없습니다.(대문자와 소문자는 동일하게 인식됩니다.)");
        }

        Car[] cars = new Car[carList.size()];
        carList.toArray(cars);
        return cars;
    }

    private static Car[] getCarNames(){
        System.out.println(START_TEXT);
        String inputString = getInput();
        ArrayList<String> carNames = splitCarNames(inputString);
        validCarCount(carNames);
        validCarNames(carNames);
        Car[] cars = checkDuplicateName(carNames);
        return cars;
    }

    private static void isValidTimes(final int times){
        if ((times < 1) || (times > MAX_GAME_COUNT)){
            throw new IllegalArgumentException("최대 게임 횟수는 10번입니다.");
        }
    }

    private static int getGameTimes(){
        System.out.println(GAME_TIME_TEXT);
        final int GAME_TIMES;
        String timesString = getInput();
        try{
            GAME_TIMES = Integer.parseInt(timesString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 횟수로는 숫자만 입력할 수 있습니다.");
        }
        isValidTimes(GAME_TIMES);
        return GAME_TIMES;
    }

    private static ArrayList<Integer> getRandomNumbers(int carNumbers){
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for(int i=0; i<carNumbers; i++){
            randomNumbers.add(Randoms.pickNumberInRange(0,9));
        }
        return randomNumbers;
    }

    private static void printResult(Car curCar, String carName){
        int curCarLocation = curCar.currentLocation;
        System.out.print(carName + " : ");
        for(int count = 0; count < curCarLocation; count++){
            System.out.print("-");
        }
        System.out.println();
    }

    private static void updateResult(Car[] cars, ArrayList<Integer> randomNumbers){
        for(int carIndex = 0; carIndex < cars.length; carIndex++){
            String curCarName = cars[carIndex].name;

            if(randomNumbers.get(carIndex) > 3){
                cars[carIndex].move();
            }
            printResult(cars[carIndex], curCarName);
        }
        System.out.println();
    }

    private static List<String> findWinner(Car[] cars){
        List<String> winnerList = new ArrayList<>();
        int maxLocationNum = cars[0].currentLocation;
        winnerList.add(cars[0].name);

        for(int i =1; i<cars.length; i++){
            Car curCar = cars[i];
            if (curCar.currentLocation > maxLocationNum){
                maxLocationNum = curCar.currentLocation;
                winnerList.clear();
                winnerList.add(curCar.name);
                continue;
            }
            if(curCar.currentLocation == maxLocationNum){
                winnerList.add(curCar.name);
            }
        }
        return winnerList;
    }

    private static void printWinner(Car[] cars){
        System.out.print("최종 우승자 : " );
        List<String> winnerList = findWinner(cars);
        for(int i=0; i < winnerList.size(); i++){
            System.out.print(winnerList.get(i));
            if(i != winnerList.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static void playGame(Car[] cars, int times){
        ArrayList<Integer> randomNumbers;
        for(int i=0; i<times; i++){
            randomNumbers = getRandomNumbers(cars.length);
            updateResult(cars, randomNumbers);
        }
        printWinner(cars);
    }

    public static void main(String[] args) {
        Car[] cars = getCarNames();
        int gameTimes = getGameTimes();
        playGame(cars, gameTimes);
    }
}
