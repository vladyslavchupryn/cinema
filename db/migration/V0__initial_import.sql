CREATE TABLE "Films" (
    "id" serial PRIMARY KEY,

    "name" varchar(126) NOT NULL,
    "author" varchar(126) NOT NULL,
    "genre" varchar(126) NOT NULL,
    "country" varchar(126) NOT NULL,
    "year" smallint NOT NULL CHECK("year" > 1800 and "year" < 2200),
    "duration" interval  NOT NULL
);

CREATE TABLE "Halls" (
    "id" serial PRIMARY KEY,

    "name" varchar(126)  NOT NULL
);

CREATE TABLE "Sessions" (
    "id" serial PRIMARY KEY,

    "filmID" int NOT NULL,
    "hallID" int NOT NULL,

    "start" timestamp  NOT NULL,

    "percent" real NOT NULL DEFAULT 0.0,

    CONSTRAINT "Films_filmID"
        FOREIGN KEY("filmID")
        REFERENCES "Films"("id")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,

    CONSTRAINT "Halls_hallID"
        FOREIGN KEY("hallID")
        REFERENCES "Halls"("id")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE "PlaceTypes" (
    "id" serial PRIMARY KEY,

    "name" varchar(126) NOT NULL
);

CREATE TABLE "Categories" (
    "id" serial PRIMARY KEY,

    "typeID" int NOT NULL,
    "hallID" int NOT NULL,

    "price" numeric(12,6) NOT NULL,

    CONSTRAINT "PlaceTypes_typeID"
        FOREIGN KEY("typeID")
        REFERENCES "PlaceTypes"("id")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,

    CONSTRAINT "Halls_hallID"
        FOREIGN KEY("hallID")
        REFERENCES "Halls"("id")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION

);

CREATE TABLE "Places" (
    "id" serial PRIMARY KEY,

    "categoryID" int NOT NULL,

    "number" smallint NOT NULL,

    CONSTRAINT "Categories_categoryID"
        FOREIGN KEY("categoryID")
        REFERENCES "Categories"("id")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE "Correlations" (
    "id" serial PRIMARY KEY,

    "name" varchar(126) NOT NULL,
    "percent" real NOT NULL,
    "expiration" timestamp
);

CREATE TABLE "Orders" (
    "id" serial PRIMARY KEY,

    "seasonID" int NOT NULL,
    "placeID" int NOT NULL,

    "customerName" varchar(126) NOT NULL,
    "price" numeric(12,6) NOT NULL,
    "comment" varchar(126),

    CONSTRAINT "Sessions_seasonID"
        FOREIGN KEY("seasonID")
        REFERENCES "Sessions"("id")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,

    CONSTRAINT "Places_placeID"
        FOREIGN KEY("placeID")
        REFERENCES "Places"("id")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE "OrdersCorrelations" (
    "orderID" int NOT NULL,
    "correlationID" int NOT NULL,

    CONSTRAINT "Orders_orderID"
        FOREIGN KEY("orderID")
        REFERENCES "Orders"("id")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,

    CONSTRAINT "Correlations_correlationID"
        FOREIGN KEY("correlationID")
        REFERENCES "Correlations"("id")
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);
