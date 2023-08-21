SELECT * FROM BOOK ORDER BY BOOKID DESC;
SELECT * FROM BOOK_LOG;
--INSERT 트리고 동작 여부 확인
INSERT INTO BOOK VALUES (30, '데이터베이스의 이해', 'ITBOOK', 25000);
--ROLLBACK; --입력 취소하면 트리거에 의해 입력된 LOG데이터도 함께 취소처리
INSERT INTO BOOK VALUES (40, '데이터베이스의 이해2', 'ITBOOK', 30000);
----------------------------------
--UPDATE 트리거 동작 확인(테스트)
SELECT * FROM BOOK ORDER BY BOOKID DESC;
SELECT * FROM BOOK_LOG;
UPDATE BOOK
    SET BOOKNAME = '--' ||BOOKNAME
WHERE BOOKNAME LIKE '%데이터베이스%'