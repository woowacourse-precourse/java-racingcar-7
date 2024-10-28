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
<td rowspan="2"><b>🪟&nbsp;&nbsp;view</b></td>
<td><b> InputView </b></td>
<td> 사용자 요청을 처리하는 클래스 dto</td>
</tr>

<tr>
<td><b> OutputView </b></td>
<td> 사용자에게 응답을 출력하는 클래스 dto</td>
</tr>

<tr>
<td><b>  ↘️  /constants</b></td>
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

## 고민했던 요소


--- 

## 아쉬웠던 점