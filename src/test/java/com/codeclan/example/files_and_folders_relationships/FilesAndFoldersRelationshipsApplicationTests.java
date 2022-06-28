package com.codeclan.example.files_and_folders_relationships;

import com.codeclan.example.files_and_folders_relationships.models.Folder;
import com.codeclan.example.files_and_folders_relationships.models.File;
import com.codeclan.example.files_and_folders_relationships.models.Person;
import com.codeclan.example.files_and_folders_relationships.repository.FileRepository;
import com.codeclan.example.files_and_folders_relationships.repository.FolderRepository;
import com.codeclan.example.files_and_folders_relationships.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesAndFoldersRelationshipsApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	PersonRepository personRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createFolderAndPersonThenSave() {
		Person person = new Person("Mary");
		personRepository.save(person);
		Folder folder = new Folder("New Project", person);
		folderRepository.save(folder);
	}

	@Test
	public void createFolderAndPerson() {
		Person person = new Person("Mary");
		personRepository.save(person);
		Folder folder = new Folder("New Project", person);
		folderRepository.save(folder);

		File file = new File("First document", "txt", 1.8, folder);
		fileRepository.save(file);

		folder.addFile(file);
		person.addFolder(folder);
		folderRepository.save(folder);

	}

}
