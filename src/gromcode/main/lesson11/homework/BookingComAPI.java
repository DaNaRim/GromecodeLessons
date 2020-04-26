package gromcode.main.lesson11.homework;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    //находит комнаты по заданным параметрам, а так же комнаты, которые по цене отличаются на 100 единиц в обе стороны.
    //Например если пользователь ищет комнату с ценой 50 и другими параметрами,
    //BookingComAPI вернет все комнаты с ценой в диапазоне 0 - 150

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] result = new Room[countRooms(price, persons, city, hotel)];

        int index = 0;
        for (Room room : rooms) {
            if (room != null && room.getPersons() == persons && room.getCityName().equals(city) &&
                    room.getHotelName().equals(hotel) && room.getPrice() >= (price - 100 > 0 ? price - 100 : 0) &&
                    room.getPrice() <= price + 100) {
                result[index] = room;
                index++;
            }
        }
        return result;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

    private int countRooms(int price, int persons, String city, String hotel) {
        int numberOfRooms = 0;
        for (Room room : rooms) {
            if (room != null &&
                    room.getPersons() == persons && room.getCityName().equals(city) &&
                    room.getHotelName().equals(hotel) && room.getPrice() >= (price - 100 > 0 ? price - 100 : 0) &&
                    room.getPrice() <= price + 100) {
                numberOfRooms++;
            }
        }
        return numberOfRooms;
    }
}