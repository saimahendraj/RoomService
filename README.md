# RoomService
Book Room with bonus points

Sample data is inserted for ease of starting.
INSERT INTO HOTEL (HOTEL_NAME, ROOM_NUMBER, ROOM_PRICE, STATUS) VALUES ('Ags', '10', 90, 0);
INSERT INTO HOTEL (HOTEL_NAME, ROOM_NUMBER, ROOM_PRICE, STATUS) VALUES ('Ags', '11', 110, 0);
INSERT INTO USER (NAME, BONUS_POINTS) VALUES ('Sai', 100);
INSERT INTO USER (NAME, BONUS_POINTS) VALUES ('Mahendra', 50);

Bring the spring boot application with the below command from the root path of the application
mvn spring-boot:run

Access the swagger URL from below
http://localhost:8080/swagger-ui/index.html#/

Request Object for Successfully booking
curl -X POST "http://localhost:8080/reserve" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"hotelName\": \"Ags\", \"roomNumber\": \"10\", \"userId\": 1, \"userName\": \"Sai\"}"


Request Object for Pending booking
curl -X POST "http://localhost:8080/reserve" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"hotelName\": \"Ags\", \"roomNumber\": \"11\", \"userId\": 2, \"userName\": \"Mahendra\"}"

There are endpoints to check the status of the room, fetch the user or Room by id several others