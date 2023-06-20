import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Scanner;

public class PokemonCards {

    private ArrayList<Pokemon> list;
    private Scanner sc;

    public PokemonCards() {

        list = new ArrayList<>();
        try{
            File file = new File("Pokemon.txt");
            sc = new Scanner(file);
            while(sc.hasNext()){
                String line = sc.nextLine();
                String[] arr = line.split(",");

                double atk = Double.parseDouble(arr[3]);
                double def = Double.parseDouble(arr[4]);
                double spd = Double.parseDouble(arr[5]);

                Class myClass = Class.forName(arr[0]);
                Constructor constructor = myClass.getConstructor(String.class, String.class, double.class, double.class, double.class);
                Object instance = constructor.newInstance(arr[1], arr[2], atk, def, spd);
                list.add((Pokemon) instance);
            }

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public Pokemon get(int index){
        System.out.println(list);
        return list.get(index);
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < list.size(); i++){
            str = str + list.get(i).getName()+ " " + list.get(i).getType();
            str = str + "Atk: " + list.get(i).getAtk();
            str = str + "\n";
        }

        return str;
    }

}
