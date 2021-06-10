package com.marvel.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.models.MarvelCharacter;
import com.marvel.repositories.CharacterRepository;
import com.marvel.services.MarvelService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CharacterController {

	@Autowired
	MarvelService marvelService;
	@Autowired
	CharacterRepository characterRepository;
	
	
	@GetMapping("/characters/storageData")
	public JSONObject getCharactersListFromApi() throws NoSuchAlgorithmException, IOException, ParseException {
		JSONObject data_obj= marvelService.getCharactersList();
	    JSONObject obj = (JSONObject) data_obj.get("data");
	    List characterList= (List) obj.get("results");
	    MarvelCharacter character;
	    for(int i=0; i<characterList.size();i++) {
	    	JSONObject obj1 = (JSONObject) characterList.get(i);
	    	JSONObject thumbnail= (JSONObject) obj1.get("thumbnail");
	    	String image=   (String) thumbnail.get("path")+"."+ thumbnail.get("extension");
	    	//Date modifiedDate= convertStringToDate((String)obj1.get("modified"));
	    	//OffsetDateTime dateTimeOffset= OffsetDateTime.parse((String)obj1.get("modified"));
	    	//System.out.println(dateTimeOffset);
	    	character =  new MarvelCharacter((long) obj1.get("id"), (String) obj1.get("name"),(String) obj1.get("description"),image); 
	    	MarvelCharacter marvelChar= characterRepository.save(character);
	    }
	    return data_obj;
	}
	
	public Date convertStringToDate(String value) {
		//LocalDateTime dateTime = LocalDateTime.parse(value);
		/*2018-05-05T11:50:55
		2014-04-29T14:18:17-0400*/
		OffsetDateTime dateTimeOffset= OffsetDateTime.parse(value);
		
		System.out.println(dateTimeOffset);
		//Date out = (Date) Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
		return null;
	}
	@GetMapping("/characters")
	public List<MarvelCharacter> getCharactersListFromDB(){
		return characterRepository.findAll();
	}
	
	@GetMapping("/characters/{id}")
	public Optional<MarvelCharacter> getCharacterById(@PathVariable long id){
		return characterRepository.findById(id);
	}
	
	
}
