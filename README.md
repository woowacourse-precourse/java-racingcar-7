# java-racingcar-precourse
----------

### 1. 기능 요구 사항
* 자동차 이름 부여
    - 사용자는 자동차의 이름을 쉼표(,)로 구분하여 입력할 수 있다.
    - 자동차 이름은 5자 이하만 가능하다.

* 이동 횟수 입력
    - 사용자는 자동차가 이동할 횟수를 입력할 수 있어야 한다.

* 전진 조건
    - 각 자동차는 0에서 9 사이의 무작위 값을 생성한다.
    - 생성된 값이 4 이상인 경우에만 자동차가 전진한다.

* 자동차 전진 출력
    - 레이스를 진행할 때, 각 차수별로 전진하는 자동차의 이름과 함께 전진 횟수를 '-' 기호로 표시하여 출력한다.

* 우승자 결정
    - 모든 차수가 완료된 후, 가장 많은 전진 횟수를 기록한 자동차를 우승자로 결정한다.
    - 우승자가 여러 명일 경우, 자동차 이름을 쉼표(,)로 구분하여 출력한다.


----------

### 2. 기능 구현 단위

* Domain : Car 클래스 구현
    - move(): 자동차를 전진시키는 메서드로, 전진할 때마다 카운트를 증가시킨다.
    - toString(): 자동차의 이름과 전진 횟수를 문자열로 반환한다.

* Repository : CarRepository 인터페이스 및 CarRepositoryImpl 구현
  - save(): 주어진 자동차 객체를 저장한다.
  - findByName(): 이름으로 자동차를 찾는다.
  - findAll(): 저장된 모든 자동차를 반환한다.

* Service : CarService 구현
  - joinCar(): 주어진 자동차를 등록한다.
  - validateDuplicateCar(): 주어진 자동차가 이미 저장된 자동차와 이름이 중복되는지를 확인한다.
  - moveCar() : 각 자동차의 전진 여부를 결정 후, 전진 횟수를 증가시킨다.
  - findWinners(): 전진횟수를 비교하여 우승자를 찾는다.

* Controller : CarController 구현
    

* View : Input 및 Output 구현
    

* Validator 클래스 구현
    

---------
### 3. 예외 처리

* 멤버가 중복인 경우  
  ``` ex) "pobi, pobi" -> IllegalArgumentException("중복된 회원 존재") ```
* 입력이 공백인 경우  
  ``` ex) "" -> IllegalArgumentException("빈 문자열") ```
* 입력의 마지막이 구분자(,)인 경우  
  ``` ex) "pobi,woni," -> IllegalArgumentException("마지막 입력이 구분자입니다.") ```
* 자동차 이름이 5글자를 초과하는 경우  
  ``` ex) "pobiwoni" -> IllegalArgumentException("이름은 5자 이하만 가능합니다.") ```
* 경기 횟수가 양수인 정수가 아닌 경우  
  ``` ex) "a", ";", "-1" -> IllegalArgumentException("경기 횟수는 양수로 입력되어야 합니다.") ```

---------
### 4. 수정사항

    