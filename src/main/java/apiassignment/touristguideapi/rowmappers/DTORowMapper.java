package apiassignment.touristguideapi.rowmappers;

import apiassignment.touristguideapi.model.TouristAttractionDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DTORowMapper implements RowMapper<TouristAttractionDTO> {
    @Override
    public TouristAttractionDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        String description = rs.getString("DESCRIPTION");
        String imgpath = rs.getString("IMAGE_PATH");
        int cityID = rs.getInt("City_ID");
        return new TouristAttractionDTO(name, description, imgpath, cityID);

    }
}
