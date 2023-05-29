INSERT INTO doctor (lastname, firstname, middlename, type) VALUES ('Сергеев', 'Константин', 'Валерьевич', 'Терапевт');
INSERT INTO doctor (lastname, firstname, middlename, type) VALUES ('Петрова', 'Анастасия', 'Алексеевна', 'Офтальмолог');
INSERT INTO doctor (lastname, firstname, middlename, type) VALUES ('Мелькова', 'Дарья', 'Олеговна', 'Хирург');
INSERT INTO doctor (lastname, firstname, middlename, type) VALUES ('Халтурин', 'Евгений', 'Александрович', 'Кардиолог');
INSERT INTO doctor (lastname, firstname, middlename, type) VALUES ('Домрачев', 'Павел', 'Борисович', 'Хирург');
INSERT INTO doctor (lastname, firstname, middlename, type) VALUES ('Титов', 'Сергей', 'Захарович', 'Терапевт');
INSERT INTO doctor (lastname, firstname, middlename, type) VALUES ('Титов', 'Сергей', 'Захарович', 'Терапевт');

INSERT INTO patient (lastname, firstname, middlename) VALUES ('Ногин', 'Кирилл', 'Дмитриевич');
INSERT INTO patient (lastname, firstname, middlename) VALUES ('Турин', 'Ефим', 'Владимирович');
INSERT INTO patient (lastname, firstname, middlename) VALUES ('Шалегов', 'Михаил', 'Романович');

INSERT INTO priem (patient, doctor, date) VALUES (1, 1, '2022-01-01');
INSERT INTO priem (patient, doctor, date) VALUES (2, 4, '2022-01-01');
INSERT INTO priem (patient, doctor, date) VALUES (3, 3, '2022-01-01');
INSERT INTO priem (patient, doctor, date) VALUES (1, 5, '2022-01-01');
INSERT INTO priem (patient, doctor, date) VALUES (2, 2, '2022-01-01');
INSERT INTO priem (patient, doctor, date) VALUES (3, 6, '2022-01-01');

INSERT INTO users (username, password, enabled) VALUES ('admin2', '$2a$12$HF5BShA30LotIZQSFClel.I//LLK3OmTEMk7Thi8GRvLeNMptSAuS', true);
INSERT INTO authorities (username, authority) VALUES ('admin2', 'ROLE_ADMIN');

INSERT INTO users (username, password, enabled) VALUES ('user1', '$2a$12$HF5BShA30LotIZQSFClel.I//LLK3OmTEMk7Thi8GRvLeNMptSAuS', true);
INSERT INTO authorities (username, authority) VALUES ('user1', 'ROLE_USER');