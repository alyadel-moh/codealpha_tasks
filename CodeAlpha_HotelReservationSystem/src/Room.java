import java.io.Serializable;

public class Room implements Serializable {
    private int id;
    private boolean isavailable = true;
    private String category;

    public Room(String category, int id) {
        this.category = category;
        this.id = id;
    }

    public void setIsavailable(boolean isavailable) {
        this.isavailable = isavailable;
    }

    public boolean isIsavailable() {
        return isavailable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "category='" + category + '\'' +
                ", id=" + id +
                ", isavailable=" + isavailable +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }
}
