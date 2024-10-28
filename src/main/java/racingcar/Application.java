package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {
	
	private static final int MOVE_THRESHOLD = 4;
	private static final int MAX_NAME_LENGTH = 5;
    public static void main(String[] args) {
    	String[] carName = inputCarNames();
    	int moveSet =  inputMoveSet();
    	List<Car> cars = createCar(carName);
    	game(cars, moveSet);
    	printWinners(cars);
    }
 
    public static String[] inputCarNames() {
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
    	String inputNames = Console.readLine();
    	return validateCarNames(inputNames);
    }
    
    public static String[] validateCarNames(String inputNames) {
    	String[] carNames = inputNames.split(",");
    	carNamesData(carNames);
    	return carNames;
    }
    
    public static void carNamesData(String[] carNames) {
    	for (String name : carNames) {
    		lengthCheck(name);
    	}
    }
    public static void lengthCheck(String name) {
    	if (name.length() > MAX_NAME_LENGTH) 
    		throw new IllegalArgumentException();
    	
    }
    public static int inputMoveSet() {
    	System.out.println("시도할 횟수는 몇 회인가요?: ");
    	String input = Console.readLine();
  
    	return checkMoveSet(input);
    }
    	
    public static int checkMoveSet(String input) {
    	try {
    		int moveSet = Integer.parseInt(input);
    		validateMoveSet(moveSet);
    		return moveSet;
    	} catch (NumberFormatException e) {
    		throw new IllegalArgumentException();
    	}
    	
    }
    
    public static void validateMoveSet(int moveSet) {
    	if (moveSet <= 0) {
    		throw new IllegalArgumentException();
    	}
    }
 
    public static List<Car> createCar(String[] carNames) {
    	List<Car> cars = new ArrayList<>();
    	for (String name : carNames) {
    		cars.add(new Car(name));
    	}
    	    return cars;
    }
    
    public static void game(List<Car> cars, int moveCount) {
    	for(int i=0; i<moveCount;i++)
    		moveCars(cars);
    		carStatus(cars);
    }
    public static void moveCars(List<Car> cars) {
    	for (Car car : cars) {
    		car.move();
    	}
    }
    public static void printWinners(List<Car> cars) {
        List<Car> winners = getWinners(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winners.stream().map(Car::inputCarName).toArray(String[]::new)));
    }
    
    public static void carStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.inputCarName() + " : " + car.getDistanceRepresentation());
        }
    }
    
    public static List<Car> getWinners(List<Car> cars) {
    	int maxDistance = getMaxDistance(cars);
    	return findWinners(cars, maxDistance);
    }
    
    public static int getMaxDistance(List<Car> cars) {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(0);
    }
    
    public static List<Car> findWinners(List<Car> cars, int maxDistance) {
    	List<Car> winners = new ArrayList<>();
    	for (Car car : cars) {
    		if (car.getDistance() == maxDistance) {
    			winners.add(car);
    		}
    	}
    	return winners;
    }
    
    static class Car {
    	private final String name;
    	private int distance;
    	
    	Car(String name) {
    		this.name = name;
    		this.distance = 0;
    	}
    	
    	public String inputCarName() {
    		return name;
    	}
    	
    	public int getDistance() {
    		return distance;
    	}
    	
    	public void move() {
    		int randomValue = Randoms.pickNumberInRange(0,9);
    		if(randomValue >= MOVE_THRESHOLD) {
    			distance++;
    		}
    	}
    	
    	public String getDistanceRepresentation() {
    		return "-".repeat(distance);
    	}
    }    
}