package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class UserStoreTest {
    UserStore userStore = new UserStore();

    @Before
    public void setUp() {
        User user1 = new User("id1");
        User user2 = new User("id2");
        User user3 = new User("id3");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
    }

    @Test
    public void testAdd() {
        assertThat(userStore.get(0), is("id1"));
        assertThat(userStore.get(1), is("id2"));
        assertThat(userStore.get(2), is("id3"));
    }

    @Test
    public void testReplace() {
        User user4 = new User("id4");
        userStore.replace("id2", user4);
        assertThat(userStore.get(0), is("id1"));
        assertThat(userStore.get(1), is("id4"));
        assertThat(userStore.get(2), is("id3"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDelete() {
        userStore.delete("id2");
        assertThat(userStore.get(0), is("id1"));
        assertThat(userStore.get(1), is("id3"));
        userStore.get(2);
    }

    @Test
    public void testFindById() {
        UserStore userStore = new UserStore();
        User user1 = new User("id1");
        User user2 = new User("id2");
        User user3 = new User("id3");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        assertThat(userStore.findById("id1"), is(user1));
        assertThat(userStore.findById("id2"), is(user2));
        assertThat(userStore.findById("id3"), is(user3));
        assertNull(userStore.findById("id4"));
    }

}
