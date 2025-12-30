import java.time.Year;
public abstract class ContentItem {
    protected int id;
    protected static int IdGen;
    protected String title;
    protected int year;
    protected int durationMinutes;
    public ContentItem(String title, int year, int durationMinutes){
        this.id=IdGen++;
        setTitle(title);
        setYear(year);
        setDurationMinutes(durationMinutes);
    }
    public int getId() {
        return id;
    }
    public void setTitle(String title){
        if (title==null || title.trim().isEmpty()){
            throw new IllegalArgumentException("title cant null and empty");
        }
        this.title=title;
    }
    public String getTitle() {
        return title;
    }
    public void setYear(int year){
        int Curentyear=Year.now().getValue();
        if(year< 1990 || year > Curentyear){
            throw new IllegalArgumentException("Year must be between 1990 and current year");
        }
        this.year=year;
    }
    public int getYear() {
        return year;
    }
    public void setDurationMinutes(int durationMinutes){
        if(durationMinutes<0){
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        this.durationMinutes=durationMinutes;
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public int getAge(int currentYear) {
        return currentYear - year;
    }
    public abstract double getLicenseCost(int currentYear);
    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Year: " + year + ", Duration: " + durationMinutes + " minutes";
    }
}
