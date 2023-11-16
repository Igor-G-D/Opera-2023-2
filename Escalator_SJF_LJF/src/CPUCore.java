import java.util.ArrayList;

public class CPUCore {
    private ArrayList<Process> processes;
    private int totalProccessingTime;

    CPUCore() {
        processes = new ArrayList<Process>();
        totalProccessingTime = 0;
    }

    public void addProcess(String id, int processingTime) {
        processes.add(new Process(id, processingTime));
        totalProccessingTime += processingTime;
        
    }

    public int getTotalProccessingTime() {
        return totalProccessingTime;
    }

    @Override
    public String toString() {
        String string = "";
        int sum = 0;
        for(int i=0;i<processes.size();i++) {
            String temp = processes.get(i) + ";" + sum + ";"; 
            sum += processes.get(i).getProcessExecTime();
            temp += sum; // Format: processName;ExecStartTime;ExecEndTime;
            string += temp + "\n";
        }
        return string;
    }

}
