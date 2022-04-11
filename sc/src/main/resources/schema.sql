CREATE TABLE CLIENT(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(64),
  last_name VARCHAR(64),
  email_address VARCHAR(64),
  address VARCHAR(64),
  city VARCHAR(64),
  country VARCHAR(64),
  phone_number VARCHAR(24),
  dc_partner VARCHAR(64),
  company_name VARCHAR(64),
  contact_type VARCHAR(64),
  apex_contact VARCHAR(64)
);