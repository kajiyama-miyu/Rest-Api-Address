DROP TABLE IF EXISTS addresses;
Create Table addresses (
	id serial not null,
	name VARCHAR(100) NOT NULL,
	telephone VARCHAR(15) NOT NULL,
	email VARCHAR(100) NOT NULL,
	address VARCHAR(200) NOT NULL
)