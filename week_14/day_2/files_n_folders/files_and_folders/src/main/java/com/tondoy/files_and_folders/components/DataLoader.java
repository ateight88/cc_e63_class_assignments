package com.tondoy.files_and_folders.components;

import com.tondoy.files_and_folders.models.File;
import com.tondoy.files_and_folders.models.Folder;
import com.tondoy.files_and_folders.models.Person;
import com.tondoy.files_and_folders.repositories.FileRepository;
import com.tondoy.files_and_folders.repositories.FolderRepository;
import com.tondoy.files_and_folders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test") //Run every time EXCEPT Tests
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Person bob = new Person("Bob");
        personRepository.save(bob);

        Person harry = new Person("Harry");
        personRepository.save(harry);

        Person jane = new Person("Jane");
        personRepository.save(jane);

        Folder folder1 = new Folder("Bob's Documents", bob);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Harry's Spreadsheets", harry);
        folderRepository.save(folder2);

        Folder folder3 = new Folder("Jane's Pictures", jane);
        folderRepository.save(folder3);

        Folder folder4 = new Folder("Memes", jane);
        folderRepository.save(folder4);

        File file1 = new File("Groceries List", ".txt", 100, folder1);
        fileRepository.save(file1);

        File file2 = new File("Coding Notes", ".docx", 12345, folder1);
        fileRepository.save(file2);

        File file3 = new File("Charts", ".xls", 5, folder2);
        fileRepository.save(file3);

        File file4 = new File("Stats Record", ".csv", 98724, folder2);
        fileRepository.save(file4);

        File file5 = new File("Image", ".png", 100000000, folder3);
        fileRepository.save(file5);

        File file6 = new File("Picture", ".jpeg", 127486, folder3);
        fileRepository.save(file6);

        File file7 = new File("Slightly Smiling", ".gif", 99999999, folder4);
        fileRepository.save(file7);

    }
}