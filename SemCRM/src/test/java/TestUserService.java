import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.User;
import ru.kpfu.itis.PAVEL_VLADIMIROV.repository.UserRepository;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.UserServiceImpl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Павел on 26.05.2016.
 */
public class TestUserService {
    private static UserServiceImpl userService;
    private static User user;
    private static List<User> list;

    @BeforeClass
    public static void generation() {
        user = new User();
        userService = new UserServiceImpl();
        list = new List<User>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<User> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(User user) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends User> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends User> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public User get(int index) {
                return null;
            }

            @Override
            public User set(int index, User element) {
                return null;
            }

            @Override
            public void add(int index, User element) {

            }

            @Override
            public User remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<User> listIterator() {
                return null;
            }

            @Override
            public ListIterator<User> listIterator(int index) {
                return null;
            }

            @Override
            public List<User> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        userService.userRepository = mock(UserRepository.class);
        when(userService.userRepository.findByEmail(anyString())).thenReturn(user);
        when(userService.userRepository.getById(anyInt())).thenReturn(user);
        when(userService.userRepository.findAll()).thenReturn(list);

    }

    @Test
    public void getByEmailShouldWorkCorrect() {
        Assert.assertEquals(user, userService.getByEmail("name@mail.ru"));
    }

    @Test
    public void getByIdShouldWorkCorrect() {
        Assert.assertEquals(user, userService.getById(1));
    }

    @Test
    public void getAllShouldWorkCorrect() {
        Assert.assertEquals(list, userService.getAll());
    }


}
