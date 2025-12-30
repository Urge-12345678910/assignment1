public class VideoLecture extends ContentItem implements Downloadable{
    private String quality;
    public VideoLecture(String title, int year, int durationMinutes, String quality) {
        super(title, year, durationMinutes);
        setQuality(quality);
    }
    public String getQuality() {
        return quality;
    }
    public void setQuality(String quality) {
        if (quality == null || quality.trim().isEmpty()) {
            throw new IllegalArgumentException("Quality cant be null or empty");
        }
        this.quality = quality;
    }
    @Override
    public double getLicenseCost(int currentYear) {
        int age = getAge(currentYear);
        int ageFactor;
        if (age <= 2) {
            ageFactor = 5;
        }
        else {
            ageFactor = 2;
        }

        return 0.05 * getDurationMinutes() + ageFactor;
    }
    @Override
    public String toString() {
        return super.toString() + ", Quality: " + quality;
    }
    @Override
    public void download() {
        System.out.println("Downloading video in " + quality + " quality");
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 3;
    }
}
