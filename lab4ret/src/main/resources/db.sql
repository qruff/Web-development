CREATE TABLE doctor (
                       id SERIAL PRIMARY KEY,
                       lastname VARCHAR(255) NOT NULL,
                       firstname VARCHAR(255) NOT NULL,
                       middlename VARCHAR(255) NOT NULL,
                       type VARCHAR(255) NOT NULL
);

CREATE TABLE patient (
                        id SERIAL PRIMARY KEY,
                        lastname VARCHAR(255) NOT NULL,
                        firstname VARCHAR(255) NOT NULL,
                        middlename VARCHAR(255) NOT NULL
);

CREATE TABLE priem (
                         id SERIAL PRIMARY KEY,
                         patient INTEGER REFERENCES patient(id) ON DELETE CASCADE ON UPDATE CASCADE ,
                         doctor INTEGER REFERENCES doctor(id) ON DELETE CASCADE ON UPDATE CASCADE,
                         date DATE NOT NULL
);