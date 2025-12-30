public class PodcastEpisode extends ContentItem implements Downloadable {
    private String hostName;
    public PodcastEpisode(String title, int year, int durationMinutes, String hostName) {
        super(title, year, durationMinutes);
        setHostName(hostName);
    }
    public String getHostName() {
        return hostName;
    }
    public void setHostName(String hostName) {
        if (hostName == null || hostName.trim().isEmpty()) {
            throw new IllegalArgumentException("Host name cant be null or empty");
        }
        this.hostName = hostName;
    }
    @Override
    public double getLicenseCost(int currentYear) {
        int age = getAge(currentYear);
        int ageFactor;
        if (age <= 2) {
            ageFactor = 3;
        }
        else {
            ageFactor = 1;
        }
        double cost = 0.03 * getDurationMinutes() + ageFactor;
        return cost;
    }
    @Override
    public String toString() {
        return super.toString() + ", Host: " + hostName;
    }
    @Override
    public void download() {
        System.out.println("Downloading podcast hosted by " + hostName);
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 10;
    }
}
