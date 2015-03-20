
/**
 *
 * @author 96matnor
 */
public abstract class AbstractClass implements Comparable<AbstractClass>{
    
    public AbstractClass(){
        
    }
    /**
     * 
     * @return sträng med namnet
     * toString gör objektet till en sträng
     */
    public abstract String getName();
    @Override
    public abstract String toString();
}
