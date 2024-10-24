
# 프리코스 2주차 미션 - 자동차 경주
### TDD(Test-Driven-Develop) 사용해보기🧪

#### 키워드
1. 테스트 코드를 단위마다 상세히 작성할 것
2. MVC구조 활용해보기
3. 일급 컬렉션 활용해보기

- **1.** ✅ View 구조 생성 + 테스트 -> 적용
- **2.** ✅ Model 구조 생성 + 테스트 -> 적용
- **3.** ✅ Controller 구조 생성 + 테스트 -> 적용

```
├── main
│   └── java
│       └── racingcar
│           ├── Application.java
│           ├── common
│           │   ├── constant
│           │   │   ├── BusinessConst.java
│           │   │   ├── InputViewConst.java
│           │   │   └── OutputViewConst.java
│           │   ├── exception
│           │   │   ├── ErrorCode.java
│           │   │   └── GameException.java
│           │   └── factory
│           │       └── GameFactory.java
│           ├── controller
│           │   └── GameController.java
│           ├── model
│           │   ├── domain
│           │   │   ├── Car.java
│           │   │   └── CarList.java
│           │   ├── dto
│           │   │   ├── GameResult.java
│           │   │   ├── RoundResult.java
│           │   │   └── UserDto.java
│           │   └── service
│           │       └── CarRacingGame.java
│           └── view
│               ├── InputView.java
│               └── OutputView.java
└── test
    └── java
        ├── racingcar
        │   ├── ApplicationTest.java
        │   ├── controller
        │   │   └── GameControllerTest.java
        │   ├── model
        │   │   ├── domain
        │   │   │   ├── CarListTest.java
        │   │   │   └── CarTest.java
        │   │   ├── dto
        │   │   │   └── UserDtoTest.java
        │   │   └── service
        │   │       └── CarRacingGameTest.java
        │   └── view
        │       ├── InputViewTest.java
        │       └── OutputViewTest.java
        └── setup
            ├── TestCar.java
            └── TestCarList.java
```

# 단위 테스트
![](https://velog.velcdn.com/images/sity51/post/42c2976f-baac-4ae8-b09c-39ad9da02c9a/image.png)
