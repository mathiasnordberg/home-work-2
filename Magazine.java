
/**
 *
 * @author 96matnor
 */
public class Magazine extends AbstractClass {
    protected String name, author, TYPE;
    protected int year;
    
    public Magazine(String n, String a, int y){
        this.name = n;
        this.author = a;
        this.year = y;
        TYPE = "Magazine";
    }
    /**
     * returnerar namn, författare, typ och år som sträng 
     * @return sträng med all information
     */
    @Override
    public String toString(){
        return name + ", " + author + ", " + TYPE + ", "+ Integer.toString(year);
    }
    /**
     * 
     * @return returnerar namnet
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * 
     * @param o o är de andra objekten i registret
     * @return returnerar namnet och jämför med de andra (o).
     */
    @Override
    public int compareTo(AbstractClass o) {
        return this.name.compareToIgnoreCase(o.getName());
    }

    

    
}
