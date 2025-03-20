/*INSERT INTO touristguide.attraction (NAME, DESCRIPTION, IMAGE_PATH, Season_ID, City_ID)
VALUES
    ("Tivoli",
     "Tivoli er en af verdens ældste forlystelsesparker, beliggende i hjertet af København.
     Parken tilbyder en blanding af spændende forlystelser, smukke haver, koncerter og teaterforestillinger,
     hvilket gør det til et ideelt sted for både familier og turister, der ønsker en sjov og magisk oplevelse.",
     "https://wallpapercat.com/w/full/1/1/e/685533-1920x1080-desktop-1080p-tivoli-gardens-wallpaper-image.jpg", 3, 2),
    ("SMK",
     "Statens Museum for Kunst er Danmarks største kunstmuseum og huser en imponerende samling af både dansk og international kunst.
     Museet tilbyder værker fra renæssancen til moderne kunst og giver besøgende mulighed for at udforske både klassiske og nutidige kunstværker i smukke omgivelser.",
     "https://www.smk.dk/wp-content/uploads/2022/08/JoakimZuger03141-scaled-e1716369338667.jpg", 2, 2
    ),
    ("Nyhavn",
     "Nyhavn er en ikonisk havn i København, kendt for sine farverige bygninger og livlige atmosfære.
     Området er fyldt med restauranter, barer og caféer,
     og det er et populært sted for både lokale og turister at nyde en afslappet middag eller tage en kanalrundfart i de charmerende både.",
     "https://www.tapet.com/media/catalog/product/cache/5b18b93ddbe5d6592c6b175f41d24454/a/d/adobestock_309256433-small.jpg", 1, 2
    ),
    ("Legoland",
     "Legoland Billund er en fantastisk forlystelsespark, der byder på spændende oplevelser for både børn og voksne.
     Parken er kendt for sine imponerende LEGO-modeller, forlystelser og temazoner,
     der gør det til et sjovt og fantasifuldt sted for hele familien at udforske og nyde.",
     "https://www.legoland.dk/media/joclxhf1/136-legoland__k1a2849_final_1920x1080.jpg", 1, 4
    ),
    ("Skovtårnet",
     "Skovtårnet er Danmarks højeste træbygning og tilbyder en spektakulær udsigt over Smålandskovene.
     Tårnet er en del af Camp Adventure Park og giver besøgende mulighed for at opleve naturen fra et nyt perspektiv,
     mens man går op ad en imponerende gangbro, der snor sig op til toppen af tårnet.",
     "https://files.guidedanmark.org/files/444/219094_Skovtrnet_8.jpg?width=1920&height=960&format=webp&mode=crop", 1, 1
    ),
    ("BonBon-Land",
     "BonBon-Land er en farverig forlystelsespark i Danmark, kendt for sine sjove og kreative forlystelser,
     inspireret af det populære slikmærke. Parken tilbyder et væld af forlystelser, fra vilde rutsjebaner til tematiserede områder,
     der gør det til et underholdende sted for både børn og voksne.",
     "https://www.bonbonland.dk/content/dam/bbl/images/blog/Bedste%20rutchebane.jpg", 1, 3
    );


INSERT INTO touristguide.tags (TAGS_NAME)
VALUES
("Underholdning"),
("Adrenalin"),
("Mad"),
("Kunst"),
("Kultur"),
("Historie"),
("Seværdigheder"),
("Natur"),
("Forlystelser");

INSERT INTO touristguide.city (CITY_NAME)
VALUES
("København Ø"),
("København V"),
("Søborg"),
("Ishøj"),
("Brønshøj");

INSERT INTO attractions_tags (ATTRACTION_ID, TAGS_ID)
VALUES
    (3, 5),
    (3, 6),
    (3, 7),
    (4, 1),
    (4, 9),
    (5, 5),
    (5, 8),
    (6, 1),
    (6, 9);
*/