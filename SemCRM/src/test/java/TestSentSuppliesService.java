import org.junit.BeforeClass;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.SentSupplies;
import ru.kpfu.itis.PAVEL_VLADIMIROV.service.SentSuppliesServiceImpl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Павел on 26.05.2016.
 */
public class TestSentSuppliesService {
    private static SentSupplies supply;
    private static SentSuppliesServiceImpl suppliesService;
    private static List<SentSupplies> suppliesList;

    @BeforeClass
    public static void generation() {
        supply = new SentSupplies();
        suppliesService = new SentSuppliesServiceImpl();
        suppliesList = new List<SentSupplies>() {
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
            public Iterator<SentSupplies> iterator() {
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
            public boolean add(SentSupplies sentSupplies) {
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
            public boolean addAll(Collection<? extends SentSupplies> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends SentSupplies> c) {
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
            public SentSupplies get(int index) {
                return null;
            }

            @Override
            public SentSupplies set(int index, SentSupplies element) {
                return null;
            }

            @Override
            public void add(int index, SentSupplies element) {

            }

            @Override
            public SentSupplies remove(int index) {
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
            public ListIterator<SentSupplies> listIterator() {
                return null;
            }

            @Override
            public ListIterator<SentSupplies> listIterator(int index) {
                return null;
            }

            @Override
            public List<SentSupplies> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        //when(suppliesService.sentSuppliesRepository.findAll()).thenReturn(suppliesList);
        //when(suppliesService.sentSuppliesRepository.getAllForId(anyInt())).thenReturn(suppliesList);
    }

//    @Test
//    public void getAllShouldWorkCorrect() {
//        Assert.assertEquals(suppliesList, suppliesService.getAll());
//    }

//    @Test
//    public void getAllForUserShouldWorkCorrect() {
//        Assert.assertEquals(suppliesList, suppliesService.getAllForUser(6));
//    }
}