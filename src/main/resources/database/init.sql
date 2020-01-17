DROP SEQUENCE IF EXISTS EVENTS_ID_SEQ_GEN;
CREATE SEQUENCE EVENTS_ID_SEQ_GEN START WITH 1 INCREMENT BY 1 CACHE 10 NOCYCLE;

insert into EVENTS (ID, BASEPRISEOFTICKET, NAME, RATING) VALUES (EVENTS_ID_SEQ_GEN.nextval, 100, 'Predator', 'high');
insert into EVENTS (ID, BASEPRISEOFTICKET, NAME, RATING) VALUES (EVENTS_ID_SEQ_GEN.nextval, 50, 'Terminator', 'mid');
insert into EVENTS (ID, BASEPRISEOFTICKET, NAME, RATING) VALUES (EVENTS_ID_SEQ_GEN.nextval, 100, 'Konan', 'low');


insert into USERS (ID, BIRTHDAY, EMAIL, NAME, SURNAME) VALUES (1, '1975-08-13', 'Dantes1975@inbox.ru', 'Denis', 'Rumyancev');
insert into USERS (ID, BIRTHDAY, EMAIL, NAME, SURNAME) VALUES (2, '1975-08-20', 'Oksana1975@inbox.ru', 'Oksana', 'Rumyanceva');
insert into USERS (ID, BIRTHDAY, EMAIL, NAME, SURNAME) VALUES (3, '1999-11-25', 'Vika@inbox.ru', 'Viktoriya', 'Rumyanceva');

