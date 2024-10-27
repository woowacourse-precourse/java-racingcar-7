package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int user_amount = 0;

        String[] user_names = getCarName();
        int try_number = getTryNumber();
        int user_nums = user_names.length;

        Car[] cars = new Car[user_nums];
        for(int i = 0; i < user_nums; i++){
            cars[i] = new Car(user_names[i], 0);
        }

        System.out.println("\n실행 결과");
        startRace(cars, try_number);

    }

    private static String[] getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");

        String user_input = Console.readLine();
        String[] user_names = validateCarName(user_input);

        return user_names;
    }

    private static String[] validateCarName(String user_input){
        if(user_input.startsWith(",")){
            throw new IllegalArgumentException("The car name can't be blank. Fill in the blank with car name.");
        }
        if(user_input.endsWith(",")){
            throw new IllegalArgumentException("The car name can't be blank. Fill in the blank with car name.");
        }

        String[] user_names = user_input.split(",");

        for(String name : user_names){
            validateCarNameIsEmpty(name);
            validateCarNameHasSpace(name);
            validateCarNameHasSpecial(name);
            validateCarNameLength(name);
        }

        return user_names;
    }

    private static void validateCarNameIsEmpty(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("The car name can't be blank. Fill in the blank with car name.");
        }
    }

    private static void validateCarNameHasSpace(String name){
        if(name.contains(" ")){
            throw new IllegalArgumentException("The car name can't contain blanks.");
        }
    }

    private static void validateCarNameHasSpecial(String name){
        String specialChar = "!@#$%^&*()_+={}[]|:;\"'<>,.?/~`\\";
        for(char ch : specialChar.toCharArray()){
            if(name.contains(Character.toString(ch))){
                throw new IllegalArgumentException("The car name can't contain special characters.");
            }
        }
    }

    private static void validateCarNameLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("The car name's length should be below 5");
        }
    }

    private static int getTryNumber(){
        System.out.println("시도할 횟수는 몇 회 인가요?");

        String try_input = Console.readLine();
        int try_number = parseTryNumber(try_input);
        validateTryNumber(try_number);

        return try_number;

    }

    private static int parseTryNumber(String input){
        try{
            return Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("The number of attempts should be positive integer.");
        }
    }

    private static void validateTryNumber(int try_number){
        if(try_number <= 0){
            throw new IllegalArgumentException("The number of attempts should be positive integer.");
        }
    }

    private static void printEachRace(Car[] cars){
        for(Car car : cars){
            car.go();
            System.out.print(car.getName() + " : ");
            car.printLocation();
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private static void startRace(Car[] cars, int try_number){
        for(int i = 0; i < try_number; i++){
            printEachRace(cars);
        }
        String winner = getWinner(cars);
        System.out.println("최종 우승자 : " + winner);
    }

    private static String getWinner(Car[] cars){
        int max = 0;
        List<String> winners = new ArrayList<>();
        String winner = "";

        for(Car car : cars){
            winners.add(car.getName());
        }

        for(Car car : cars){
            if(car.getLocation() > max){
                max = car.getLocation();
                winner = car.getName();
            }
            else if(car.getLocation() == max && max != 0){
                winner = winner + ", " + car.getName();
            }
        }

        if(winner.isEmpty()) {
            winner = String.join(", ", winners);
        }

        return winner;
    }
}
