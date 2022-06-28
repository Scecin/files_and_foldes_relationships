package com.codeclan.example.files_and_folders_relationships.repository;

import com.codeclan.example.files_and_folders_relationships.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
