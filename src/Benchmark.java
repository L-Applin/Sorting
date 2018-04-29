import java.util.ArrayList;

public class Benchmark {

    public ArrayList<Algo> sortingAlgorithm;
    public int[] testArray;

    public Benchmark(int[] test) {

        testArray = test;

        sortingAlgorithm = new ArrayList<>();

        sortingAlgorithm.add(new QuickSort());
        sortingAlgorithm.add(new Merge());
        sortingAlgorithm.add(new Selection());
        sortingAlgorithm.add(new Insertion());
        sortingAlgorithm.add(new Bubble());
        sortingAlgorithm.add(new RadixLSD(16));
        sortingAlgorithm.add(new RadixLSD(10));
        sortingAlgorithm.add(new RadixLSD(2));

    }

    public void execute() {

        new Thread(() -> {

            for (Algo sortAlgo : sortingAlgorithm) {

                Algo.shuffle(this.testArray, 4, false);

                try {sortAlgo.sort(this.testArray);}catch (Exception e){
                    e.printStackTrace();
                }

                long time_after = System.nanoTime();
                double current_time = (double) (time_after - sortAlgo.start_time) / 1000000.0;

                System.out.println("\nSorted using : " + sortAlgo.name);
                System.out.println("the array is sorted : " + Algo.isSorted(this.testArray));
                System.out.println("Array accesses : " + sortAlgo.access);
                System.out.println("Time taken : " + current_time + " ms");


            }

        }).start();
    }


}
