/*상호연관 서브쿼리(상관서브쿼리)
-메인쿼리의 값을 서브쿼리가 사용하고, 서브쿼리의 결과값을 메인쿼리가 사용
-메인쿼리와 서브쿼리가 서로 조인된 형태로 동작
***************/
-- SELECT 절에 사용된 상관 서브쿼리
SELECT O.ORDERID, O.CUSTID,
        (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) AS CUST_NAME,
        O.BOOKID,
        (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) AS BOOK_NAME
  FROM ORDERS O
;
-- 출판사별 평균 도서 가격보다 비싼 도서 목록을 구하시오
SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = '굿스포츠'
; --평균 도서가격

SELECT *
FROM BOOK B
WHERE PRICE > (SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = B.PUBLISHER)
ORDER BY PUBLISHER, PRICE
;

---조인문
----출판사별 평균 도서 가격
SELECT PUBLISHER, AVG(PRICE) AVG_PRICE
FROM BOOK B
GROUP BY PUBLISHER
;
SELECT B.*
FROM BOOK B ,(SELECT PUBLISHER, AVG(PRICE) AVG_PRICE
                  FROM BOOK
              GROUP BY PUBLISHER) A
WHERE B.PUBLISHER = A.PUBLISHER --조인조건
AND B.PRICE > A.AVG_PRICE --검색(선택)조건
;
--=========================================
--EXISTS : 존재여부 확인시 사용(있으면 TRUE)
--NOT EXISTS : 없으면 TRUE
SELECT *
  FROM CUSTOMER
 WHERE CUSTID IN (SELECT CUSTID FROM ORDERS)
;
-- =====> EXISTS 적용 : 데이터가 있으면 선택 / SELECT 다음에 아무값이나 와도 된다. 
SELECT *
  FROM CUSTOMER C
 WHERE EXISTS (SELECT CUSTID FROM ORDERS
               WHERE CUSTID = C.CUSTID)
;
-- =====> EXISTS 적용 : 데이터가 없으면 선택 
SELECT *
  FROM CUSTOMER C
 WHERE NOT EXISTS (SELECT CUSTID FROM ORDERS
               WHERE CUSTID = C.CUSTID)
;