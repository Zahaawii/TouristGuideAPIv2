package apiassignment.touristguideapi.rowmappers;

import apiassignment.touristguideapi.model.TagsModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagsRowMapper implements RowMapper<TagsModel> {

    @Override
    public TagsModel mapRow (ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("TAGS_ID");
        String name = rs.getString("TAGS_NAME");
        return new TagsModel(id, name);
    }

}
