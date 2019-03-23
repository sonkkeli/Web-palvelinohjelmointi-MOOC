# Web-palvelinohjelmointi-MOOC
Excercises of the server-side web development MOOC course

port 8080 (http://localhost:8080/)


Osaamistavoitteet
Kurssilla Web-palvelinohjelmointi Java opit web-sovellusten toimintaperiaatteet sekä perustaidot web-sovellusten kehittämisestä Java-kielellä. Kurssilla on yhteensä seitsemän osaa, joiden osakohtaiset osaamistavoitteet ovat seuraavat. Osaamistavoitteet voivat muuttua kurssin edetessä.

Osa	Teemat	Osaamistavoitteet
-	Esitietovaatimukset	Ohjelmoinnin perusteet (TKT10002), Ohjelmoinnin jatkokurssi (TKT10003), Tietokantojen perusteet (TKT10004).
    
1	Johdanto web-sovellusten toimintaan ja internetin perusosiin.	Tiedät pääpiirteittäin miten Internet toimii. Tunnet käsitteet URI, DNS, HTTP ja HTML. Tunnet käsitteet polku ja pyynnön parametri. Tunnet HTTP-protokollan tasolla GET ja POST-tyyppisten pyyntöjen perusrakenteen ja tunnistat palvelimelta palautettavan HTTP-protokollaa noudattavan vastauksen osat. Tunnet asiakas-palvelin -mallin ja osaat toteuttaa yksinkertaisen palvelimen sekä selaimen. Tunnet pinnallisesti Spring Boot -sovelluskehyksen ja osaat luoda pyyntöihin reagoivan web-sovelluksen.
    
2	Näkymät, tietokannat ja tietokanta-abstraktiot.	Osaat muodostaa Thymeleaf-kirjastoa käyttäen sivuja, joita käytetään käyttäjälle palautettavien näkymien luontiin. Osaat lähettää tietoa palvelimelle ja käsitellä palvelimelle lähetettyä tietoa. Tunnet POST/Redirect/GET-suunnittelumallin. Tunnet käsitteen ORM ja osaat hyödyntää Javan ja Spring Bootin tarjoamaa tietokanta-abstraktiota tiedon käsittelyyn. Käsittelet yhden tietokantataulun sisältäviä sovelluksia. Tunnet käsitteen polkumuuttuja ja osaat käyttää polkumuuttujia sovelluksissasi.
    
3	Tietokannat ja tietokanta-abstraktiot. Viitteet tietokantataulujen välillä, tulosten rajaaminen ja järjestäminen.	Käsittelet useampia tietokantatauluja sisältäviä sovelluksia ja tiedät miten tietokantataulujen väliset viitteet määritellään. Osaat käsitellä transaktioita ohjelmallisesti. Tunnet N+1 kyselyn ongelman ja tiedät joitakin menetelmiä sen välttämiseen. Osaat järjestää ja rajata tietokannasta haettavaa tietoa.
    
4	Kerrosarkkitehtuuri, sovellusten automaattinen testaaminen ja web-sovelluskehitykseen liittyvä ohjelmistokehitysprosessi.	Osaat jakaa sovelluksen osia sovelluksen sisäisiksi palveluiksi ("Service"). Osaat kirjoittaa eri tason testejä sovelluksillesi. Ymmärrät tarpeen web-sovellusten kehitysprosessin automatisoinnille sekä web-sovellusten jatkuvalle inkrementaaliselle kehitykselle. Ymmärrät versionhallintapalvelun (esim. Github), sovelluksen testejä suorittavan integraatiopalvelun (esim. Travis CI) sekä testi- ja tuotantoympäristön (esim. Heroku) yhteistyön.
    
5	HTTP-protokolla ja evästeet. Autentikaatio ja autorisaatio. Syötteiden validointi. Hieman tietoturvaa.	Tunnet käsitteen tilattomuus. Tiedät mitä evästeet ovat ja mihin niitä käytetään. Tunnet evästeisiin liittyviä oleellisia lakiteknisia asioita. Osaat luoda sovelluksen, joka pyytää käyttäjää kirjautumaan. Osaat määritellä kirjautumista vaativia polkuja ja metodeja, sekä piilottaa näkymän osia erilaisilta käyttäjäryhmiltä. Osaat selittää autentikaation ja autorisaation erot. Tunnet tapoja tiedon validointiin ja osaat validoida lomakedataa. Tiedät web-sovellusten tyypillisimmät haavoittuvuudet sekä niihin vaikuttavat tekijät (OWASP).
    
6	REST. Javascript-pohjaisten selainohjelmistojen ja palvelinohjelmistojen yhteistyö.	Osaat käsitellä eri muodossa olevaa tietoa ja tunnet käsitteen mediatyyppi. Ymmärrät REST-arkkitehtuurimallin perusperiaatteet. Osaat toteuttaa palvelun, joka tarjoaa dataa REST-muotoisen rajapinnan yli. Osaat toteuttaa palvelun, joka hyödyntää REST-rajapintaa. Tiedät, että Javascript-koodia voi suorittaa selaimessa käyttäjän koneella. Osaat tehdä selainohjelmistosta Javascript-pyynnön palvelimelle. Osaat päivittää näkymää Javascript-pyynnön vastauksen perusteella.
    
7	Skaalautuvuus. Reaktiivinen ohjelmointi.	Tunnet menetelmiä sovellusten skaalaamiseen isoille käyttäjäjoukoille. Ymmärrät reaktiivisen ohjelmoinnin perusteet ja osaat tehdä yksinkertaisen palvelinohjelmiston reaktiivisella ohjelmointiparadigmalla.
