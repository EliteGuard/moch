#Create Databases
CREATE DATABASE moch_dev;
CREATE DATABASE moch_prod;

#Create database service accounts
CREATE USER 'moch_dev_user'@'%' IDENTIFIED BY 'sspumoch';
CREATE USER 'moch_prod_user'@'%' IDENTIFIED BY 'sspumoch';

#Database grants
GRANT SELECT ON moch_dev.* to 'moch_dev_user'@'%';
GRANT INSERT ON moch_dev.* to 'moch_dev_user'@'%';
GRANT DELETE ON moch_dev.* to 'moch_dev_user'@'%';
GRANT UPDATE ON moch_dev.* to 'moch_dev_user'@'%';
GRANT SELECT ON moch_prod.* to 'moch_prod_user'@'%';
GRANT INSERT ON moch_prod.* to 'moch_prod_user'@'%';
GRANT DELETE ON moch_prod.* to 'moch_prod_user'@'%';
GRANT UPDATE ON moch_prod.* to 'moch_prod_user'@'%';