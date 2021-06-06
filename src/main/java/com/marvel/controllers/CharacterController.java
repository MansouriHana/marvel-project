package com.marvel.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.services.MarvelService;

@RestController
public class CharacterController {

	@Autowired
	MarvelService marvelService;
	
	@GetMapping("/characters")
	public JSONObject getCharactersList() throws NoSuchAlgorithmException, IOException, ParseException {
		JSONObject data_obj= marvelService.getCharactersList();
	    JSONObject obj = (JSONObject) data_obj.get("data");
	    System.out.println(obj.get("results"));
	    return data_obj;
	}
}
