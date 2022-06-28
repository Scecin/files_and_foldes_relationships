package com.codeclan.example.files_and_folders_relationships.repository;

import com.codeclan.example.files_and_folders_relationships.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
