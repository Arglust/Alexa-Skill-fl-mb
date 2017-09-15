package main.alexa.skill;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.amazonaws.services.route53domains.model.CountryCode;
import com.fasterxml.jackson.databind.ObjectMapper;

import generated.Artist;
import generated.GeoArtist;

public class LastFMArtistSearch {
	// Api Key for LastFM api
	private final static String API_KEY = "443dbedaa3a878fd0ddd50d469ef77cf";
	// API Root URL
	private final static String ROOT_URL = "http://ws.audioscrobbler.com/2.0/?";
	// Limit for the answers
	public final static String LIMIT = "200"; // minimum is 3

	private static String[] counrtyList = { "germany", "france", "united+states", "United Kingdom" };

	private ArrayList<String> artistList;

	public ArrayList<String> getArtistList() {
		return artistList;
	}

	// Constructor
	public LastFMArtistSearch() {

	}

	public static ArrayList<String> generateArtistList() {
		ArrayList<String> artistList = new ArrayList<String>();
		int i = 0;
		while (i < counrtyList.length) {
			String queryUrl = ROOT_URL + "method=geo.gettopartists&country=" + counrtyList[i] + "&limit=" + LIMIT + "&api_key="
					+ API_KEY + "&format=json";
			// Sometimes there is an error with spaces and the lastfm api
			queryUrl = queryUrl.replace(" ", "+");
			ObjectMapper mapper = new ObjectMapper();
			GeoArtist obj =null;
			try {
				obj = mapper.readValue(new URL(queryUrl), GeoArtist.class);
			} catch (IOException e) {
				e.printStackTrace();
				// boolRetrieval = true;
			}

			for (Artist a : obj.topartists.artist) {
				if (!artistList.contains(a.name.toLowerCase())) {
					artistList.add(a.name.toLowerCase());
					// System.out.println(a.name);
					
				}
			}
			i++;
		}
		for (String a : artistList) {
			System.out.println("{\r\n" + 
					"          \"id\": null,\r\n" + 
					"          \"name\": {\r\n" + 
					"            \"value\": \""+a+"\",\r\n" + 
					"            \"synonyms\": []\r\n" + 
					"          }\r\n" + 
					"        },");
		}
		
	//	System.out.println(artistList.toString());
	//	System.out.println(artistList.size());
		return artistList;
	}

	//
	public static void main(String[] args) {
		// LastFMArtistSearch lastfmgeo = new LastFMArtistSearch();

		generateArtistList();
	}
}
