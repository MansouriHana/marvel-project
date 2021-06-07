package com.marvel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marvel.models.MarvelCharacter;

@Repository
public interface CharacterRepository extends JpaRepository<MarvelCharacter,Long> {
	
	
}
