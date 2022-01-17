-- MCEngineeringBundleDB, version 2.0, syntax: Oracle

CREATE TABLE "role_in_project"(
role_in_project_id BIGSERIAL PRIMARY KEY,
role_in_project_name VARCHAR(80)
);

CREATE TABLE "project_approval"(
bim_id BIGINT,
employee_id BIGINT,
role_in_project_id BIGINT REFERENCES "role_in_project"(role_in_project_id),
approval_date TIMESTAMP,
PRIMARY KEY (bim_id, employee_id)
);

CREATE TABLE "project_bow"(
bim_id BIGINT,
bow_id BIGINT,
PRIMARY KEY (bim_id, bow_id)
);

CREATE TABLE "project_bom"(
bim_id BIGINT,
bom_id BIGINT,
PRIMARY KEY (bim_id, bom_id)
);
