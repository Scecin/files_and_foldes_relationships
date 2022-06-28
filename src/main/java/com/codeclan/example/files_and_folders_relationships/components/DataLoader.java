package com.codeclan.example.files_and_folders_relationships.components;

import com.codeclan.example.files_and_folders_relationships.models.File;
import com.codeclan.example.files_and_folders_relationships.models.Folder;
import com.codeclan.example.files_and_folders_relationships.models.Person;
import com.codeclan.example.files_and_folders_relationships.repository.FileRepository;
import com.codeclan.example.files_and_folders_relationships.repository.FolderRepository;
import com.codeclan.example.files_and_folders_relationships.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    PersonRepository personRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Person mary = new Person("Mary");
        personRepository.save(mary);
        Person silvia = new Person("Silvia");
        personRepository.save(silvia);
        Person david = new Person("David");
        personRepository.save(david);
        Person peter = new Person("Peter");
        personRepository.save(peter);
        Person rachel = new Person("Rache");
        personRepository.save(rachel);

        Folder newProject = new Folder("New Project", mary);
        folderRepository.save(newProject);
        Folder contracts= new Folder("Contracts", silvia);
        folderRepository.save(contracts);
        Folder salesReport = new Folder("Sales Report", david);
        folderRepository.save(salesReport);
        Folder newStaff = new Folder("New Staff", peter);
        folderRepository.save(newStaff);
        Folder songs= new Folder("Top Songs", rachel);
        folderRepository.save(songs);


        File file1 = new File("First document", "txt", 1.8, newProject);
        fileRepository.save(file1);
        File file2 = new File("First document", "txt", 1.8, contracts);
        fileRepository.save(file2);
        File file3 = new File("First document", "txt", 1.8, salesReport);
        fileRepository.save(file3);
        File file4 = new File("First document", "txt", 1.8, songs);
        fileRepository.save(file4);
        File file5 = new File("First document", "txt", 1.8, newStaff);
        fileRepository.save(file5);

        newProject.addFile(file1);
        contracts.addFile(file2);
        newStaff.addFile(file3);
        songs.addFile(file4);
        salesReport.addFile(file5);
        folderRepository.save(newProject);

        mary.addFolder(newProject);
        silvia.addFolder(salesReport);
        david.addFolder(newStaff);
        peter.addFolder(songs);
        rachel.addFolder(contracts);
        personRepository.save(mary);
    }
}
