 IDENTIFICATION DIVISION.
 PROGRAM-ID. ALTERSTMT.
 PROCEDURE DIVISION.
    CALL SOMEPROG
       USING
          BY REFERENCE INTEGER SOMEINT SOMEFILE
          BY VALUE 1 2 SOMEID1
          BY CONTENT ADDRESS OF SOMEID2 LENGTH OF SOMEID3 4
       GIVING SOMEID4.