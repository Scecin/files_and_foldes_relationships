package com.codeclan.example.files_and_folders_relationships.repository;

import com.codeclan.example.files_and_folders_relationships.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long> {
}
