package com.example.nycseca.repositories;

import com.example.nycseca.models.User;
import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User firstUser = new User(
                "user_name",
                "some first name",
                "some last name"
        );

        User secondUser = new User(
                "second_user",
                "some other first name",
                "some other last name"
        );

        entityManager.persist(firstUser);
        entityManager.persist(secondUser);
        entityManager.flush();
    }

    @Test
    public void findAll_returnsAllUsers() {
        Iterable<User> usersFromDb = userRepository.findAll();

        assertThat(Iterables.size(usersFromDb), is(2));
    }

    @Test
    public void findAll_returnsUserName() {
        Iterable<User> usersFromDb = userRepository.findAll();

        String secondUsersUserName = Iterables.get(usersFromDb, 1).getUserName();

        assertThat(secondUsersUserName, is("second_user"));
    }

    @Test
    public void findAll_returnsFirstName() {
        Iterable<User> usersFromDb = userRepository.findAll();

        String secondUsersFirstName = Iterables.get(usersFromDb, 1).getFirstName();

        assertThat(secondUsersFirstName, is("some other first name"));
    }

    @Test
    public void findAll_returnsLastName() {
        Iterable<User> usersFromDb = userRepository.findAll();

        String secondUsersLastName = Iterables.get(usersFromDb, 1).getLastName();

        assertThat(secondUsersLastName, is("some other last name"));
    }
}