import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    boolean isBooked;

    Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            rooms.add(new Room(i));
        }

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Rooms");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (Room room : rooms) {
                        if (!room.isBooked) {
                            System.out.println("Room " + room.roomNumber);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Room Number to Book: ");
                    int bookRoom = sc.nextInt();

                    for (Room room : rooms) {
                        if (room.roomNumber == bookRoom) {
                            if (!room.isBooked) {
                                room.isBooked = true;
                                System.out.println("Room Booked Successfully!");
                            } else {
                                System.out.println("Room Already Booked!");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel: ");
                    int cancelRoom = sc.nextInt();

                    for (Room room : rooms) {
                        if (room.roomNumber == cancelRoom) {
                            if (room.isBooked) {
                                room.isBooked = false;
                                System.out.println("Booking Cancelled Successfully!");
                            } else {
                                System.out.println("Room is Not Booked!");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nRoom Status:");
                    for (Room room : rooms) {
                        System.out.println(
                                "Room " + room.roomNumber +
                                " - " +
                                (room.isBooked ? "Booked" : "Available"));
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}