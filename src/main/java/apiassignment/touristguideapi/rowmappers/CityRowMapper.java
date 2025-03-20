package apiassignment.touristguideapi.rowmappers;

import apiassignment.touristguideapi.model.CityModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper<CityModel> {

    @Override
    public CityModel mapRow (ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("CITY_ID");
        String name = rs.getString("CITY_NAME");
        return new CityModel(id, name);
    }

}
