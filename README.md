## 🚀 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 1. :blue_car: 자동차 이름 입력
* 자동차 이름은 ,를 기준으로 구분한다.(앞뒤 공백 가능)
* 이름이 5자 초과면, `IllegalArgumentException`
* 비어있으면, `IllegalArgumentException`
* null이면, `IllegalArgumentException`
* 공백으로만 이루어져있으면, `IllegalArgumentException`

## 2. 🔢 시도 횟수 입력
* 비어있으면, `IllegalArgumentException`
* null이면, `IllegalArgumentException`
* 숫자가 아니면, `IllegalArgumentException`
* 음수면, `IllegalArgumentException`

## 3. :arrow_right: 전진
* random >= 4 일 때 전진한다.
  * Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  * 0~9 사이의 무작위 값을 구한다.
  * 무작위 값이 4보다 크면 해당 차를 전진시킨다.
  * 위 과정을 자동차 갯수만큼 반복한다.
  * 자동차 별로 전진 현황을 출력한다.
  * 위 과정을 사용자가 입력한 횟수만큼 반복한다.

## :trophy: 우승
* 제일 많이 전진한 우승자의 자동차 이름을 출력한다.
  * 제일 많이 전진한 자동차를 찾는다.
  * 우승자는 여러 명일 수 있다.
  * 전부 0회 전진했다면? 모두가 우승자가 된다.
