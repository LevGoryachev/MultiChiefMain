-- MultiChiefMain, version 1.1, syntax: Postgres

CREATE TABLE "invest_project"(
id BIGSERIAL PRIMARY KEY,
ip_code INTEGER
);

CREATE TABLE "company_gen_info"(
id BIGSERIAL PRIMARY KEY,
ip_code INTEGER
);

CREATE TABLE "construction"(
id BIGSERIAL PRIMARY KEY,
codenumber VARCHAR(25) NOT NULL,
name VARCHAR(80) NOT NULL,
description TEXT,
UNIQUE (codenumber),
CHECK (name !='')
);

CREATE TABLE "company_project"(
id BIGINT NOT NULL UNIQUE REFERENCES construction(id) ON DELETE SET NULL,
invest_project_id BIGINT REFERENCES "invest_project"(id) ON DELETE SET NULL,
company_gen_info_id BIGINT REFERENCES "company_gen_info"(id) ON DELETE SET NULL
);

-- bind-tables:

CREATE TABLE "bind_department"(
id BIGSERIAL,
binded_department_id BIGINT NOT NULL,
company_gen_info_id BIGINT REFERENCES "company_gen_info"(id) ON DELETE CASCADE,
PRIMARY KEY (binded_department_id, id),
UNIQUE(id)
);

CREATE TABLE "bind_warehouse"(
id BIGSERIAL,
binded_warehouse_id BIGINT NOT NULL,
company_gen_info_id BIGINT REFERENCES "company_gen_info"(id) ON DELETE CASCADE,
PRIMARY KEY (binded_warehouse_id, id),
UNIQUE(id)
);


CREATE TABLE "bind_bom"(
id BIGSERIAL,
binded_bom_id BIGINT NOT NULL,
binded_contract_id BIGINT,
construction_id BIGINT REFERENCES "construction"(id) ON DELETE CASCADE,
PRIMARY KEY (binded_bom_id, id),
UNIQUE(id)
);

CREATE TABLE "bind_order"(
id BIGSERIAL,
binded_order_id BIGINT NOT NULL,
binded_employee_id BIGINT NOT NULL,
construction_id BIGINT REFERENCES "construction"(id) ON DELETE CASCADE,
PRIMARY KEY (binded_order_id, id),
UNIQUE(id)
);

CREATE TABLE "bind_bim"(
id BIGSERIAL,
binded_bim_id BIGINT NOT NULL,
binded_contract_id BIGINT,
construction_id BIGINT REFERENCES "construction"(id) ON DELETE CASCADE,
PRIMARY KEY (binded_bim_id, id),
UNIQUE(id)
);

CREATE TABLE "bind_estimate"(
id BIGSERIAL,
binded_estimate_id BIGINT NOT NULL,
binded_contract_id BIGINT,
construction_id BIGINT REFERENCES "construction"(id) ON DELETE CASCADE,
PRIMARY KEY (binded_estimate_id, id),
UNIQUE(id)
);

CREATE TABLE "bind_bow"(
id BIGSERIAL,
binded_bow_id BIGINT NOT NULL,
binded_contract_id BIGINT,
construction_id BIGINT REFERENCES "construction"(id) ON DELETE CASCADE,
PRIMARY KEY (binded_bow_id, id),
UNIQUE(id)
);



