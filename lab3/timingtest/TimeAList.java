package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    //TAKES in Alists as parameters, so we should output Alists to store data
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
        timeAListConstruction();
    }

    //need to output N, t, and opCounts
    public static void timeAListConstruction() {
        Stopwatch sw = new Stopwatch();
        AList<Integer> storeLoops = new AList<>();
        AList<Double> storeTimes = new AList<>();
        AList<Integer> storeOpCounts = new AList<>();

        for (int i = 1000; i < 1000000; i = i *2) {
            AList<Integer> testList = new AList<Integer>();
            int j = 0;
            while (j <= i) {
                testList.addLast(j);
                j += 1;
            }
            storeLoops.addLast(i);
            storeTimes.addLast(sw.elapsedTime());
            storeOpCounts.addLast(j-1);
        }

        printTimingTable(storeLoops, storeTimes, storeOpCounts);

    }
}
