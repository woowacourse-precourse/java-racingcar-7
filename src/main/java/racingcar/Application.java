package racingcar;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static Car[] list;
    public static String[] member = {};
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application ap = new Application();
        ap.start(ap);
    }
    public void start(Application ap) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        check(input);
        member = input.split(",");
        ap.mem_trim();
        list = ap.initial(member);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int try_count = 0;
        try{
            try_count = Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.print("invalid error");
        }
        System.out.println("\n실행 결과");
        for(int i = 0; i < try_count; i++){
            ap.add();
            ap.print_result();
        }
        ap.print_winner(ap.winner_score());
    }

    public void check(String input){
        if(input.endsWith(",")) {
            throw new IllegalArgumentException("invalid error");
        }
    }
    public void mem_trim() {
        for(String str : member) {
            if(str.trim().isEmpty()) {
                throw new IllegalArgumentException("invalid error");
            }
        }
    }
    public void print_result(){
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i].racer_name+" : "+list[i].racer_point);
        }
        System.out.println();
    }
    public void print_winner(int max){
        System.out.print("최종 우승자 : ");
        boolean check = true;
        for(int i = 0; i < list.length; i++){
            int len = list[i].racer_point.length();
            if(len == max && check){
                System.out.print(list[i].racer_name);
                check = false;
            }else if(len == max) {
                System.out.print(", "+list[i].racer_name);
            }
        }
    }

    public void add(){
        for(int i = 0; i < list.length; i++){
            int random = Randoms.pickNumberInRange(0,9);
            list[i] = new Car(list[i].getRacer_name(),random >= 4,list[i].getRacer_point());
        }
    }

    public int winner_score(){
        int max = 0;
        for(Car strb : list){
            int len = strb.racer_point.length();
            if(max < len){
                max = len;
            }
        }
        return max;
    }

    public Car [] initial(String [] member){
        Car list[] = new Car[member.length];
        for(int i = 0; i < list.length; i++){
            list[i] = new Car(member[i],false, new StringBuffer(""));
        }
        return list;
    }
}

class Car{
    public String getRacer_name() {
        return racer_name;
    }
    public StringBuffer getRacer_point() {
        return racer_point;
    }
    String racer_name;
    StringBuffer racer_point;
    public Car(String racer_name, boolean go, StringBuffer prev_point){
        this.racer_name = racer_name;
        this.racer_point = new StringBuffer(prev_point);
        if(go){
            racer_point.append("-");
        }
    }
}