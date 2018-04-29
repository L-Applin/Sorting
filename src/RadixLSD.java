public class RadixLSD extends Algo {

    private int base;

    public RadixLSD(int base){
        this.base = base;
        this.name = "Radix base" + this.base;
    }

    @Override
    public void sort(int[] tab){

        this.start_time = System.nanoTime();

        int max_iter = (int) Math.ceil(
                Math.log(Sorting.arrayMax(tab)) / Math.log(this.base));

        for (int decim_power = 0; decim_power < max_iter + 1; decim_power++) {

            // empty buckets
            int[][] current_buckets = intoBuckets(tab, decim_power);

            // loop over all number of the base
            for (int decim = 0; decim < this.base; decim++) {

                // fill the buckets
                int index = 0;
                for (int i = 0; i < tab.length; i++) {
                    if (correct_current_digit(tab[i], decim_power, decim)) {
                        current_buckets[decim][index] = tab[i];
                        index++;
                        this.access++;
                    }

                }

            }

            int curr = 0;
            // put elements to main array
            for (int i = 0; i < current_buckets.length; i++) {
                for (int j = 0; j < current_buckets[i].length; j++) {
                    tab[curr] = current_buckets[i][j];
                    curr++;
                    this.access++;
                }

            }

        }
    }


    private int[][] intoBuckets(int[] to_sort, int decimal_place){

        // Pour chaque chiffre de la base trouver combien d'élément
        // de ce chiffre sont dans le tableau à la position décimale


        int[] buckets = new int[base];
        int[][] all_buckets = new int[base][];


        // finding how many of each element of that base are present
        for (int current_decimal = 0; current_decimal < buckets.length; current_decimal++){
            for (int j = 0; j < to_sort.length; j++) {
                if (this.correct_current_digit(to_sort[j], decimal_place, current_decimal)){
                    buckets[current_decimal] += 1;
                    this.access++;
                }
            }
        }

        // initializing internal arrays of all_buckets
        for (int i = 0; i < buckets.length; i++) {
            all_buckets[i] = new int[buckets[i]];
        }

        return all_buckets;


    }


    public void toBase(int newBase){
        base = newBase;
    }


    private boolean correct_current_digit(int elem, int decimal_place, int value_to_check){
        return (elem / ((int) Math.pow(this.base, decimal_place))) % this.base == value_to_check;

    }


}
