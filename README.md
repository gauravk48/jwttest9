# jwttest9

## How to build
mvn clean package

## How to run
java -jar target/jwttestmain.jar &lt;options>

## Generate Secret Key
java -k <key_length>

Example:
java -k 340

## Use the secret key to generate the Jwt Token using HS256 algorith
java -c &lt;usernmae> &lt;secret>
  
Example:
You can use the secret generataed from previous step as secret.
java -c gauravk48 HoC8o3xeg0BiIzdFWA51e5ktQbg9I0DE9jqc9turdzegD4cIswij2R55oJCfnsWYBhEKfhHUFyZRPGxeiiE8T0HwmDsu4MDg4kPjFGYIcRQF3M7xTVDEca1yvcuG9CgTMEHrF5I0Emx13gU4aVZzzktyprZirr6UBOmJ2RNtUDrEEgnX6gJwEAuE6h0Ga4MVBvJGujXT2FbZiYDvmSOntTyJrtYwUeQbwebRWQ0bwqV8k46MISrJG3GdjI7I4T3N8wCDEi93B58bcKKHpdZqGwppbxMJPiuWjXSxCXnQEBuFgeWSsD1maFSVDUgj8E5rV216mw1Ksr2F0uD6bbT5

This will generate the new jwt token which can be used to validate now. For e.g.
eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnYXVyYXZrNDgiLCJpYXQiOjE1OTc3NzUxNzEsImV4cCI6MTU5NzgwMzM3MSwic3ViIjoiZ2F1cmF2IiwidHlwZSI6ImFjY2VzcyJ9.pupUg6_81cL_PDQommICnziqCe2dKzbcBcTsSk40DsQ

## Validate the generated token using HS256 Algorithm
java -v &lt;username> &lt;secret> &lt;token>

Example:
java -v gauravk48 HoC8o3xeg0BiIzdFWA51e5ktQbg9I0DE9jqc9turdzegD4cIswij2R55oJCfnsWYBhEKfhHUFyZRPGxeiiE8T0HwmDsu4MDg4kPjFGYIcRQF3M7xTVDEca1yvcuG9CgTMEHrF5I0Emx13gU4aVZzzktyprZirr6UBOmJ2RNtUDrEEgnX6gJwEAuE6h0Ga4MVBvJGujXT2FbZiYDvmSOntTyJrtYwUeQbwebRWQ0bwqV8k46MISrJG3GdjI7I4T3N8wCDEi93B58bcKKHpdZqGwppbxMJPiuWjXSxCXnQEBuFgeWSsD1maFSVDUgj8E5rV216mw1Ksr2F0uD6bbT5 eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnYXVyYXZrNDgiLCJpYXQiOjE1OTc3NzUxNzEsImV4cCI6MTU5NzgwMzM3MSwic3ViIjoiZ2F1cmF2IiwidHlwZSI6ImFjY2VzcyJ9.pupUg6_81cL_PDQommICnziqCe2dKzbcBcTsSk40DsQ

