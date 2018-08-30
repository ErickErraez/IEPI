package edu.yavirac.amazonviewer.dao;

import java.util.ArrayList;

import edu.yavirac.amazonviewer.model.Movie;

//CREAR METODO CRUD DE MOVIES
public interface MovieDAO {

	default Movie setMovieViewed(Movie movie) {
		return movie;
	}

	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList<>();
		return movies;
	}

	// PRIVATE EN VEZ DE PUBLIC PRIVATE DISPONIBLE DESDE LA VERSION 9 DE JAVA
	public static boolean getMovieViewed() {
		return false;
	}

}
