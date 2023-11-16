import java.util.ArrayList;
import java.util.Collections;

public class Escalator {
    String policy;
    ArrayList<Process> queue;
    ArrayList<CPUCore> cores;

    Escalator(String policy, int coreCount) throws IllegalArgumentException {
        this.policy = policy;
        this.queue = new ArrayList<Process>();
        this.cores = new ArrayList<CPUCore>();

        for(int i=0;i<coreCount;i++) { //creates N number of cores
            this.cores.add(new CPUCore());
        }
        if ((policy.compareToIgnoreCase("sjf") == 0 || policy.compareToIgnoreCase("ljf") == 0)) {
            throw new IllegalArgumentException("Invalid Policy");
        }
    }

    public void addProcess(Process process) { 
        queue.add(process);
    }

    public void execute() { // distributes processes between a number of CPU cores 
        Collections.sort(queue);

        if(policy.compareToIgnoreCase("ljf") == 0) {
            Collections.reverse(this.queue);
        }

        


    }
}
