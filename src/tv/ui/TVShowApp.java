package tv.ui;

import java.util.List;

import tv.business.Show;
import tv.business.ShowDB;
import tv.util.Console;

public class TVShowApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the TV Show DB App!\n");
		ShowDB showDB = new ShowDB();
		String command = "";
		while (!command.equalsIgnoreCase("3")) {
			displayMenu();

			command = Console.getString("Enter Command: ");
			if (command.equals("1")) {
				List<Show> shows = showDB.getAll();
				for (Show s : shows) {
					System.out.println(s);
				}
				System.out.println();
			} else if (!command.equals("3")) {
				System.out.println("Invalid Command. Try Again.\n");
			}
		}
		System.out.println();
		System.out.println("Goodbye!");
	}

	private static void displayMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Command Menu\n");
		sb.append("1 - List TV Shows\n");
		sb.append("2 - Find Shows\n");
		sb.append("3 - Exit Program\n");
		System.out.println(sb);
	}
}
