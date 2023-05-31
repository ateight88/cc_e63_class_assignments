package com.tondoy.files_and_folders.repositories;

import com.tondoy.files_and_folders.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
