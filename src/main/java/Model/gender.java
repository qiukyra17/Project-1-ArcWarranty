package Model;

public class gender {
    public int id;
    public String gender;

    public gender(int id, String gender) {
        this.id = id;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "gender{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
