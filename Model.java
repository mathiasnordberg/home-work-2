

/**
 *
 * @author 96matnor
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

import javax.swing.JTextArea;

public class Model{
    ArrayList <AbstractClass> lib;
    
    public Model(){
	 lib = new ArrayList<>();
    }
    /**
     * Kollar om det är en bok eller tidning och lägger sedan till i arraylisten
     * @param n namnet
     * @param a författaren
     * @param y året
     * @param i indexet i combo-boxen
     * 
     */
    public void add(String n, String a, int y, int i){
        AbstractClass aC = null;
        switch(i){
            case 0:
                aC = new Book(n,a,y);
                
            break;
            case 1:
                aC = new Magazine(n,a,y);
            break;
        }
        lib.add(aC);
        
        
     
        
    }
    /**
     * Delar upp inkommande rad till de olika värdena,sorterar listan efter namn
     * och skrivs sedan ut.
     * @param filename namn på filen
     * @param txa textarea där biblioteket skrivs ut
     * 
     */
    public void read_file(String filename, JTextArea txa){
        txa.setText("");
        lib.clear();
        String s;
        try{
            BufferedReader lasFil = new BufferedReader(new FileReader(filename));
            s = lasFil.readLine();
            
            while(s != null){
                System.out.println(s);
                String [] values = s.split(",");
                AbstractClass aC = null;
                    for(int i = 0; i < values.length; i++){
                        values[i] = values[i].trim();
                    }
                    if("Magazine".equals(values[2])){
                        aC = new Magazine(values[0], values[1], Integer.parseInt(values[3]));
                    }else{
                        aC = new Book(values[0], values[1], Integer.parseInt(values[3]));
                    }
                    
                lib.add(aC);
                s = lasFil.readLine();
            }
        Collections.sort(lib);    
        lasFil.close();
        
        for(AbstractClass a: lib){
            txa.append(a.toString() + "\n");
        }
        }catch(IOException e){
            System.out.print("filen finns inte");
        }
    }
    /**
     * Sparar listan till en csv fil som du får döpa själv
     * @param filename namn på filen som sparas
     * 
     */
    public void save_file(final String filename){
        Runnable r = new Runnable(){
            @Override
            public void run(){
                 try{
                    FileWriter skrivFil1 = new FileWriter(filename + ".csv") ; 
                    BufferedWriter writer = new BufferedWriter(skrivFil1);
                    PrintWriter skrivFil = new PrintWriter(writer);
                    
                    for(AbstractClass aC : lib){
                        skrivFil.println(aC.toString());
                    }
            skrivFil.close();
            
        }catch(IOException e){
            System.out.println("funkade inte");
        }
            }
        };
        Thread thread1 = new Thread(r);
        thread1.start();
    }
       
       
}
