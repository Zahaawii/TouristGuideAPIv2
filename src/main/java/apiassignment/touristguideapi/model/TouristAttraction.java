package apiassignment.touristguideapi.model;
import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private int id;
    private String name;
    private String description;
    private String imgPath;
    /*private SeasonModel season;*/
    private CityModel city;
    private List<TagsModel> tagsList = new ArrayList<>();

    public TouristAttraction(String name, String description, /*SeasonModel season,*/ String imgPath, CityModel city, List<TagsModel> tagsList) {
        this.name = name;
        this.description = description;
        /*this.season = season;*/
        this.imgPath = imgPath;
        this.city = city;
        this.tagsList = tagsList;
    }
    public TouristAttraction(String name, String description, String imgPath) {
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
    }

    public TouristAttraction(String name, String description, String imgPath, /*SeasonModel season,*/ CityModel city) {
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
        /*this.season = season;*/
        this.city = city;
    }

    public TouristAttraction() {

    }

    public TouristAttraction(String name, String description, String imgpath, int seasonID, int cityID) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public SeasonModel getSeason() {
        return season;
    }

    public void setSeason(SeasonModel season) {
        this.season = season;
    }*/

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public CityModel getCity() {
        return city;
    }

    public void setCity(CityModel city) {
        this.city = city;
    }

    public List<TagsModel> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<TagsModel> tagsList) {
        this.tagsList = tagsList;
    }

    @Override
    public String toString() {
        return "TouristAttraction{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", city='" + city + '\'' +
                ", tagsList=" + tagsList +
                '}';
    }

}
