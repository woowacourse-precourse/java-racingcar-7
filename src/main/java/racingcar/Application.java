package racingcar;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
            int max = -999,winner_cnt=0;
            ArrayList<String> winner = new ArrayList<>();
            Scanner sc = new Scanner(System.in);

            String[] cars = getCars();

            int attempts = getAttempts();

            int[] racing_num = new int[cars.length];

            //0~9 사이에 랜덤한 숫자 구하기
            Random random = new Random();   
    
            System.out.println("실행 결과");
            // 경주 하기
            for (int i=0; i<attempts; i++){
                for (int j=0; j<cars.length; j++){
                    int advance_number = random.nextInt(10);
                    if (advance_number > 4){
                        racing_num[j] += 1;
                    }
                }
                for (int j=0; j<cars.length; j++){
                    System.out.print(cars[j] + " : ");
                    for (int k=0; k<racing_num[j]; k++){
                        System.out.print("-");
                    }
                    System.out.println();
                }
                System.out.println();
            }

            // 최대값 구하기
            for (int i=0; i<cars.length; i++){
                if (racing_num[i] > max){
                    max = racing_num[i];
                }
            }   
            // 최종 우승자 선정하기
            for (int i=0; i<cars.length; i++){
                if (racing_num[i] == max){
                    winner.add(cars[i]);
                    winner_cnt += 1;
                }
            }

            // 최종 우승자 출력하기
            String winner_str = String.join(", ", winner);
            System.out.println("최중 우승자 : " + winner_str);
            
    }   
    // 자동차 이름 입력받기
    private static String[] getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner sc = new Scanner(System.in);
        String[] cars = sc.nextLine().split(",");
        validateCarNames(cars);
        return cars;
    }

    // 자동차 이름 유효성 검사
    private static void validateCarNames(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5 || car.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 설정해야 합니다.");
            }
        }
    }

     // 이동 횟수 입력받기
     private static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner sc = new Scanner(System.in);
        int attempts = sc.nextInt();
        if (attempts <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
        return attempts;
    }
}
