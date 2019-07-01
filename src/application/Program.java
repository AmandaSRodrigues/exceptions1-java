package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-in dade (dd/MM/yyyy: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out dade (dd/MM/yyyy: ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-ut date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
		
			System.out.println();
			System.out.println("Enter data to updae the reservation:");
		
			System.out.println("Room number: ");
			number = sc.nextInt();
			System.out.println("Check-in dade (dd/MM/yyyy: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out dade (dd/MM/yyyy: ");
			checkOut = sdf.parse(sc.next());
		
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation:" + reservation);
		}
		sc.close();
	}

}
