package com.miit.crud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Operation {

	public static void addPerson() {
		try {
			GetConnection.getConnection().setAutoCommit(false);

			PreparedStatement ps = GetConnection.getConnection().prepareStatement("insert into persons values(?,?,?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("enter id: ");
			String s1 = br.readLine();
			int id = Integer.parseInt(s1);

			System.out.print("enter first name: ");
			String fname = br.readLine();

			System.out.print("enter last name: ");
			String lname = br.readLine();

			System.out.print("enter address: ");
			String add = br.readLine();

			System.out.print("enter city: ");
			String city = br.readLine();

			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, add);
			ps.setString(5, city);
			
			System.out.print("commit/rollback :: ");
			String answer = br.readLine();
			if (answer.equals("commit")) {
				GetConnection.getConnection().commit();
			}
			if (answer.equals("rollback")) {
				GetConnection.getConnection().rollback();
			}
			
			ps.executeUpdate();
			GetConnection.getConnection().commit();
			
			System.out.println("recoed successfully saved in DB::\n");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void showPerson() {
		try {
			String query = "select * from persons";
			Statement st = GetConnection.getConnection().createStatement();
			ResultSet rs = st.executeQuery(query);
			
			System.out.println("PersonID" + " " + "FirstName" + " " + "LastName" + " " + "Address" + " " + "City");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getString(5));
			}
			System.out.println("");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void updatePerson() {
		try {
			GetConnection.getConnection().setAutoCommit(false);

			PreparedStatement ps = GetConnection.getConnection().prepareStatement("update persons set FirstName = ?, LastName = ?, Address = ?, City = ? where PersonID = ?");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("enter id no to be update: ");
			String s1 = br.readLine();
			int id = Integer.parseInt(s1);

			System.out.print("enter new first name: ");
			String fname = br.readLine();

			System.out.print("enter new last name: ");
			String lname = br.readLine();

			System.out.print("enter new address: ");
			String add = br.readLine();

			System.out.print("enter new city: ");
			String city = br.readLine();

			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, add);
			ps.setString(4, city);
			ps.setInt(5, id);

			System.out.print("commit/rollback :: ");
			String answer = br.readLine();
			if (answer.equals("commit")) {
				GetConnection.getConnection().commit();
			}
			if (answer.equals("rollback")) {
				GetConnection.getConnection().rollback();
			}
			
			ps.executeUpdate();
			GetConnection.getConnection().commit();
			
			System.out.println("recoed successfully updated::\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removePerson() {
		try {
			GetConnection.getConnection().setAutoCommit(false);
			
			PreparedStatement ps = GetConnection.getConnection().prepareStatement("delete from persons where PersonID = ?");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("enter id to be remove: ");
			String s1 = br.readLine();
			int id = Integer.parseInt(s1);

			ps.setInt(1, id);

			System.out.print("commit/rollback :: ");
			String answer = br.readLine();

			if (answer.equals("commit")) {
				GetConnection.getConnection().commit();
			}
			if (answer.equals("rollback")) {
				GetConnection.getConnection().rollback();
			}

			ps.executeUpdate();
			GetConnection.getConnection().commit();

			System.out.println("recoed successfully removed::\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
