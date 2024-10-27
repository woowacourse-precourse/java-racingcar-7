package racingcar.Input;

import java.util.Arrays;

public class NameInput {

  private String[] name;

  public boolean validateInput(String input) {
    return Arrays.stream(input.split(","))
        .map(String::trim)
        .allMatch(name -> name.length() <= 5);
  }

  public void getInput(String input){
    this.name = input.split(",");
  }


}
