package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> storeLoops = new AList<>();
        AList<Double> storeTimes = new AList<>();
        AList<Integer> storeOpCounts = new AList<>();

        for (int i = 1000; i <= 128000; i = i *2) {
            SLList<Integer> linkedList = new SLList<>();
            for (int j = 0; j <= i; j += 1)
                linkedList.addLast(j);

            Stopwatch sw = new Stopwatch();
            int z;
            for (z = 0; z <= 10000; z += 1)
                linkedList.getLast();

            storeLoops.addLast(i);
            storeTimes.addLast(sw.elapsedTime());
            storeOpCounts.addLast(z-1);
        }
        printTimingTable(storeLoops, storeTimes, storeOpCounts);
    }
}
