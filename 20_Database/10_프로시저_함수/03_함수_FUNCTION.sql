/* 함수(FUNCTION) *********
CREATE OR REPLACE FUNCTION FUNCTION1 (
  PARAM1 IN VARCHAR2 --파라미터(옵션)
) RETURN VARCHAR2 --리턴 데이터 타입 선언(필수)
AS 
BEGIN
  RETURN NULL; --리턴값(필수)
END FUNCTION1;
--------------------------
--리턴 데이터 타입 선언 필요
RETURN 데이터유형

--프로그램 마지막(중간)에 값 리턴하는 RETURN문 필요(필수)
RETURN 리턴값;

*************************/
create or replace FUNCTION GET_BOOKNAME (
    IN_ID IN NUMBER
) RETURN VARCHAR2 --리턴데이터 타입
AS 
    V_BOOKNAME BOOK.BOOKNAME%TYPE;
BEGIN
    SELECT BOOKNAME
    INTO V_BOOKNAME
    FROM BOOK
    WHERE BOOKID = IN_ID;
    
    RETURN V_BOOKNAME;
END;
-----------------------------
--함수의 사용(SELECT, WHERE 절에서 사용)
--동작여부 확인
SELECT GET_BOOKNAME(1) FROM DUAL;
--SELECT 절에서 사용
SELECT BOOKID, BOOKNAME, GET_BOOKNAME(BOOKID)
FROM BOOK;
----------------
---WHERE 절에서 하뭇 사용   --JOIN하는 것이 더 좋음(속도도 함수보다 더 빠르다.)
SELECT O.*
    , GET_BOOKNAME(O.BOOKID) AS BOOKNAME
FROM ORDERS O 
WHERE GET_BOOKNAME(O.BOOKID) LIKE '%축구%'
;
--------------------------------------------------------
--(실습) 고객ID 값을 받아서 고객명을 돌려주는 함수 작성(CUSTOMER 테이블 사용)
-- 함수명 : GET_CUSTNAME
-- GET_CUSTNAME 함수 사용해서 고객명 검색 여부 확인해보기
-------------------
-- ORDERS 테이블 데이터 조회
---- GET_BOOKNAME, GET_CUSTNAME 함수사용 주문(판매)정보와 책제목, 고객명 조회
SELECT NAME FROM CUSTOMER WHERE CUSTID = 1; -- CUSTID를 뽑는 과정에서 문제가 없는지 미리 SELEC절로 확인해보기

CREATE OR REPLACE FUNCTION GET_CUSTNAME (
    GET_CUSTID IN NUMBER        --파라미터값 설정
)RETURN VARCHAR2                --리턴타입 설정
AS
    V_NAME CUSTOMER.NAME%TYPE;  --테이블과 연결할 변수 타입지정    
BEGIN
    SELECT NAME             --테이블과 연결
    INTO V_NAME
    FROM CUSTOMER
    WHERE CUSTID = GET_CUSTID;  --리턴값 조건 설정
    RETURN V_NAME;          --리턴할 값설정
END;
------------------------------------
SELECT O.*, 
       GET_BOOKNAME(O.BOOKID) AS BOOK_NAME,
       GET_CUSTNAME(O.CUSTID) AS CUST_NAME
FROM ORDERS O
;
--------------------------------------
--서브쿼리로 해보기
SELECT O.*, 
       (SELECT BOOKNAME FROM BOOK B WHERE O.BOOKID = B.BOOKID) AS BOOK_NAME,
       (SELECT NAME FROM CUSTOMER C WHERE O.CUSTID = C.CUSTID) AS CUST_NAME
FROM ORDERS O
;
-------------------
--조인해서 해보기
SELECT O.*
        ,B.BOOKNAME
        ,C.NAME
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.BOOKID = B.BOOKID
AND O.CUSTID = C.CUSTID
;

