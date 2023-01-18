package rmit.ad.myapplication;

public class Game {
    private String title;
    private String developer;
    private String genre;
    private String releaseDate;
    private double price;
    private int image;

    public Game(String title, String developer) {
        this.title = title;
        this.developer = developer;
        this.genre = "";
        this.releaseDate = "";
        this.price = 0;
        this.image = 0;
    }

    public Game(String title, String developer, String genre, String releaseDate, double price, int image) {
        this.title = title;
        this.developer = developer;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getGenre() {
        return genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}

