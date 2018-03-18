INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy)
VALUES ('Marcin', 'Marcinowy', 'Poznań', 'marcin@co.pl', '54', 'Marcinex', '8888888', '666666666', '9', 'os. B.
  Chrobrego', '60-897');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy)
VALUES ('Olek', 'Wiśniewski', 'Ostrów', 'geolek@geolek.pl', '', 'Geolek', '5367821545', '521469874', '10', 'Wiejska',
                '67-327');

INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy)
VALUES ('Marek', 'Kaczmarek', 'Sopot', 'geomar@geomar.pl', '', 'Margeo', '2563697845', '+48698789654', '22', 'Wammowa',
                 '67-987');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy)
VALUES ('Natalia', 'Padalska', 'Lebiodska', 'Geonat@geonat.pl', '', 'Geonat', '6589632145', '445588777', '789',
                   'Szatana', '23-987');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy)
VALUES ('Magdalena', 'Olśniewska', 'Szklarska Poręba', 'biuro@magdalenex-geo.pl', '', 'Magdalenex-geo', '1256325874',
                     '+48258789654', '101', 'Zwycięstwa nad głupotą', '67-987');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy)
VALUES
  ('Izydor', 'Telesforski', 'Poznań', 'telegeo@telegeo.pl', '234A', 'Telgeo', '8547896321', '+489874563258', '140a',
             'Pogorzelska', '6-187');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy)
VALUES
  ('Tomasz', 'Tomkowski', 'Gdańsk', 'tomasz@tomex.pl', '', 'Tomanex', '99999', '777777777', '10', 'Szatana', '67-987');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy)
VALUES ('Kasia', 'Kasiunia', 'Piła', 'kasiaaaa@buziaczek.pl', '10', 'Kasiex', '1111111', '444444444', '8',
                 'Kasiowska', '67-987');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy)
VALUES ('Krasula', 'Krasulska', 'Kołobrzeg', 'krowa@muu.pl', '1', 'Krowex', '333333333', '111111111', '2', 'Szarlatana',
                   '67-987');
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy)
VALUES ('Zygmunt', 'Zygowski', 'Zakopane', 'zyga@zygeo.pl', '1', 'Zygeo', '7819870987', '+489998765', '290', 'Długa',
                   '67-987');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Badania gruntu', 'Badanie gruntu', 'szt.', 'FIELD_TESTS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Odwierty głebokie', 'Odwiert', 'szt.', 'SUPERVISIONS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Badanie w laboratorium', 'Badania laboratoryjne', 'szt.', 'DEVELOPMENT');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Tyczenie', 'Skoki o tyczce inaczej', 'szt.', 'FIELD_TESTS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Wiercenie geotechniczne', 'Robimy baaaardzo głębokie dziury', 'm', 'FIELD_TESTS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Sondowanie dynamiczne CPT', 'Sondujemy dynamicznie cośtam', 'm', 'FIELD_TESTS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Badanie VSS', 'Badanie VSS', 'm', 'SUPERVISIONS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Opinia geotechniczna', 'Opinia geotechniczna', 'm', 'DEVELOPMENT');


INSERT INTO offers.uzytkownik (nazwisko, imie, rola, login, haslo, aktywnosc)
VALUES ('Skrzypcz', 'Ewelina', 'ADMIN', 'Ewel', 'Ewe', TRUE);
INSERT INTO offers.uzytkownik (nazwisko, imie, rola, login, haslo, aktywnosc)
VALUES ('Skrzypcz', 'Tomasz', 'USER', 'Tom', 'Tom', TRUE);
INSERT INTO offers.uzytkownik (nazwisko, imie, rola, login, haslo, aktywnosc)
VALUES ('Konieczny', 'Marcin', 'ADMIN', 'M', 'K', TRUE);
