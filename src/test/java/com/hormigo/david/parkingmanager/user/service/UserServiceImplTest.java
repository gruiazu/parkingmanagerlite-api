package com.hormigo.david.parkingmanager.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.hormigo.david.parkingmanager.core.exceptions.UserExistsException;
import com.hormigo.david.parkingmanager.user.domain.Role;
import com.hormigo.david.parkingmanager.user.domain.User;
import com.hormigo.david.parkingmanager.user.domain.UserDao;
import com.hormigo.david.parkingmanager.user.domain.UserRepository;

public class UserServiceImplTest {
    @Test
    void testGetAll() {
        final List<User> expected = new ArrayList<>();
        expected.add(new User("david@correo", "David", "Hormigo", "Ramirez", Role.PROFESSOR));
        final UserRepository mockedRepository = mock(UserRepository.class);
        when(mockedRepository.findAll()).thenReturn(expected);
        final UserService service = new UserServiceImpl(mockedRepository);
        final List<User> actual = (List<User>) service.getAll();
        assertEquals(expected, actual);
    }

    @Test
    void testUserDoesNotExists() {
        // Arrange
        UserRepository mockRepository = mock(UserRepository.class);
        UserDao userDao = new UserDao("david@correo", "David", "Hormigo", "Ramírez", Role.PROFESSOR);
        when(mockRepository.findByEmail("david@correo")).thenReturn(null);

        UserService service = new UserServiceImpl(mockRepository);

        // Act
        try {
            service.register(userDao);
        } catch (UserExistsException exception) {
            fail();
        }
        verify(mockRepository).save(any(User.class));

    }

    @Test
    void testUserAlreadyExists() {
        // Arrange
        UserRepository mockRepository = mock(UserRepository.class);
        UserDao userDao = new UserDao("david@correo", "David", "Hormigo", "Ramírez", Role.PROFESSOR);
        when(mockRepository.findByEmail("david@correo"))
                .thenReturn(new User("david@correo", "David", "Hormigo", "Ramírez", Role.PROFESSOR));

        UserService service = new UserServiceImpl(mockRepository);
        // Act y assert
        assertThrows(UserExistsException.class,
                () -> {
                    service.register(userDao);
                });

    }

    @Test
    void userDoesNotExists(){
      // Arrange
        UserRepository mockRepository = mock(UserRepository.class);
      //UserDao userDao = new UserDao("david@correo", "David", "Hormigo", "Ramírez", Role.PROFESSOR);
        when(mockRepository.findByEmail("david@correo")).thenReturn(null);

        UserService service = new UserServiceImpl(mockRepository);

        assertFalse(service.userExists("david@correo"));
    }

        @Test
        void userExists() {
        // Arrange
        UserRepository mockRepository = mock(UserRepository.class);
        //UserDao userDao = new UserDao("david@correo", "David", "Hormigo", "Ramírez", Role.PROFESSOR);
        when(mockRepository.findByEmail("david@correo"))
                .thenReturn(new User("david@correo", "David", "Hormigo", "Ramírez", Role.PROFESSOR));
        
        UserService service = new UserServiceImpl(mockRepository);
        assertTrue(service.userExists("david@correo"));
    }

}
