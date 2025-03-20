package apiassignment.touristguideapi.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import apiassignment.touristguideapi.model.CityModel;
import apiassignment.touristguideapi.model.TagsModel;
import apiassignment.touristguideapi.model.TouristAttraction;
import apiassignment.touristguideapi.model.TouristAttractionDTO;
import apiassignment.touristguideapi.rowmappers.AttractionRowMapper;
import apiassignment.touristguideapi.rowmappers.CityRowMapper;
import apiassignment.touristguideapi.rowmappers.DTORowMapper;
import apiassignment.touristguideapi.rowmappers.TagsRowMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Repository
public class TouristRepository {

    private final List<TouristAttraction> touristAttractions = new ArrayList<>();
    private final List<String> allCities = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;

    public TouristRepository() {
        /*DriverManagerDataSource dataSource = new DriverManagerDataSource(
                url, username, password
        );*/
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                System.getenv("PROD_DATABASE_URL"),
                System.getenv("PROD_USERNAME"),
                System.getenv("PROD_PASSWORD")
        );

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        /*initAttractions();
        initCities();*/
    }


    public List<TouristAttraction> getTouristAttractions() {
        String sql = "SELECT * FROM attraction";
        return jdbcTemplate.query(sql, new AttractionRowMapper());
    }



    public TouristAttractionDTO addNewAttraction (TouristAttractionDTO t1) {
        String sql = "INSERT INTO attraction (NAME, DESCRIPTION, IMAGE_PATH, City_ID) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, t1.getName());
            ps.setString(2, t1.getDescription());
            ps.setString(3, t1.getImgPath());
            ps.setInt(4, t1.getCityID());

            return ps;
        }, keyHolder);

        t1.setId(keyHolder.getKey().intValue());

        String tagsSql = "INSERT INTO attraction_tags (ATTRACTION_ID, TAGS_ID) VALUES (?, ?)";
        for (Integer tag : t1.getTagsID()) {
            jdbcTemplate.update(tagsSql, t1.getId(), tag);
        }


        return t1;
    }

    public TouristAttraction renameAttraction(TouristAttraction newTouristAttraction) {
        String sql = "UPDATE attraction SET description = ?, image_path = ?, city_ID = ? WHERE name = ?";

        int rowsUpdated = jdbcTemplate.update(sql,
                newTouristAttraction.getDescription(),
                newTouristAttraction.getImgPath(),

                newTouristAttraction.getCity().getId(),
                newTouristAttraction.getName()
        );

        if (rowsUpdated > 0) {
            System.out.println("Attraction updated: " + newTouristAttraction.getName());
            return newTouristAttraction;
        } else {
            throw new RuntimeException("Attraction not found: " + newTouristAttraction.getName());
        }
    }

    public TouristAttraction getAttractionByName (String name) {


        String sql = "SELECT * FROM attraction WHERE name = ?";
        List<TouristAttraction> templist = jdbcTemplate.query(sql, new AttractionRowMapper(), name);

        if (templist.isEmpty() || templist == null) return null;
        return templist.get(0);
    }

    public TouristAttraction removeAttraction(String name) {
        TouristAttraction toDelete = getAttractionByName(name);
        if (toDelete != null) {
            int matchingID = getIDFromAttractionName(name);

            String sqlTags = "DELETE FROM attraction_tags WHERE ATTRACTION_ID = ?";
            jdbcTemplate.update(sqlTags, matchingID);

            String sql = "DELETE FROM attraction WHERE ID = ?";
            jdbcTemplate.update(sql, matchingID);
        }

        return toDelete;
    }


    public int getIDFromAttractionName (String name) {
        String sql = "SELECT * from attraction WHERE NAME = ?";
        List<TouristAttractionDTO> tempList = jdbcTemplate.query(sql, new DTORowMapper(), name);

        return tempList.get(0).getId();
    }



    /*public List<TagsModel> getTagsByAttractionID(int attractionID) {
        String sql = """
                    SELECT t.*
                    FROM tags t
                    JOIN attraction_tags at ON t.TagsID = at.TagsID
                    WHERE at.AttractionsAttractionID = ?""";
    }*/

    public List<CityModel> getCities () {
        String sql = "SELECT * FROM city";
        return jdbcTemplate.query(sql, new CityRowMapper());
    }


    public List<TagsModel> getTags () {
        String sql = "SELECT * FROM tags";
        return jdbcTemplate.query(sql, new TagsRowMapper());
    }


    public CityModel getCityFromID (int id) {
        String sql = "SELECT * FROM city WHERE CITY_ID = ?";

        return jdbcTemplate.query(sql, new CityRowMapper(), id).get(0);
    }

    public TagsModel getTagsFromID (int id) {
        String sql = """
                SELECT *
                FROM tags
                WHERE TAGS_ID = ?
        """;
        return jdbcTemplate.query(sql, new TagsRowMapper(), id).get(0);
    }

    /*public TouristAttraction updateAttraction (TouristAttraction t1) {

        String sqlDeleteOldTags = """
                DELETE attraction_tags
                WHERE ATTRACTION_ID = ?
                """;
        jdbcTemplate.update(sqlDeleteOldTags, t1.getId());

        String insertNewTags = """
                INSERT INTO attraction_tags (ATTRACTION_ID, TAGS_ID)
                VALUES (?, ?)
                """;
        for (TagsModel tags : t1.getTagsList()) {
            jdbcTemplate.update(insertNewTags, t1.getId(), tags.getId());
        }

        String sql = """
                UPDATE attraction SET NAME = ?, DESCRIPTION = ?, IMAGE_PATH = ?, City_ID = ?
                WHERE ID = ?
                """;
        jdbcTemplate.update(sql, t1.getName(), t1.getDescription(), t1.getImgPath(),  t1.getCity().getId(), t1.getId());

        return t1;
    }*/









}
