INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

              
INSERT INTO kategorija(id, naziv) VALUES (1, "Monitori");
INSERT INTO kategorija(id, naziv) VALUES (2, "Tastature");
INSERT INTO kategorija(id, naziv) VALUES (3, "Slusalice");
              
INSERT INTO proizvod(id, naziv, cena, stanje, kategorija_id) VALUES (1, "LG monitor 24", 21000, 3, 1);
INSERT INTO proizvod(id, naziv, cena, stanje, kategorija_id) VALUES (2, "Samsung monitor 24", 22500, 2, 1);
INSERT INTO proizvod(id, naziv, cena, stanje, kategorija_id) VALUES (3, "Asus monitor 24", 20350, 4, 1);
INSERT INTO proizvod(id, naziv, cena, stanje, kategorija_id) VALUES (4, "A4Tech freestyler", 3000, 5, 2);
INSERT INTO proizvod(id, naziv, cena, stanje, kategorija_id) VALUES (5, "Logitech MS380", 3528, 6, 2);
INSERT INTO proizvod(id, naziv, cena, stanje, kategorija_id) VALUES (6, "Jbl Gamer", 5999, 7, 3);
INSERT INTO proizvod(id, naziv, cena, stanje, kategorija_id) VALUES (7, "Razer Ultra", 8560, 2, 3);

INSERT INTO porudzbina(id, kolicina, proizvod_id) VALUES (1, 1, 2);
INSERT INTO porudzbina(id, kolicina, proizvod_id) VALUES (2, 2, 4);
INSERT INTO porudzbina(id, kolicina, proizvod_id) VALUES (3, 2, 1);
INSERT INTO porudzbina(id, kolicina, proizvod_id) VALUES (4, 1, 7);
INSERT INTO porudzbina(id, kolicina, proizvod_id) VALUES (5, 2, 3);
INSERT INTO porudzbina(id, kolicina, proizvod_id) VALUES (6, 3, 5);

