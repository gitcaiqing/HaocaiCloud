DROP TABLE IF EXISTS tb_ticket_category;
CREATE TABLE tb_ticket_category(
    id BIGINT NOT NULL AUTO_INCREMENT,
    tc_uuid VARCHAR(32) NOT NULL,
    name VARCHAR(50),
    PRIMARY KEY(id)
);
INSERT INTO tb_ticket_category(id, tc_uuid, name) values
(1, 'ddfdafadfdgadggadfa','TEST_DLT'),
(2, 'dvgsgsdgdgsfsfdgfgg','TEST_SSC');