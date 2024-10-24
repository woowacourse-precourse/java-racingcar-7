# java-racingcar-precourse
# 🕹️기능요구사항
***
- (view) 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- (view) 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- (view) 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- (view) 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

- (service) 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- (service) 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- (service) 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

- (parsing) 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

# 🛠️구현 단계
1. 입력과 출력하는 뷰
   - ,을 구분자로 하여 이름 추출
   - 이름 List<String>를 반환
3. 랜덤으로 수를 만드는 로직
4. 자동차 클래스
   - 필드로 `현재 위치`, `자동차 이름`를 포함
   - 랜덤으로 값을 생성한 후, 4이상일 경우 이동
5. 자동차들을 가지는 일급 컬렉션
   - 가장 많이 이동한 자동차의 위치를 반환하는 메서드
   - 가장 많이 이동한 자동차를 찾는 메서드
6. 자동차 매퍼 클래스
   - 넘겨받은 이름 List를 CarName으로, CarName으로 Car를, Car로 CarRace 생성
8. 서비스를 호출할 controller

## 예외처리
1. 자동차 이름이 5자 초과인 경우
2. 자동차 이름이 empty이거나 blank인 경우
3. 이동 횟수가 양수가 아닌 경우
4. 자동차의 랜덤 수가 범위를 벗어나는 경우


# 고민한 부분
## 입력에 대한 validation은 어디서 진행되어야 하는가?

Car의 name에 관한 유효성 검사는 어디서 진행해야할까?
<br/>
먼저 Car에서 name의 유효성 검사를 진행하면 어떨까?
> Model과 Domain은 자체적인 Validation을 통해 자체 무결성을 유지해야한다.

자체 무결성을 확보하기 위해 Car 객체에서 Name에 관한 유효성 검사는 타당해보인다. 그러나 고민해볼 부분이 있다.
만약 name 뿐만 아니라 여러 유효성 검사가 필요할 경우, Car는 많은 책임을 짊어지게 된다.
```java
public Car(String name) {
    validateA();
    validateB();
    // ...
    validateName(name);
}
```
책임을 분리하여 Car 객체에 대한 부담을 줄이는 방향으로 나아가야 할 것이다.
fail-fast와 fail-safe에 대해 생각해보는 것도 좋을 것 같다.
> fail-fast : 동작중 오류가 발생하면 바로 오류를 알리고 작업을 중단
> <br/>
> fail-safe : 동작중 오류가 발생해도 작업을 중단하지 않고 진행

### Fali-Fast
Controller와 View에서의 파싱은 fail-fast에 해당할 것이다. View에서 유효성검사의 단점을 생각해보자.
Input에서 유효성 검사 시, SOC에 위배된다. View는 유저 인터페이스에 불과하기 때문에 유효성 검사는 비즈니스 로직에 더 알맞다는 생각이 든다.
또한, View에서 유효성 검사 시 테스트 코드 작성에 어려움이 있다. 무조건 View을 통해 테스트를 진행해야 하므로 비즈니스 로직 테스트에 집중하기 힘들다.
그렇다면 Controller에서 유효성 검사느 어떨까? 컨트롤러는 요청을 처리하여 Model과 View의 전달하는 역할을 수행한다.
view에서의 입력을 제일 먼저 전달받는다. 유효성 검사를 통과하지 못할 경우, 프로그램은 자동으로 종료되기 때문에 Controller에서 제일 먼저 유효성 검사하는 것은 타당해보인다.

### 이름 클래스?
Car에게 부담을 덜면서 객체지향적으로 설계를 하기 위해서 이름 클래스를 따로 설계하는 것도 좋을 것 같다고 생각했다.
유효성 검사만을 담당하는 클래스를 만드는 것보다 CarName이라는 클래스에서 유효성 검사와 이름 필드를 가지고 있는 것이 좋겠다고 생각했다.
만약 Car을 상속받는 SpeedCar가 있을 경우, Car의 유효성 검사를 오버라이딩하게 되면 일관성이 깨질 수 있다.
```java
class Car {
   protected void validateNameLength(String name) {
      if (name.length() > CAR_NAME_LENGTH_MAX) {
         throw new IllegalArgumentException();
      }
   }
}
class SpeedCar extends Car { 
    
    @Override
    protected void validateNameLength(String name) {
      if (name.length() > CAR_NAME_LENGTH_MAX) {
         throw new IllegalArgumentException();
      }
   }
}
```
따라서, 이름 클래스를 통해 이런 일관성을 유지할 수 있고, 추후 다양한 Validation 추가 또한 가능하기 때문에 매우 유용하다.

## 빈약한 도메인 모델
현재 CarRace에서 List<Car>를 가지고 있고, getter 밖에 수행하지 않고 있다. 여기서 우승자를 찾는 기능을 Service에 작성할 경우 빈약한 도메인 모델이 될 것 같았다.
```java
public class CarRace {

    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
```
따라서, 우승자를 찾는 로직을 CarRace 내부에 설계하여 이런 문제를 해결하려고 했다.

## 입력값을 어디서 객체로 가공할 것인가?
