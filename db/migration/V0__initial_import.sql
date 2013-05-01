CREATE TABLE "Films" (
    "id" serial PRIMARY KEY,

    "name" varchar NOT NULL,
    "author" varchar NOT NULL,
    "genre" varchar NOT NULL,
    "country" varchar NOT NULL,
    "year" smallint NOT NULL,
    "duration" interval  NOT NULL
);

CREATE TABLE "Halls" (
    "id" serial PRIMARY KEY,

    "name" varchar  NOT NULL
);

CREATE TABLE "Sessions" (
    "id" serial PRIMARY KEY,

    "filmID" int NOT NULL,
    "hallID" int NOT NULL,

    "start" timestamp  NOT NULL,

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

    "name" varchar NOT NULL
);

CREATE TABLE "Categories" (
    "id" serial PRIMARY KEY,

    "typeID" int NOT NULL,
    "hallID" int NOT NULL,

    "price" money NOT NULL,

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

    "name" varchar NOT NULL,
    "percent" real NOT NULL,
    "expiration" timestamp NOT NULL
);

CREATE TABLE "Orders" (
    "id" serial PRIMARY KEY,

    "seasonID" int NOT NULL,
    "placeID" int NOT NULL,

    "customerName" varchar NOT NULL,
    "price" money NOT NULL,
    "comment" varchar,

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
