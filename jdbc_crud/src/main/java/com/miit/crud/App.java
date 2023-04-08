package com.miit.crud;


//SQL Quesries used in this project
//create table persons(personID int(10) PRIMARY KEY, FirstName varchar(20), LastName varchar(20), Address varchar(50), City varchar(15));

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Choose your operation::\nSelect 1 for add person\nselect 2 for show persons\nselect 3 for update person by ID\nselect 4 for remove person by ID\nselect 5 for exit\n");
			try {
				int choice = Integer.parseInt(br.readLine());
				if (choice == 1) {
					Operation.addPerson();
				} else if (choice == 2) {
					Operation.showPerson();
				} else if (choice == 3) {
					Operation.updatePerson();
				} else if (choice == 4) {
					Operation.removePerson();
				} else if (choice == 5) {
					System.out.println("Thank you!!");
					break;
				} else {
					System.out.println("Invalid selection:: ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
