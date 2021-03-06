package Project.demo;

import Project.controller.RoomController;
import Project.controller.UserController;
import Project.exception.BadRequestException;
import Project.exception.InternalServerException;
import Project.exception.NoAccessException;
import Project.model.Filter;
import Project.model.Hotel;
import Project.model.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoRoom {
    private static RoomController roomController = new RoomController();
    private static UserController userController = new UserController();


    public static void main(String[] args)
            throws BadRequestException, NoAccessException, InternalServerException, ParseException {

        userController.login("Oleg", "wf45a4w44f");

        userController.login("DaNaRim", "f5urhg%89aohfol347hgfv93");

        Hotel hotel = new Hotel(8931379287882549163L, "SuperHotel", "Ukraine", "TestCity",
                "TestStreet");
        Room room = new Room(3, 150.40, false, true,
                new Date(), hotel);

        roomController.addRoom(room);


        Filter filter = new Filter(0, 0.0, true, true,
                new SimpleDateFormat("dd.MM.yyyy").parse("25.02.2020"),
                "Ukraine", null);

        System.out.println(roomController.findRooms(filter).toString());

        roomController.deleteRoom(4979440108398463469L);
    }
}