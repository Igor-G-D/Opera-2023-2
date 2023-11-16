public class Process implements Comparable<Process> {
    private String id;
    private int processExecTime;

    Process(String id, int processExecTime) {
        this.id = id;
        this.processExecTime = processExecTime;
    }

    public String getId() {
        return id;
    }
    public int getProcessExecTime() {
        return processExecTime;
    }

    @Override
    public int compareTo(Process o) {
        return processExecTime - o.getProcessExecTime();
    }

}
