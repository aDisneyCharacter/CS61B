package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> goodList = new AListNoResizing<>();
        BuggyAList<Integer> badList = new BuggyAList<>();

        int [] addList= {4,5,6};
        for (int i = 0; i < addList.length; i += 1) {
            goodList.addLast(addList[i]);
            badList.addLast(addList[i]);
        }

        while (goodList.size() != 0) {
            assertEquals(goodList.removeLast(), badList.removeLast());
        }
    }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> W = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                W.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bugSize = W.size();
                assertEquals(size, bugSize);
            } else if (L.size() == 0 || W.size() == 0) {
                continue;
            } else if (operationNumber == 2) {
                int last = L.getLast();
                int bugLast = W.getLast();
                assertEquals(last, bugLast);
            } else if (operationNumber == 3) {
                L.removeLast();
                W.removeLast();
            }
        }
    }
}
