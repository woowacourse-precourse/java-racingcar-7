# java-racingcar-precourse

# 🔢자동차 게임

<br/>

## 🔍기본 과제 요약

1. 사용자로부터 자동차 이름들(쉼표 구분)과 시도 횟수를 입력받아 유효성을 검증합니다.
2. 입력받은 횟수만큼 각 자동차들이 랜덤값(0-9)을 받아 4이상이면 전진합니다.
3. 매 회차마다 각 자동차의 이름과 위치(-) 출력합니다.
4. 모든 회차가 끝나면 가장 멀리 간 자동차를 우승자로 선정하여 출력합니다. (공동 우승 가능)
<br/>

## 🔧 미션 구현 방식
1. 입력값 검증
    - 자동차 이름 형식 검증 (쉼표 구분, 5자 이하)
    - 이름 중복 검증
    - 시도 횟수 유효성 검증 (양수)

2. 게임 진행
    - 자동차 객체 생성 및 초기화
    - 입력받은 횟수만큼 반복
    - 각 차수마다 자동차 이동 및 상태 출력

3. 결과 처리
    - 최대 이동 거리 계산
    - 우승자 선정 (공동 우승 가능)
    - 우승자 출력

<br/>

## 📂 파일 구조도
``` 
└─src
    ├─main
    │  └─java
    │      └─racingcar
    │          │  Application.java
    │          │
    │          ├─constants
    │          │      GameConstatns.java
    │          │      MessageConstants.java
    │          │
    │          ├─controller
    │          │      GameController.java
    │          │
    │          ├─exception
    │          │      ExceptionMessage.java
    │          │
    │          ├─model
    │          │  │  Game.java
    │          │  │
    │          │  └─component
    │          │          Car.java
    │          │
    │          ├─service
    │          │      SplitService.java
    │          │
    │          ├─valid
    │          │      NameValid.java
    │          │      NumberValid.java
    │          │
    │          └─view
    │                  InputView.java
    │                  OutputView.java
    │
    └─test
        └─java
            └─racingcar
                │  ApplicationTest.java
                │
                ├─modelTest
                │      GameTest.java
                │
                ├─serviceTest
                │      RandomTest.java
                │      SplitServiceTest.java
                │
                └─validTest
                        NameValidTest.java
                        NumberValidTest.java
```


## 📚 패키지 설명

1. **racingcar**: 메인 패키지
    - `Application.java`: 프로그램 시작점
   

2. **constants**: 상수 정의
    - `GameConstatns.java`: 게임 규칙 관련 상수 (이름 길이, 시도 횟수 등)
    - `MessageConstants.java`: 입출력 메시지 상수
   

3. **controller**: 게임 진행 제어
    - `GameController.java`: 전체 게임 진행 제어 및 흐름 관리
   

4. **exception**: 예외 처리
    - `ExceptionMessage.java`: 예외 메시지 상수 정의
   

5. **model**: 데이터 모델
    - `Car.java`: 자동차 정보 및 동작 관리
    - `Game.java`: 게임 상태 및 우승자 관리
   

6. **service**: 비즈니스 로직
    - `SplitService.java`: 입력 문자열 분리 및 처리
   

7. **valid**: 유효성 검증
    - `NameValid.java`: 자동차 이름 관련 검증
    - `NumberValid.java`: 시도 횟수 관련 검증
   

8. **view**: 사용자 인터페이스
    - `InputView.java`: 사용자 입력 처리
    - `OutputView.java`: 게임 상태 및 결과 출력
   
<br/>


## 🧪 테스트 설명

1. **GameTest.java** : 게임 핵심 로직 테스트
    - 자동차 추가/이동 기능
    - 우승자 선정 로직 (단독/공동)
    - 게임 상태 관리 검증
   

2. **NameValidTest.java, NumberValidTest.java** : 유효성 검증 테스트
    - 입력값 형식 검증
    - 범위 검증
    - 예외 메시지 검증
   

3. **SplitServiceTest.java** : 문자열 처리 테스트
    - 이름 분리 기능
    - 입력 형식 검증
    - 중복 이름 검증
   

4. **RandomTest.java** : 랜덤 기능 테스트
    - 범위 내 난수 생성 검증
    - 전진 조건 검증
   

<br/>

# 🚨trouble shooting

## 💡 Immutability를 위한 설계 고민
- setter 사용시 외부에서 언제든 값을 변경할 수 있음
- 이는 객체의 불변성을 해치고 예측하기 어려운 버그 발생 가능성 증가

#### 해결 방법
```java
public class Game {
    private final int tryTimes;  // final 키워드로 불변성 보장

    public Game(int tryTimes) {
        this.tryTimes = tryTimes;  // 생성자에서 한 번만 초기화
    }
}
```
#### 장점
- 객체 생성 시점에만 값 설정 가능
- 이후 변경 시도 시 컴파일 에러
- 코드의 안정성과 예측 가능성 향상

<br/>

## 🤔 우승자 선정 로직 설계 고민

1. **정렬 후 최대값 선정**
- 장점: O(n log n)으로 더 빠른 성능
- 단점: 원본 데이터 순서 변경

2. **최대값 저장 후 탐색**
- 장점: 원본 데이터 순서 보존
- 단점: O(n)으로 추가 순회 필요


#### 해결 방법
- 데이터 무결성이 성능보다 중요
- 원본 데이터 순서 보존으로 유지보수성 향상
- 향후 확장성을 고려한 설계

```java
public class Game {
    private int maxPosition;  // 최대값 저장

    public void moveCars() {
        for (Car car : cars) {
            car.move();
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
    }
}
```
<br/>

## 🔄 반복문 구현 방식 고찰

- 다양한 반복문 문법(foreach, 람다, stream) 중 최적의 방식 선택
- 현대적 프로그래밍 스타일과 실용성 사이의 균형점 고려

#### forEach (선택)
```java
for (Car car : cars) {
        car.move();
}
```
#### 장점
- 디버깅 용이성
- 명확한 의도 표현

#### 람다/스트림
```java
cars.forEach(Car::move);
```
- 함수형 프로그래밍 스타일의 간결한 표현
- 데이터 변환, 필터링 등 중간 연산 용이


#### 결론
- 단순 반복 작업에는 가독성과 유지보수성이 높은 기본 foreach 선택

<br/>

# 주요 구현 내용

### ✅ 유효성 검사

```java
    public static void checkName(String name){
    if(!name.matches(GameConstatns.CAR_NAME_REGEX)){
        throw new IllegalArgumentException(ExceptionMessage.INVALID_NAME_CHARACTER);
    }
    if(name.length() < GameConstatns.NAME_LENGTH_MIN){
        throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_UNDER);
    }
    if(name.length() > GameConstatns.NAME_LENGTH_MAX){
        throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_OVER);
    }
}
```

### ⚠️예외 메시지

- 예외 메시지는 `ExceiptionMessage` 클래스에서 관리


### 🔄 DI - singleton
- 주요 service 클래스와 controller 클래스에 싱글톤 패턴 적용

```java
    private static SplitService instance;

private SplitService() {
}

public static SplitService getInstance() {
    if (instance == null) {
        instance = new SplitService();
    }
    return instance;
}
```
