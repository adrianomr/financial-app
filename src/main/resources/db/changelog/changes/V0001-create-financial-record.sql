CREATE TABLE IF NOT EXISTS financial_record(
    id UUID NOT NULL,
	description VARCHAR NOT NULL,
	category VARCHAR NOT NULL,
	"value" NUMERIC(10,2) NOT NULL,
	type VARCHAR NOT NULL,
	"date" date NOT NULL,
	CONSTRAINT financial_record_pkey PRIMARY KEY (id)
)