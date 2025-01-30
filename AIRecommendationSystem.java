import java.util.*;

public class AIRecommendationSystem {

    // Sample data: Users and their preferences
    private static Map<String, List<String>> userPreferences = new HashMap<>();

    static {
        userPreferences.put("Alice", Arrays.asList("Action", "Comedy", "Drama"));
        userPreferences.put("Bob", Arrays.asList("Action", "Sci-Fi", "Thriller"));
        userPreferences.put("Charlie", Arrays.asList("Romance", "Comedy", "Drama"));
        userPreferences.put("David", Arrays.asList("Action", "Comedy", "Sci-Fi"));
    }

    // Sample data: Movies categorized by genre
    private static Map<String, List<String>> movieDatabase = new HashMap<>();

    static {
        movieDatabase.put("Action", Arrays.asList("Mad Max", "John Wick", "The Dark Knight"));
        movieDatabase.put("Comedy", Arrays.asList("The Hangover", "Superbad", "Step Brothers"));
        movieDatabase.put("Drama", Arrays.asList("The Shawshank Redemption", "Forrest Gump", "The Godfather"));
        movieDatabase.put("Sci-Fi", Arrays.asList("Inception", "Interstellar", "The Matrix"));
        movieDatabase.put("Romance", Arrays.asList("Titanic", "The Notebook", "Pride and Prejudice"));
        movieDatabase.put("Thriller", Arrays.asList("Se7en", "Gone Girl", "Shutter Island"));
    }

    // Recommendation logic
    public static List<String> recommendMovies(String user) {
        List<String> preferences = userPreferences.get(user);
        if (preferences == null) {
            System.out.println("User not found!");
            return Collections.emptyList();
        }

        Set<String> recommendedMovies = new HashSet<>();
        for (String genre : preferences) {
            List<String> movies = movieDatabase.get(genre);
            if (movies != null) {
                recommendedMovies.addAll(movies);
            }
        }

        return new ArrayList<>(recommendedMovies);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the AI-Based Movie Recommendation System!");
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        List<String> recommendations = recommendMovies(userName);
        if (!recommendations.isEmpty()) {
            System.out.println("Recommended movies for " + userName + ":");
            for (String movie : recommendations) {
                System.out.println("- " + movie);
            }
        } else {
            System.out.println("Sorry, no recommendations available.");
        }

        scanner.close();
    }
}