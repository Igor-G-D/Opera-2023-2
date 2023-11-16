import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Escalator {
    String policy;
    ArrayList<Process> queue;

    Escalator(String policy, ArrayList<Process> queue) throws IllegalArgumentException {
        this.policy = policy;
        this.queue = queue;

        Collections.sort(this.queue);

        if(policy.compareToIgnoreCase("ljf") == 0) {
            Collections.reverse(this.queue);
        } else if (policy.compareToIgnoreCase("sjf") != 0) {
            throw new IllegalArgumentException("Invalid Policy");
        }
    }
    
}
