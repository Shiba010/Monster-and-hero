package Maps;
import java.util.Random;

public class RandomGenerator {
    static Random r = new Random();
    public static boolean TrueFalseGen(double probability){  // this class return true false by the probability
        if(probability > r.nextDouble()){
            return true;
        }
        return false;
    }
    public static int RandomIndex(int size){ // return a random index for a giving list size
        if(size == 0) {
            return 0;
        }
        return r.nextInt(size);
    }
}
