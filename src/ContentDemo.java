import java.util.ArrayList;
import java.util.List;
import java.time.Year;
public class ContentDemo {
    public static void main(String[] args) {
        int currentYear = Year.now().getValue();
        List<ContentItem> items = new ArrayList<>();
        items.add(new VideoLecture("Java Basics", 2024, 90, "HD"));
        items.add(new VideoLecture("Advanced Java", 2023, 120, "4K"));
        items.add(new PodcastEpisode("Tech Talk", 2022, 45, "Octava"));
        items.add(new PodcastEpisode("Daily News", 2025, 30, "Zero"));
        for (int i = 0; i < items.size(); i++) {
            ContentItem item = items.get(i);
            System.out.println(item.toString() + " | licenseCost=" + item.getLicenseCost(currentYear));
            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println("Max downloads per day: " + d.getMaxDownloadsPerDay());
            }
            System.out.println();
        }
    }
}