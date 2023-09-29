INSERT INTO customer(city, e_mail,first_name, last_name, phone, postal_code,street, user_name)
VALUES
    ('Solöga','anna"email.com','Annika','Andersson','0701012345','12345','Maskrosvägen 8','anki'),
    ('Solöga','bertil@email.com','Bertil','Borg','0702023456','12345','Maskrosvägen 8','berra'),
    ('Lilleby','cissi@email.com','Cissi','Cikada','0703033456','23456','Sotargatan 4','cikada'),
    ('Lilleby','daniel@email.com','Daniel','Druva','0704043456','23456','Sotargatan 4','druvor'),
    ('Edet','erika@email.com','Erika', 'Ek','0705052345', '11145','Gurkgränd 2','erika');

INSERT INTO court(court_name, number_of_players, price_per_hoursek)
VALUES
    ('Humlan', '2', '220'),
    ('Getingen', '4', '260'),
    ('Myran', '2', '220'),
    ('Sländan', '4', '260');

INSERT INTO timeslot(available, slot_date, slot_time)
VALUES
    (true, '2023-10-04', '0800-0900'),
    (true, '2023-10-04', '0900-1000'),
    (true, '2023-10-04', '1000-1100'),
    (true, '2023-10-04', '1100-1200');


INSERT INTO info(infotext)
VALUES ('Ljus hall med trevligt cafe'),
       ('Dusch och bastu finns tillgängligt');
