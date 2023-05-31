package com.tondoy.files_and_folders.repositories;

import com.tondoy.files_and_folders.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
