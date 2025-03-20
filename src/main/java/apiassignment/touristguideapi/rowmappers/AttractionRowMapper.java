package apiassignment.touristguideapi.rowmappers;

import apiassignment.touristguideapi.model.TouristAttraction;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttractionRowMapper implements RowMapper<TouristAttraction> {
    @Override
    public TouristAttraction mapRow (ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        String description = rs.getString("DESCRIPTION");
        String imgpath = rs.getString("IMAGE_PATH");
        int cityID = rs.getInt("City_ID");
        return new TouristAttraction(name, description, imgpath);
    }
}
