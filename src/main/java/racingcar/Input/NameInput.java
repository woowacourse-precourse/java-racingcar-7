package racingcar.Input;

import java.util.Arrays;

public class NameInput {

  private String[] name;

  public NameInput() {
  }

  public boolean validateInput(String input) {
    return Arrays.stream(input.split(","))
        .map(String::trim)
        .allMatch(name -> name.length() <= 5);
  }

  public void setName(String input){
    this.name = input.split(",");
  }

  public String[] getName()
  {
    return name;
  }
}
