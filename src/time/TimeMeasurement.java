package time;

public class TimeMeasurement {
    private long start;

    public void start() {
        this.start = System.currentTimeMillis(); //시작하는 시점 계산
    }

    public double end() {
        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }
}
