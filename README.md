# Java-racingcar-precourse


> [!NOTE]    
> 사용자가 정한 n대의 자동차가 경주를 할 것이다.
각 자동차는 0~9까지 있는 주사위를 던져 4이상이 나오면 앞으로 한칸 전진할 수 있다.
주사위를 던지는 횟수는 사용자가 정해줄 것이다.
정해진 횟수동안 가장 멀리간 자동차가 우승한다.

<br><br>

## 파일구조

```
.
.
.
└── racingcar
    │
    │
    ├── controller/
    │   └── RacingGameController
    │
    ├── model/
    │   ├── CarDto
    │   ├── CarService
    │   ├── InputDto
    │   ├── InputService
    │   └── RacingGameService
    │
    └── view/
    │   ├── InputView
    │    └── OutputView
    │
    └── Application
    
```

<br><br>
## 기능
  
### :large_blue_circle: View

<details open>

<summary><code>InputView</code></summary>

- 사용자에게 자동차 이름을 작성하라고 출력
- 사용자에게 게임 횟수를 입력하라고 출력

</details>

<details open>

<summary><code>OutputView</code></summary>

- 게임 진행 결과를 출력한다
- 우승자를 출력한다.

</details>

<br>

### :large_blue_circle: Model


<details open>

<summary><code>InputService</code></summary>

- 자동차 이름 검증
- 게임 횟수 제한

</details>

<details open>

<summary><code>CarDto</code></summary>

- 자동차 정의

</details>

<details open>

<summary><code>CarService</code></summary>

- 자동차 이동 기능
- 자동차 이름 개수만큼 인스턴스 생성

</details>


<details open>

<summary><code>RacingGameService</code></summary>

- 0 ~ 9 랜덤값 생성
- 랜덤값에 따라 자동차 전진
- 우승자 구하기

</details>

<br>

### :large_blue_circle: Controller

<details open>

<summary><code>RacingGameController</code></summary>

- 입력 - 검증 - 게임플레이 - 출력 순 실행 메서드 생성

</details>

<br>


<br><br>

## 이슈

### :heavy_check_mark: 같은 이름이 들어올 경우

>이름이 같은 경우는 많다. 이름이 겹칠 경우 어떻게 처리할 것 인가?

- 차에 고유번호를 지정하여 분류한다. (carId)
- 같은 이름은 입력할 수 없다고 다시 입력하라 한다.
- 예외처리 한다.


<br>


### :heavy_check_mark: 자동차 이름 검증

> 이름을 적지 않거나 하나만 들어 온다면?

#####
- 이름을 두명 이상 입력해달라는 메세지를 전달한 후, 다시 콘솔입력을 받는다.
- 임의로 car1을 생성해서 게임을 돌려주거나 두 명 이상의 이름을 입력해달라고 메세지를 전달후 콘솔입력을 받는다.
- 둘다 예외처리한다  
 &nbsp;
>,, 이와 같이 콤마가 들어오면?  

- 콤마를 기준으로 나눈뒤 임의의 car1,car2,car3을 생성한다.
- 예외처리한다.


<br>


### :heavy_check_mark: 게임 횟수 돌리기

 > 너무 많은 횟수를 돌려 오버플로우가 일어나면? 

- 오버플로우 뿐만 아니라 메모리 부족, CPU 과부하, 응답 지연, 스택 오버플로우와 같은 다양한 성능 문제와 자원 문제들이 발생할 수 있으니, 게임을 돌리는 최대 횟수 제한을 둔다.(1 ~ 5000회)













