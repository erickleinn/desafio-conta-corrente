-- public.accounts definição

-- Drop table

DROP TABLE public.accounts;

CREATE TABLE public.accounts (
	id uuid NOT NULL,
	"owner" uuid NOT NULL,
	created_at varchar NULL,
	status varchar NULL,
	balance varchar NULL
);

-- public.transactions definição

-- Drop table
DROP TABLE public.transactions;

CREATE TABLE public.transactions (
	id uuid NOT NULL,
	"type" varchar NOT NULL,
	amount int8 NOT NULL,
	currency varchar NULL,
	status varchar NOT NULL,
	"timestamp" varchar NOT NULL
);