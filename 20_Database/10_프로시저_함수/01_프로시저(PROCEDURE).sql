/*
프로시저 -> 데이터를 처리하는게 주목적
   == 리턴값이 없는 메서드

함수 -> 돌려받은 값을 사용하는 것

트리거 -> 특정상황에서 자동실행 되는 것 (프로시저와 함수는 직접 실행해줘야 하는 반면에,)
*/

--==============================================================================
--PL/SQL 프로시저 (PROCEDURE) - 오라클
--SYSTEM 유저에서 실행
SET SERVEROUTPUT ON; --서버쪽 출력화면을 볼 수 있게 설정(범위지정 해야 나옵니다.)       
                /*--------------------------------------------------------------
                SET SERVEROUTPUT ON;은 Oracle 데이터베이스에서 PL/SQL 블록을 실행할 때, 
                해당 블록의 결과를 출력하기 위한 명령입니다. 
                하지만 이 명령은 SQL*Plus와 같은 클라이언트 도구에서 사용되는 것이며, 
                단독으로 실행될 수 있는 유효한 SQL 문이 아닙니다. 
                SQL 문으로 인식되지 않기 때문에 범위 지정을 하지 않고 실행하면 정상 작동하지 않습니다.
                */--------------------------------------------------------------
SET SERVEROUTPUT OFF;

DECLARE --변수선언 영역
    V_EMPID NUMBER(10);
    V_NAME VARCHAR(30);
BEGIN --실행문 작성영역(시작)
    V_EMPID := 100; --오라클에서는 치환문(대입문) 부호(콜른이퀄 := ) 사용
    V_NAME := '신민기';
    
    --화면출력 해보기
    DBMS_OUTPUT.PUT_LINE('HELLO My little Bird');
    --// 자바의 System.out.print();과 같은 기능
    DBMS_OUTPUT.PUT_LINE(V_EMPID || ':' || V_NAME);
    
END; --실행문 작성영역(끝)
--==============================================================================

-- BOOK 테이블 데이터 중 일부를 화면 출력
DECLARE
    V_BOOKID NUMBER(2); -- 크기는 해당 테이블 컬럼의 DATA_TYPE과 일치하거나 더 크게
    V_BOOKNAME VARCHAR2(40);
    V_PUBLISHER VARCHAR2(40);
    V_PRICE NUMBER(8);
BEGIN
    -- SELECT ~ INTO ~ FROM 형태로 DB데이터를 선택하고, INTO절 변수에 저장
    -- 1개의 데이터만 처리가 가능하다
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
    INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE 
    FROM BOOK
    WHERE BOOKID = 3;
    
    DBMS_OUTPUT.put_line(V_BOOKID || ',' || V_BOOKNAME || ',' || V_PUBLISHER || ',' || V_PRICE);

END;


--========================
/* 저장 프로시저(stored procedure)
매개변수(파라미터, parameter) 유형
- IN : 입력을 받기만 하는 변수형태(기본값)
- OUT : 출력만 하는 변수형태
        (값을 전달 받을 수 없고, 프로시저 실행 후 저장된 값을 호출한 곳으로 전달)
- IN OUT : 입력도 받고, 값을 변수를 통해 호출한 곳으로 전달(출력)
*****************************/
CREATE OR REPLACE PROCEDURE BOOK_DISP --프로시저 선언부
--매개변수 선언부 : ( ) 안에 작성, 타입만 지정, 구분문자 콤마(,) 사용
(
    IN_BOOKID NUMBER
)
AS --변수선언부(AS 또는 IS ~ BEGIN 문 사이)
    V_BOOKID NUMBER(2);
    V_BOOKNAME VARCHAR2(40);
    V_PUBLISHER VARCHAR2(40);
    V_PRICE NUMBER(8);
BEGIN
   
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
    INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE 
    FROM BOOK
    WHERE BOOKID = IN_BOOKID;
    
    DBMS_OUTPUT.put_line(V_BOOKID || ',' || V_BOOKNAME || ',' || V_PUBLISHER || ',' || V_PRICE);

END;
------------
--프로시저 실행 : EXECUTE 프로시저명
EXECUTE BOOK_DISP(3);
EXEC BOOK_DISP(10);

-- 프로시저 삭제
DROP PROCEDURE BOOK_DISP;

--==================================
/* (실습)프로시저를 작성하고 실행하기
고객테이블(CUSTOMER)에 있는 데이터 조회 프로시저 작성
- 프로시저명 : CUSTOMER_DISP
- 입력받는 값 : 고객ID
- 처리 : 입력받은 고객ID에 해당하는 데이터를 찾아서 화면 출력
- 출력항목 : 고객ID, 고객명, 주소, 전화번호
*******************************/
CREATE OR REPLACE PROCEDURE CUSTOMER_DISP
(
    IN_CUSTID NUMBER
) AS 
    C_CUSTID CUSTOMER.CUSTID%TYPE; --CUSTOMER테이블의 CUSTID 데이터타입을 가져다 쓸 수 있다.
    C_NAME CUSTOMER.NAME%TYPE;
    C_ADDRESS CUSTOMER.ADDRESS%TYPE;
    C_PHONE CUSTOMER.PHONE%TYPE;
BEGIN
    SELECT CUSTID, NAME, ADDRESS, PHONE
    INTO C_CUSTID, C_NAME, C_ADDRESS, C_PHONE
    FROM CUSTOMER
    WHERE CUSTID = IN_CUSTID;
    DBMS_OUTPUT.put_line(C_CUSTID || ',' || C_NAME || ',' || C_ADDRESS || ',' || C_PHONE);
    DBMS_OUTPUT.put_line(C_NAME);
END;
EXEC CUSTOMER_DISP(1);
EXEC CUSTOMER_DISP(2);
EXEC CUSTOMER_DISP(3);
EXEC CUSTOMER_DISP(4);