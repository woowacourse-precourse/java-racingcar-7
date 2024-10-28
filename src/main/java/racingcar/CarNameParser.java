package racingcar;

import java.util.Vector;

public class CarNameParser {

    private String carName;
    private String output=" ";
    CarNameParser(String carName){
        this.carName = carName;
    }
   public Vector<Pair> Parser(){
        Vector<Pair> v = new Vector<>();
         int count=0;
        for(int i=0;i<carName.length();i++){

            if(carName.charAt(i)==',' && count < 6){
                v.add(new Pair(0,output.trim()));
                output=" ";
                count=0;
            }
            else if(count>=6){
                throw new IllegalArgumentException();
            }

            else if(i==carName.length()-1&&count==5){
                throw new IllegalArgumentException();
            }

            else if(carName.charAt(i)==' '){
                throw new IllegalArgumentException();
            }

            else if(i==carName.length()-1){
                output+=carName.charAt(i);
                v.add(new Pair(0,output.trim()));
            }

            else{
                count++;
                output+=carName.charAt(i);
            }

        }
        return v;
   }



}
