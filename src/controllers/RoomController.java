package controllers;

import models.Room;
import repositories.RoomRepo;
import service.RoomService;
import ultils.Input;
import views.ViewApartment;

import java.util.List;

public class RoomController {
    private final RoomRepo roomRepo = new RoomRepo();
    private final RoomService roomService = new RoomService();
    private final ViewApartment view = new ViewApartment();
    public List<Room> rooms;

    public void menuRoom(){
        List<Room> roomList;
        int choice;
        while (true){
            System.out.println("========MENU ROOM========\n" +
                    "1. Display room list\n" +
                    "2. Add new room\n" +
                    "3. Update room\n" +
                    "4. Delete room\n " +
                    "5. Return main menu\n" +
                    "Choose activity: ");
            choice = Input.getInt();
            switch (choice){
                case 1:
                    roomList = roomRepo.getAllRoom();
                    view.displayAllRoom(roomList);
                    break;
                case 2:
                    Room room = view.addRoom();
                    roomRepo.addRoom(room);
                    break;
                case 3:
                    view.showUpdateRoom();
                    updateRoom();
                    break;
                case 4:
                    String roomNumber = view.viewDelete();
                    if (view.confirm()){
                        roomRepo.deleteRoom(roomNumber);
                        System.out.println("===+> Delete Successfully");
                    } else {
                        System.out.println("There are no rooms to delete, please add more rooms!!");
                    }

                    break;
                case 5:
                    return;
                default:
                    System.out.println("This choice is not available!!");
                    break;
            }
        }
    }

    public void updateRoom(){
        String number = view.findRoom();
        Room room = roomService.findRoomByRoomNumber(number);
        int choice = view.showUpdateRoom();
        switch (choice){
            case 1:
                int index = roomRepo.Index(room);
                Room room1 = roomRepo.updateTypeRoom(room);
                roomRepo.editIndex(index, room1);
                break;
            case 2:
                int index1 = roomRepo.Index(room);
                Room room2 = roomRepo.updatePrice(room);
                roomRepo.editIndex(index1,room2);
                break;
            case 3:
                menuRoom();
                break;
            default:
                System.out.println("This choice is not available!!");
                break;
        }
    }
}
