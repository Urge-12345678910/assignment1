public class Main {
    public static void main(String[] args) {

        int currentYear = 2025;

        ContentItem item = new TestContentItem(
                "Test Content",
                2023,
                60
        );

        System.out.println(item); // toString()
        System.out.println("Age: " + item.getAge(currentYear));
    }
}
