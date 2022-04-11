CREATE TABLE CLIENT(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  employee VARCHAR(64),
  email_address VARCHAR(64),
  city VARCHAR(64),
  country VARCHAR(64),
  phone_number VARCHAR(24),
  spoke_to_dc VARCHAR(50),
  dc_partner VARCHAR(64),
  relationship_strength DECIMAL(10,2),
  company_name VARCHAR(64),
  contact_method VARCHAR(64)
);