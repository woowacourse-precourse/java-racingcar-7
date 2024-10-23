package racingcar;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static car[] list;
    public static String[] member = {};
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application ap = new Application();
        ap.start(ap);
    }
    
    public void start(Application ap) {
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try{
            member = Console.readLine().split(",");
        }catch (IllegalArgumentException e){
            System.out.print("invaild error");
        }
        ap.mem_trim();
        list = ap.initial(member);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int try_count = 0;

        try{
            try_count = Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.print("invaild error");
        }

        System.out.println();
        System.out.println("실행 결과");
        for(int i = 0; i < try_count; i++){
            ap.r_print(ap);
        }
     
        ap.result_print(ap.winner_score());
    }
    
    public void mem_trim() {
        for(String str : member) {
            if(str.trim().isEmpty()) {
                throw new IllegalArgumentException("invaild error");
            }
        }
    }
    
    public void r_print(Application ap){
        ap.add();
        ap.print_result();
        System.out.println();
    }
    
    public void result_print(int max){
        System.out.print("최종 우승자 : ");
        boolean check = true;
        for(car i : list) {
        	int len = i.car_count.length();
            if(len == max && check){
                System.out.print(i.getCar_name());
                check = false;
            }else if(len == max) {
                System.out.print(","+i.getCar_name());
            }
        }
    }

    public void add(){
        for(int i = 0; i < list.length; i++){
            int random = Randoms.pickNumberInRange(0,9);
            if(random >= 4){
                list[i] = new car(list[i].getCar_name(),true,list[i].getCar_count());
            }else{
                list[i] = new car(list[i].getCar_name(),false,list[i].getCar_count());
            }
        }
    }

    public int winner_score(){
        int max = 0;
        for(car strb : list){
            int len = strb.car_count.length();
            if(max < len){
                max = len;
            }
        }
        return max;
    }

    public void print_result(){
    	for(car i : list) {
    		System.out.println(i.getCar_name()+" : "+i.getCar_count());
    	}
    }

    public car [] initial(String [] member){
        car list[] = new car[member.length];
        for(int i = 0; i < list.length; i++){
            list[i] = new car(member[i],false, new StringBuffer(""));
        }
        return list;
    }
}

class car{
    public String getCar_name() {
		return car_name;
	}
	public StringBuffer getCar_count() {
		return car_count;
	}
	String car_name;
    StringBuffer car_count = new StringBuffer();
    public car(String car_name, boolean go, StringBuffer prev_count){
        this.car_name = car_name;
        if(go){
            car_count.append(prev_count).append("-");
        }else{
            car_count.append(prev_count);
        }
    }

}