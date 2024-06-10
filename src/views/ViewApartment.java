package views;

import models.Booking;
import models.Room;
import ultils.Input;
import ultils.Validate;

import java.util.List;

public class ViewApartment {

    Validate validate = new Validate();

    public void displayAllRoom(List<Room> rooms) {
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }

    public Room addRoom() {
        String roomNumber = "R-" + (int) (Math.random() * 100);
        String typeRoom = validate.inputNewTypeRoom();
        double price = validate.inputValidPrice();
        Room room = new Room(roomNumber, typeRoom, price);
        System.out.println("===+> Add Success!!");
        return room;
    }

    public int showUpdateRoom() {
        System.out.println("1. Edit Type Room\n" +
                "2. Edit Price\n" +
                "3. Turn around\n" +
                "Select activity");
        int choice = Input.getInt();
        return choice;
    }

    public String findRoom() {
        System.out.println("Enter Room Number: ");
        String roomNumber = Input.getString();
        return roomNumber;
    }

    public boolean confirm() {
        do {
            System.out.println("Enter 'Y' to delete, 'N' to cancel");
            String confirm = Input.getString();
            if (confirm.equalsIgnoreCase("Y")) {
                return true;
            } else if (confirm.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Your selection is not valid!");
            }
        } while (true);
    }

    public String viewDelete() {
        System.out.println("Enter Room Number u want to remove:");
        return Input.getString();
    }

    public String viewGetRoomNumber() {
        System.out.println("Enter room number you want to booking: ");
        return Input.getString();
    }
    public Booking add(Room room){
        do {
            String bookingCode = "BK-" + (int) (Math.random() * 1000);

            System.out.println("Enter guest name: ");
            String guestName = Input.getString();
            System.out.println("Enter day check in(dd-MM-yyyy): ");
            String checkIn = Input.getString();
            System.out.println("Enter day check out(dd-MM-yyyy): ");
            String checkOut = Input.getString();
            System.out.println("Enter payment status(paid/unpaid): ");
            String status = Input.getString().toLowerCase();
            if (!status.equals("paid") && !status.equals("unpaid")) {
                continue;
            }
            return new Booking(room, bookingCode, guestName,checkIn,checkOut,status);
        } while (true);
    }

    public void viewRoomNotFound() {
        System.out.println("Room not found!");
    }
}
