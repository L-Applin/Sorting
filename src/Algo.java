public abstract class Algo {

    protected int access;
    long start_time;
    protected String name;


    public abstract void sort(int[] tab) throws InterruptedException;


    public static void shuffle(int[] tab, int iter, boolean mixup){

        // System.out.println("\nSHUFFLIGN " + tab.length + " elements");

        for (int i = 0; i < iter; i++) {
            for (int j = 0; j < tab.length; j++) {
                int new_rand_index = (int) Math.floor(Math.random() * tab.length);
                if (new_rand_index != j) {
                    // swap the value
                    int temp = tab[new_rand_index];
                    tab[new_rand_index] = tab[j];
                    tab[j] = temp;

                }
            }
        }

        for (int i = 0; i < tab.length; i++) {
            if (Math.random() > 0.1 && mixup){
                tab[i] = tab[i] + (int) Math.floor(Math.random() * 3);
            }
            
        }

    }

    public static void shuffle(Column[] tab, int iter, boolean mixup){

        // System.out.println("\nSHUFFLIGN " + tab.length + " elements");

        for (int i = 0; i < iter; i++) {
            for (int j = 0; j < tab.length; j++) {
                int new_rand_index = (int) Math.floor(Math.random() * tab.length);
                if (new_rand_index != j) {
                    // swap the value
                    int temp = tab[new_rand_index].value;
                    tab[new_rand_index] = tab[j];
                    tab[j].value = temp;

                }
            }
        }

        for (int i = 0; i < tab.length; i++) {
            if (Math.random() > 0.1 && mixup){
                tab[i].value = tab[i].value + (int) Math.floor(Math.random() * 3);
            }

        }

    }

    public int getAccess(){
        return access;
    }


    protected static void swap(int[] tab, int a, int b){
        int temp = tab[a];
        tab[a] = tab[b];
        tab[b] = temp;

    }

    public static boolean isSorted(int[] tab){

        boolean sorted = true;

        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] > tab[i+1]){
                sorted = false;
                break;
            }
        }

        return sorted;

    }



}