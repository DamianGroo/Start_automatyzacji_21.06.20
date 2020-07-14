public class Counter {

  /*  public static void main(String[] args) {


    }


    */
    public void funkca (x){

        int[] tablica = new int[];
        int[] tablicaWynikow = new int[];

        int n = 10;

        for(int i=0; i<n; i++)
        {
            if (tablica[i] == tablica[i+1])
            {
                for(int j = 0; j<n; j++)
                {
                    tablicaWynikow[j] = tablica[i];
                }
            }
        }




    }



}
