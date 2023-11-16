import java.util.ArrayList;
import java.util.Collections;

public class Escalator {
    String policy;
    ArrayList<Process> queue;
    ArrayList<CPUCore> cores;
    int coreCount;

    Escalator(String policy, int coreCount) throws IllegalArgumentException {
        this.policy = policy;
        this.coreCount = coreCount;
        this.queue = new ArrayList<Process>();
        this.cores = new ArrayList<CPUCore>();

        for(int i=0;i<coreCount;i++) { //creates N number of cores
            this.cores.add(new CPUCore());
        }
        if (!(policy.compareToIgnoreCase("sjf") == 0 || policy.compareToIgnoreCase("ljf") == 0)) {
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

        for(int i = 0; i<queue.size();i++) {
            int lowestLoadIndex = 0;
            for(int j=0;j<coreCount;j++) {
                if (cores.get(j).getTotalProccessingTime() == 0) { // no processes in the core
                    lowestLoadIndex = j;
                    break;
                } else {
                    if(cores.get(lowestLoadIndex).getTotalProccessingTime() > cores.get(j).getTotalProccessingTime()) { // if the core pointed at by lowestLoadIndex has a higher load than the current, lowestLoadIndex now points to the current
                        lowestLoadIndex = j;
                    }
                }
            }
            cores.get(lowestLoadIndex).addProcess(queue.get(i));
        }
    }

    @Override
    public String toString() {
        String string = "";
        for(int i=0;i<coreCount;i++) {
            string += "CPU_Core_"+i+"\n";
            string += cores.get(i).toString() + "\n";
        }
        return string;
    }
}
