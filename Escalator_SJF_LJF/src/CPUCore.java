import java.util.ArrayList;

public class CPUCore {
    private ArrayList<Process> processes;

    CPUCore() {
        processes = new ArrayList<Process>();
    }

    public void addProcess(String id, int processingTime) {
        processes.add(new Process(id, processingTime));
    }

    public int totalProccessingTime() {
        int sum = 0;
        for(Process process : processes) { //for each process in processes
            sum += process.getProcessExecTime();
        }
        return sum;
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
