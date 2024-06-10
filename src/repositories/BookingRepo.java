package repositories;

import models.Booking;
import models.Room;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingRepo {
    private final String PATH_CODE = "src/data/booking.csv";


    public void add(Booking booking){
        List<Booking> bookings = getAll();
        bookings.add(booking);
        writeFileToBookingCSV(bookings, true);
    }
    public List<Booking> getAll(){
        List<Booking> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH_CODE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Booking booking = new Booking(new Room(data[0],data[1],Double.parseDouble(data[2])),data[3],data[4],
                        data[5],data[6], data[7]);
                list.add(booking);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        return list;
    }
    public void writeFileToBookingCSV(List<Booking> bookings, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(PATH_CODE, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking : bookings) {
                bufferedWriter.write(toString(booking));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String toString(Booking booking) {
        return  booking.getRoom().getRoomNumber() + "," +
                booking.getRoom().getTypeRoom() + "," +
                booking.getRoom().getPrice() +"," +
                booking.getCode() + "," +
                booking.getGuestName() + "," +
                booking.getCheckIn() + "," +
                booking.getCheckOut() + "," +
                booking.getStatus();
    }


}

