INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica)
VALUES
  ('Marcin', 'Marcinowy', 'Poznań', 'marcin@co.pl', '54', 'Marcinex', '8888888', '666666666', '9', 'os. B.
  Chrobrego');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica)
VALUES ('Tomasz', 'Tomkowski', 'Gdańsk', 'tomasz@tomex.pl', '', 'Tomanex', '99999', '777777777', '10', 'Szatana');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica)
VALUES ('Kasia', 'Kasiunia', 'Piła', 'kasiaaaa@buziaczek.pl', '10', 'Kasiex', '1111111', '444444444', '8', 'Kasiowska');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica)
VALUES
  ('Krasula', 'Krasulska', 'Kołobrzeg', 'krowa@muu.pl', '1', 'Krowex', '333333333', '111111111', '2', 'Szarlatana');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica)
VALUES
  ('Zygmunt', 'Zygowski', 'Zakopane', 'zyga@zygeo.pl', '1', 'Zygeo', '7819870987', '+489998765', '290', 'Długa');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Badania gruntu', 'Badanie gruntu', 'szt.', 'FIELD_TESTS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Odwierty głebokie', 'Odwiert', 'szt.', 'SUPERVISIONS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Badanie w laboratorium', 'Badania laboratoryjne', 'szt.', 'DEVELOPMENT');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Badanie georadarem', 'Badanie georadarem', 'm', 'LABORATORY_TESTS');


INSERT INTO offers.uzytkownik (nazwisko, imie, rola, login, haslo)
VALUES ('Skrzypcz', 'Ewelina', 'ADMIN', 'Ewel', 'Ewe');
INSERT INTO offers.uzytkownik (nazwisko, imie, rola, login, haslo) VALUES ('Skrzypcz', 'Tomasz', 'USER', 'Tom', 'Tom');
INSERT INTO offers.uzytkownik (nazwisko, imie, rola, login, haslo) VALUES ('Konieczny', 'Marcin', 'ADMIN', 'M', 'K');
