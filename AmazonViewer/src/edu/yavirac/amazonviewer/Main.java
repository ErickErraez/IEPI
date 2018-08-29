package edu.yavirac.amazonviewer;

import edu.yavirac.amazonviewer.model.Book;
import edu.yavirac.amazonviewer.model.Chapter;
import edu.yavirac.amazonviewer.model.Magazine;
import edu.yavirac.amazonviewer.model.Movie;
import edu.yavirac.amazonviewer.model.Serie;
import edu.yavirac.makereport.Report;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		
		showMenu();
	}

	public static void showMenu() {
		int exit = 1;
		do {

			System.out.println("BIENVENIDOS AMAZON VIEWER");
			System.out.println("");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");
			System.out.println("Selecciona el n�mero de la opci�n deseada");

			// Leer la respuesta del usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());

			switch (response) {
			case 0:
				// salir
				exit = 0;
				break;
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
				break;
			case 6:
				// Date date = new Date();
				makeReport(new Date());
				break;

			default:
				System.out.println();
				System.out.println("....��Selecciona una opci�n!!....");
				System.out.println();
				break;
			}

		} while (exit != 0);
	}

	static ArrayList<Movie> movies = Movie.makeMoviesList();

	public static void showMovies() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			for (int i = 0; i < movies.size(); i++) {
				System.out.println(i + 1 + "." + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			}
			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta Usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());

			if (response == 0) {
				showMenu();
			}

			if (response > 0) {

				Movie movieSelected = movies.get(response - 1);
				movieSelected.setViewed(true);
				Date dateI = movieSelected.startToSee(new Date());

				for (int i = 0; i < 100000; i++) {
					System.out.println("........");
				}

				// Termine de Verla
				movieSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Viste: " + movieSelected);
				System.out.println("Por: " + movieSelected.getTimeViewed() + " milisegundos");

			}

		} while (exit != 0);

	}

	static ArrayList<Serie> series = Serie.makeSeriesList();

	public static void showSeries() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();

			for (int i = 0; i < series.size(); i++) { // 1. Serie 1
				System.out.println(i + 1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());

			if (response == 0) {
				exit = 0;
				showMenu();
			}

			if (response > 0) {
				showChapters(series.get(response - 1).getChapters());
			}

		} while (exit != 0);
	}

	public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();

			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { // 1. Chapter 1
				System.out.println(i + 1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: "
						+ chaptersOfSerieSelected.get(i).isViewed());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());

			if (response == 0) {
				showSeries();
			}

			Chapter chapterSelected = chaptersOfSerieSelected.get(response - 1);
			chapterSelected.setViewed(true);
			Date dateI = chapterSelected.startToSee(new Date());

			for (int i = 0; i < 100000; i++) {
				System.out.println("..........");
			}

			// Termine de verla
			chapterSelected.stopToSee(dateI, new Date());
			System.out.println();
			System.out.println("Viste: " + chapterSelected);
			System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
		} while (exit != 0);
	}

	static ArrayList<Book> books = Book.makeBookList();

	public static void showBooks() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();

			for (int i = 0; i < books.size(); i++) { // 1. Book 1
				System.out.println(i + 1 + ". " + books.get(i).getTitle() + " Le�do: " + books.get(i).isReaded());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());

			if (response == 0) {
				exit = 0;
				showMenu();
			}

			if (response > 0) {
				Book bookSelected = books.get(response - 1);
				bookSelected.setReaded(true);
				Date dateI = bookSelected.startToSee(new Date());

				for (int i = 0; i < 100000; i++) {
					System.out.println("..........");
				}

				// Termine de verla
				bookSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Le�ste: " + bookSelected);
				System.out.println("Por: " + bookSelected.getTimeReaded() + " milisegundos");
			}

		} while (exit != 0);
	}

	public static void showMagazines() {
		ArrayList<Magazine> magazines = Magazine.makeMagazineList();
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();

			for (int i = 0; i < magazines.size(); i++) { // 1. Book 1
				System.out.println(i + 1 + ". " + magazines.get(i).getTitle());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());

			if (response == 0) {
				showMenu();
			}

		} while (exit != 0);

	}

	public static void makeReport() {

		Report report = new Report();
		report.setNameFile("reporte");
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");
		String contentReport = "";

		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";

			}
		}
		for (Serie serie : series) {
			ArrayList<Chapter> chapters = serie.getChapters();
			for (Chapter chapter : chapters) {
				if (chapter.getIsViewed()) {
					contentReport += chapter.toString() + "\n";

				}
			}
		}

		for (Book book : books) {
			if (book.getIsReaded()) {
				contentReport += book.toString() + "\n";

			}
		}

		report.setContent(contentReport);
		report.makeReport();
		System.out.println("Reporte Generado");
		System.out.println();
	}

	public static void makeReport(Date date) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		Report report = new Report();

		report.setNameFile("reporte" + dateString);
		report.setExtension("txt");
		report.setTitle(":: VISTOS ::");

		SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM Y");
		dateString = dfNameDays.format(date);
		String contentReport = "Date: " + dateString + "\n\n\n";

		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";

			}
		}

		for (Serie serie : series) {
			ArrayList<Chapter> chapters = serie.getChapters();
			for (Chapter chapter : chapters) {
				if (chapter.getIsViewed()) {
					contentReport += chapter.toString() + "\n";

				}
			}
		}

		for (Book book : books) {
			if (book.getIsReaded()) {
				contentReport += book.toString() + "\n";

			}
		}
		report.setContent(contentReport);
		report.makeReport();

		System.out.println("Reporte Generado");
		System.out.println();
	}
}
