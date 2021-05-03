INSERT INTO PERSON_GEO_LOCATION
(id, creation_date, creation_user, last_modified_date, last_modified_user, version, address, district, department, country)
VALUES
('2ed16e2e-b4af-4e70-944a-3ee7e114967d', sysdate, 'ADMIN', sysdate, 'ADMIN', 1, 'Jr. Los Caimanes 123', 'San Juan', 'Lima', 'Peru');

INSERT INTO PERSON_GEO_LOCATION
(id, creation_date, creation_user, last_modified_date, last_modified_user, version, address, district, department, country)
VALUES
('f27e8efc-f871-4e3e-97d6-3afa7a903a49', sysdate, 'ADMIN', sysdate, 'ADMIN', 1, 'Calle Las Golondrinas 2512', 'Miraflores', 'San Jose', 'Costa Rica');

INSERT INTO PERSON
(id, creation_date, creation_user, last_modified_date, last_modified_user, version, first_name, first_last_name, document_type, document_number, geo_location_id)
values
('938bcae4-a486-11eb-bcbc-0242ac130002', sysdate, 'ADMIN', sysdate, 'ADMIN', 1, 'Diego', 'Zavala', 'DNI', '25987752',
'f27e8efc-f871-4e3e-97d6-3afa7a903a49');

INSERT INTO PERSON
(id, creation_date, creation_user, last_modified_date, last_modified_user, version, first_name, first_last_name, document_type, document_number, geo_location_id)
values
('a1e7aa36-a486-11eb-bcbc-0242ac130002', sysdate, 'ADMIN', sysdate, 'ADMIN', 1, 'Juan', 'Perez', 'CEX', '10254498',
'f27e8efc-f871-4e3e-97d6-3afa7a903a49');

INSERT INTO PERSON
(id, creation_date, creation_user, last_modified_date, last_modified_user, version, first_name, first_last_name, document_type, document_number, geo_location_id)
values
('ae5437bb-96aa-43de-b1cd-2750cdf58f0d', sysdate, 'ADMIN', sysdate, 'ADMIN', 1, 'Julio', 'Gutierrez', 'DNI', '15226357',
'2ed16e2e-b4af-4e70-944a-3ee7e114967d');

