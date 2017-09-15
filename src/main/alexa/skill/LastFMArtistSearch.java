package main.alexa.skill;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import generated.GeoArtist;

public class LastFMArtistSearch {
	// Api Key for LastFM api
	private final String API_KEY = "443dbedaa3a878fd0ddd50d469ef77cf";
	// API Root URL
	private final String ROOT_URL = "http://ws.audioscrobbler.com/2.0/?";
	// Limit for the answers
	public final String LIMIT = "3"; // minimum is 3
	// Generated InfoArtist Obj
	private GeoArtist obj;
	// Artist
	private String artist;

	// Constructor
	public LastFMArtistSearch(String artist) {
		this.artist = artist;
		ObjectMapper mapper = new ObjectMapper();
		String queryUrl = getQueryStringGeoArtist(artist);

		try {
			obj = mapper.readValue(new URL(queryUrl), GeoArtist.class);
		} catch (IOException e) {
			// e.printStackTrace();
			//boolRetrieval = true;
		}
	}


	/**
	 * This Method builds the LAST FM Query String for the api-method
	 * "getartistinfo"
	 * 
	 * @author mbeckert
	 * @param artist
	 * @return String queryurl
	 */
	@SuppressWarnings("deprecation")
	private String getQueryStringGeoArtist(String country) {
		String queryUrl = ROOT_URL + "method=geo.gettopartists&country=" + country + "&limit=" + LIMIT + "&api_key="
				+ API_KEY + "&format=json";
		// Sometimes there is an error with spaces and the lastfm api
		queryUrl = queryUrl.replace(" ", "+");
		return queryUrl;
	}
	//
	 public static void main(String[] args) {
	 GeoArtist geoArtist = new GeoArtist();
	 }
}
