WORK BREAKDOWN

Tehnološki stek:
●	Bekend: Spring MVC
●	Frontend: Bootstrap, JQuery
●	Baza: MySQL

Moduli: M1, M2, M3…
Funkcionalnosti: F1, F2, F3…

M1: Modul za prijavu korisnika
●	F1: Mogućnost kreiranja profila
Baza: Tabela Korisnici
Bekend: Model Korisnik, CRUD za taj model
Frontend: Forma za kreiranje profila
Vrijeme: 5 dana
●	F2: Mogućnost prijave na stranicu za pristup profilu korisnika
Baza: Tabela Korisnici
Bekend: Model Korisnik, CRUD za taj model
Frontend: Forma za prijavu
Vrijeme: 5 dana
●	F3: Mogućnost povratka šifre u slučaju da korisnik istu zaboravi
Baza: Tabela Korisnici
Bekend: Model Korisnik, CRUD za taj model
Frontend: Forma za povratak šifre
Vrijeme: 5 dana

M2: Modul za katalog filmova 
●	F1: Mogućnost dodavanja novog filma
  	Baza:Tabela Film
	Bekend:Model Film, CRUD za taj model
	Fronted:Forma za dodavanje novog Filma
	Pravo pristupa:Administrator
	Vrijeme:2 dana
●	F2: Mogućnost brisanja novog filma
	Baza:Tabela Film
	Bekend:Model Film, CRUD za taj model
	Frontend:Prikaz svih filmova i ponuđena opcija brisanja određenog filma( U vidu   linka Delete) 
	Pravo pristupa:Administrator
	Vrijeme:2 dana
●	F3: Mogućnost editovanja filmova
	Baza:Model Film
	Bekend:Model Film, CRUD za taj model
	Frontend: Prikaz svih filmova i ponuđena opcija update određenog filma (U vidu linka Update, na čiji se klik prikaže forma sa popunjenim vrijednostima polja forme, kakve su informacije trenutno spašene za taj film u bazi. I onda se mogu editovati sva polja osim polja id i ponovo sačuvat u bazu)
	Pravo pristupa:Administrator
	Vrijeme:3 dana
●	F4: Mogućnost prikaza svih filmova
	Baza:Model Film
	Bekend:Model Film, CRUD za taj model
	Frontend:Prikaz svih filmova (Slika filma, naslov, kratki sadržaj i vrijeme prikazivanja), po određenim danima prikazivanja
	Prava pristupa:Nema restrikcija
	Vrijeme:7 dana
	
M3: Modul za informacije

●	F1: Mogućnost pregleda novih informacija
  	Baza: Model  informacije ( čuva podatke: naslov, slika, kometar)
	Bekend: Model informacije, CRUD za taj model 
	Fronted: Prikaz u obliku naslovnice,  dolazak novog filma, event u kinu, kada kino ne                   radi i slično 
	Pravo pristupa: Nema restrikcija
	Vrijeme: 7 dana
●	 F2: Mogućnost dodavanja i brisanja informacija
  	Baza: Model  informacije ( čuva podatke: naslov, slika, kometar)
	Bekend: Model informacije, CRUD za taj model 
	Fronted: Prikaz u obliku naslovnice,  dolazak novog filma, event u kinu, kada kino ne                   radi i slično 
	Pravo pristupa: Administrator
	Vrijeme: 7 dana
●	F3: Mogućnost editovanja informacija
  	Baza: Model  informacije ( čuva podatke: naslov, slika, kometar)
	Bekend: Model informacije, CRUD za taj model 
	Fronted: Prikaz u obliku naslovnice,  dolazak novog filma, event u kinu, kada kino ne                   radi i slično 
	Pravo pristupa: Nema restrikcija
	Vrijeme: 7 dana
●	F4: Mogućnost ostavljanja komentara na informacije
  	Baza: Model  komentara( čuva podatke: korisnicko ime, mail, komentar)
	Bekend: Model komentara, CRUD za taj model 
	Fronted: Prikaz u obliku mogućnosti ostavljanja komentara
	Pravo pristupa: Nema restrikcija
	Vrijeme: 7 dana
●	F5: Mogućnost editovanja i brisanja komentara na informacije
  	Baza: Model  komentara( čuva podatke: korisnicko ime, mail, komentar)
	Bekend: Model komentara, CRUD za taj model 
	Fronted: Prikaz u obliku mogućnosti brisanja i editovanja komentara
	Pravo pristupa: Administrator
	Vrijeme: 7 dana

M4: Modul za kontakt

●	F1: Mogućnost ostavljanja kontakt informacija i upita, te slanje istih na mail kina
  	Baza: Ne čuva permanentno podatke u bazi, već šalje direktno na mail
	Bekend: Slanje maila
	Fronted: Prikaz u obliku forme za ostavljanje komentara
	Pravo pristupa: Nema restrikcija
	Vrijeme: 2 dana

M5: Modul za usluge
●	F1: Dodavanje/izmjena/brisanje usluge
Baza:Tabela Usluga
Bekend:Model Usluga, CRUD za taj model
Fronted:Forma za dodavanje/izmjenu/brisanje usluge
Pravo pristupa:Administrator
Vrijeme:4 dana
●	F2: Prikaz usluga
Baza:Tabela Usluga
Bekend:Model Usluga
Fronted:Prikaz usluga na public page-u
Vrijeme:2 dana
