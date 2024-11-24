package com.example.service1.service;

import com.example.service1.entity.Library;
import com.example.service1.repository.LibraryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

    @InjectMocks
    private LibraryService libraryService; 

    @Mock
    private LibraryRepository libraryRepository; 

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void whenSaveLibrary_shouldReturnLibrary() {
        Library library = new Library();
        library.setName("Test Library");

        when(libraryRepository.save(any(Library.class))).thenReturn(library);

        Library savedLibrary = libraryService.saveLibrary(library);

        assertNotNull(savedLibrary);
        verify(libraryRepository, times(1)).save(library);
    }
}