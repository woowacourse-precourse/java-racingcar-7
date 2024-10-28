#  🏎 Racing Car 🏎 

---

## 패키지 구조

<div align="center">
<table>
<tr>
<th align="center">Package</th>
<th align="center">Class</th>
<th align="center">Description</th>
</tr>

<tr>
<td><b>🕹&nbsp;&nbsp;controller</b></td>
<td><b>Racing</b></td>
<td> 레이싱 로직을 메인으로 동작하는 컨트롤러 클래스 </td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="3"><b>💻  domain</b></td>
<td><b>Car</b></td>
<td>움작이고 위치와 이름을 갖고 있는 개별 자동차 클래스</td>
</tr>

<tr>
<td><b>Cars</b></td>
<td> Car 객체를 멤버 변수로 갖는 일급 컬렉션 클래스 </td>
</tr>

<tr>
<td><b>MovementDecider</b></td>
<td> 자동차 움직임 조건을 생성 및 움직임을 결정하는 클래스 </td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="3"><b>✉️&nbsp;&nbsp;dto</b></td>
<td><b> CarPosition</b></td>
<td> 라운드 별 개별 자동차의 이름 및 위치 정보를 리턴하는 DTO 레코드</td>
</tr>

<tr>
<td><b> CarsPositions</b></td>
<td> 라운드 별 모든 자동차의 이름 및 위치 정보를 리턴하는 DTO 레코드 </td>
</tr>


<tr>
<td><b> Winners </b></td>
<td> 최종 승자에 대한 정보를 리턴하는 DTO 레코드</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="1"><b>🚫&nbsp;&nbsp;exception</b></td>
<td><b> ErrorMessage </b></td>
<td> 예외 발생 시 사용되는 에러 메세지 Enum 클래스</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="1"><b>✂️&nbsp;&nbsp;parser</b></td>
<td><b> Parser </b></td>
<td> Input을 Cars 객체 생성자 형식에 맞게 파싱하는 클래스</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="2"><b>🗓️&nbsp;&nbsp;validator</b></td>
<td><b> CarNamesValidator </b></td>
<td> 파싱된 carNames의 유효성을 검증하는 클래스  dto</td>
</tr>

<tr>
<td><b> TotalRoundsValidator </b></td>
<td> 입력한 시도할 횟수의 유효성을 검증하는 클래스 dto</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="2"><b>💬&nbsp;&nbsp;view</b></td>
<td><b> InputView </b></td>
<td> 사용자 요청을 처리하는 클래스 dto</td>
</tr>

<tr>
<td><b> OutputView </b></td>
<td> 사용자에게 응답을 출력하는 클래스 dto</td>
</tr>

<tr>
<td><b> ↘️ /constants</b></td>
<td><b>Notice</b></td>
<td> 사용자에게 출력시 사용되는 안내 메세지 Enum 클래스</td>
</tr>




</table>
</div>




---

## 애플리케이션 플로우 및 구현 기능


✅ **[Racing]: 사용자에게 자동차 이름을 입력받고 이를 통해 Cars 객체를 생성한다.**

- ☑️ [InputView] - 사용자에게 자동차 이름을 받는다.
- ☑️ [Parser] - 유효성 검증 및 객체 생성에 맞는 형식으로 입력값을 스트링 리스트로 파싱한다.
- ☑️ [CarNamesValidator] - 입력값에 대한 유효성 검증을 진행한다.
  - ✔️ 리스트가 비어있는 경우 오류를 던진다
  - ✔️ 자동차 이름 자체가 공백인 경우 오류를 던진다.
  - ✔️ 자동차 이름에 공백이 포함되는 경우 오류를 던진다
  - ✔️ 자동차 이름이 글자 길이 제한을 넘길 경우 오류를 던진다.
  - ✔️ 중복된 자동차 이름이 있는 경우 오류를 던진다.
- ☑️ [Cars] - 파싱 및 유효성 검증이 끝난 입력값을 통해 Cars 객체를 생성한다.
  - ✔️ 리스트에 있는 원소를 name attribute 값으로 갖는 [Car] 객체를 생성한다.

<br>

✅ **[Racing]: 사용자에게 진행할 라운드 수를 입력받는다.**
- ☑️ [InputView] - 사용자에게 진행할 라운드 수를 받는다
- ☑️ [TotalRoundsValidator] - 입력값에 대한 유효성 검증을 진행한다.
  - ✔️ 입력값이 비어있는 경우 오류를 던진다
  - ✔️ 입력값이 숫자가 아닌 경우 오류를 던진다.
  - ✔️ 입력값이 숫자이지만 정수가 아닌 경우 오류를 던진다.
  - ✔️ 입력값이 정수이지만 양의 정수가 아닌 경우 오류를 던진다.
- ☑️ [Parser]유효성이 끝난 입력값을 파싱하여 int로 저장한다.

<br>

✅ **[Racing]: 입력받은 라운드 수 만큼 한 라운씩 진행하며 상황을 출력한다.**
- ☑️ [Cars] - 한 라운드를 진행하고 결과를 DTO를 생성하여 넘겨준다.
  - ✔️ [MovementDeicer] - 원소로 가지고 있는 Car 객체 별로 움직임 여부를 리턴한다
  - ✔️ [Car] - 받은 값에 따라서 한 칸 전진하거나 정지한 상태로 유지한다.
  - ✔️ [Cars] - 위 과정을 가지고 있는 Car 객체마다 진행 후 결과값을 [CarsPositions]에게 넘겨준다
    - 이때 개별 자동차의 결과값을 [CarPosition]으로 만든 후, 이를 리스트로 묶어 [CarsPositions]를 빌드한다.
