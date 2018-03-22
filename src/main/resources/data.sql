INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Marcin', 'Marcinowy', 'Poznań', 'marcin@co.pl', '54', 'Marcinex', '8888888', '666666666', '9', 'os. B.
  Chrobrego', '60-897', FALSE );
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Olek', 'Wiśniewski', 'Ostrów', 'geolek@geolek.pl', '', 'Geolek', '5367821545', '521469874', '10', 'Wiejska',
                '67-327', FALSE);

INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Marek', 'Kaczmarek', 'Sopot', 'geomar@geomar.pl', '', 'Margeo', '2563697845', '+48698789654', '22', 'Wammowa',
                 '67-987', FALSE);
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Natalia', 'Padalska', 'Lebiodska', 'Geonat@geonat.pl', '', 'Geonat', '6589632145', '445588777', '789',
                   'Szatana', '23-987', FALSE);
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Magdalena', 'Olśniewska', 'Szklarska Poręba', 'biuro@magdalenex-geo.pl', '', 'Magdalenex-geo', '1256325874',
                     '+48258789654', '101', 'Zwycięstwa nad głupotą', '67-987', FALSE);
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES
  ('Izydor', 'Telesforski', 'Poznań', 'telegeo@telegeo.pl', '234A', 'Telgeo', '8547896321', '+489874563258', '140a',
             'Pogorzelska', '6-187', FALSE);
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES
  ('Tomasz', 'Tomkowski', 'Gdańsk', 'tomasz@tomex.pl', '', 'Tomanex', '99999', '777777777', '10', 'Szatana', '67-987', FALSE);
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Kasia', 'Kasiunia', 'Piła', 'kasiaaaa@buziaczek.pl', '10', 'Kasiex', '1111111', '444444444', '8',
                 'Kasiowska', '67-987', FALSE);
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Karolina', 'Krasulska', 'Kołobrzeg', 'krowa@muu.pl', '1', 'Krowex', '333333333', '111111111', '2',
                    'Szarlatana',
                    '67-987', FALSE);
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Zygmunt', 'Zygowski', 'Zakopane', 'zyga@zygeo.pl', '1', 'Zygeo', '7819870987', '+489998765', '290', 'Długa',
                   '67-987', FALSE);
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Ziemowit', 'Zonkowski', 'Pobruszyn', 'biuro@zongeo.pl', '1', 'Zonziem', '1589632514', '+489998765', '29a',
                    'Mieszka 1',
                    '67-987', FALSE);
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Zymisław', 'Arkowski', 'Słoniowice', 'slongeo@geoslon.pl', '23', 'Arkslon', '7894562541', '+489998765', '158',
                    'Zaporowa',
                    '37-437', FALSE);
INSERT INTO offers.inwestor (imie, nazwisko, miasto, email, nr_lokalu, nazwa, nip, numertelefonu, nr_posesji, ulica,
                             kod_pocztowy, archiwalny)
VALUES ('Zygmunt', 'Arachnowicz', 'Solina', 'biuro@geosol.pl', '1', 'Zygokop', '7854896521', '+4858752145', '20a',
                   'Orfeusza',
                   '32-347', FALSE);


INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Badania gruntu', 'Badanie gruntu', 'PIECE', 'FIELD_TESTS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Odwierty głebokie', 'Odwiert', 'PIECE', 'SUPERVISIONS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Badanie w laboratorium', 'Badania laboratoryjne', 'SPECIMEN', 'DEVELOPMENT');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Skoki o tyczce inaczej', 'Tyczenie', 'PIECE', 'FIELD_TESTS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Robimy baaaardzo głębokie dziury', 'Wiercenie geotechniczne', 'METER', 'FIELD_TESTS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Sondujemy dynamicznie cośtam', 'Sondowanie dynamiczne CPT', 'METER', 'FIELD_TESTS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Badanie VSS', 'Badanie VSS', 'SPECIMEN', 'SUPERVISIONS');
INSERT INTO offers.skladnik_oferty (opis, nazwa_uslugi, jednostka, kategoria_skladnika)
VALUES ('Opinia geotechniczna', 'Opinia geotechniczna', 'SPECIMEN', 'DEVELOPMENT');


INSERT INTO offers.uzytkownik (nazwisko, imie, rola, login, haslo, aktywnosc)
VALUES ('Skrzypcz', 'Ewelina', 'ROLE_ADMIN', 'Ewel', 'Ewe', TRUE);
INSERT INTO offers.uzytkownik (nazwisko, imie, rola, login, haslo, aktywnosc)
VALUES ('Skrzypcz', 'Tomasz', 'ROLE_USER', 'Tom', 'Tom', TRUE);
INSERT INTO offers.uzytkownik (nazwisko, imie, rola, login, haslo, aktywnosc)
VALUES ('Konieczny', 'Marcin', 'ROLE_ADMIN', 'M', 'K', TRUE);