- ☑️ [CarsPositions] - 한 라운드의 총 결과를 출력방식에 맞게 리턴한다
- ☑️ [OutputVIew] - DTO를 통해 전해 받은 한 라운드의 결과를 출력한다.

<br>

✅ **[Racing]: 우승자를 발표하고 레이싱을 종료한다.**
- ☑️ [Cars] - 우승자를 결정하고 그 정보를 DTO를 생성하여 넘겨준다.
  - ✔️ [Cars] - 원소로 가지고 있는 Car 객체의 포지션 값을 비교하여 제일 높은 값을 가진 객체들의 이름을 추출한다.
  - ✔️ [Cars] - 이 추출값을 [Winners] DTO를 생성하여 넘겨준다.
- ☑️ [Winners] - 우승자를 출력방식에 맞게 리턴한다.
- ☑️ [OutputView] - DTO를 통해 받은 우승자를 출력한다.






---

## 📝 고민했던 요소 &nbsp;-&nbsp; 📂  파일 분배 & 구조에 관하여
1주차 코드 리뷰를 보고 개선해야되는 점을 먼저 생각하고 코드를 짜기 시작했습니다.

핵심은 전체적인 구조에 있었던 것 같습니다.
MVC 패턴에 대해 이번에 좀 더 깊게 공부한 결과, 패키지 구조가 굉장히 다양함을 알 수 있었고, 
이중에서 어느 구조를 사용할 지 제 나름의 기준을 가지고 접근하였습니다.

<br>

### 💭 DTO 도입
1주차 미션에서 제가 짠 코드를 보니, ```domain``` 내에서 이미 일차적으로 ```controller``` 역할을 하는 클래스가 존재하였고, 
뷰와 모델의 분리 또한 제대로 이루어지지 등 미숙한 점이 많았었습니다.
그렇기에 이번에는 DTO를 도입하여 뷰와 모델의 의존성을 약화시키려고 노력하였습니다.

<br>

### 💭 parser 패키지 생성 or domain 내에 Parser 위치 (+ validator)
주로 파싱이 어디서 이루어지는 지에 집중하였습니다. 

도메인 내의 로직 처리 중 파싱이 일어나는 것이라면 ```domain``` 내에 ```Parser```가 있는 것이 타당합니다.
하지만 지금 파싱이 주로 이루어지는 메커니즘이

1. 컨트롤러에서 뷰에게 인풋 요청
2. 뷰에서 인풋 리턴
3. 이 인풋에 대한 파싱 (파싱 전, 또는 후에 인풋 유효성 )

이므로 ```parser``` 패키지를 별도로 만들었습다. ```validator``` 또한 동일한 이유로 별도 패키지를 생성하였습니다. 

<br>

### 💭 상수 관리
```view```에서 사용되는 상수, ```validator```에서 사용되는 상수 등이 있는데, 이들을 ```constant``` 패키지를 만들어 한 곳에 관리할까 고민하였습니다.

-> 상수별로 사용되는 위치가 확실하게 구분되었기에, 상수는 각각의 사용처가 있는 패키지에 위치시키기로 하였습니다.

<br>

### 💭 그 외 디테일1 - static에 관하여
이번에 처음으로 테스트코드를 다양하게 짜보았는데, static을 남발하다 보니 단위 테스트를 하는데 어려움이 생겼습니다.
특히 ```MovementDecider```를 테스트하는데 많은 어려움이 있었습니다. 그래서 테스트의 용이성을 위하여 일부분 static 키워드를 제거하였습니다.

### 💭 그 외 디테일1 - vector에 관하여 & list 도입
자바를 제대로 배우기 전에 C++를 취미삼아 공부했다보니, 1주차에선 동적 크기를 가진 배열을 생각할 때 아무생각없이 vector를 사용했습니다.
이는 기본적으로 불필효한 오버헤드를 발생할 수 있어 사용을 지양해야 합니다. 그렇기에 이번에는 List 인터페이스를 이용하여 유연성 높은 코드를 작성하려 하였습니다.


--- 

## 😢아쉬웠던 점


### ⚠️ static 사용 기준의 모호함
기존에 static을 달았다가 테스트 코드의 작성 과정 중 불편함을 느껴서 제거하고, "뭔가 여기는 달면 안될 것 같아" 등 static 키워드를 어디다가 붙이고 
어디는 붙이지 않는 지에 대한 기준이 모호해서 아쉬웠습다. 좀 더 공부해서 기준을 명확히 삼아야겠습니다.

<br>

### ⚠️ AssertJ와 JUnit 미숙함
이번 코드를 작성하면서 거의 처음 다루다 보니 모르는 점이 많아 우여곡절이 있었습니다.
정보를 검색해 볼 때 예시에서는 쉽게 작성하던 테스트 코드를 작성하지 못한 경우가 있었습니다.
이들에 대해서 미숙하다보니 ```camp.next.edu.missionutils```에서 제공하는 api도 제대로 활용하지 못해서 아쉬운 점이 있습니다.