package apiassignment.touristguideapi.service;

import apiassignment.touristguideapi.model.CityModel;
import apiassignment.touristguideapi.model.TagsModel;
import apiassignment.touristguideapi.model.TouristAttraction;
import apiassignment.touristguideapi.model.TouristAttractionDTO;
import apiassignment.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getTouristAttractions();
    }

    public List<CityModel> getAllCities() {
        return touristRepository.getCities();
    }


    public List<TagsModel> getAllTags() {
        return touristRepository.getTags();
    }


    public CityModel getCityFromID (int id) {
        return touristRepository.getCityFromID(id);
    }

    public TagsModel getTagsFromID (int id) {
        return touristRepository.getTagsFromID(id);
    }

    public TouristAttraction updateAttraction (TouristAttraction t1) {
        return touristRepository.renameAttraction(t1);
    }



    public TouristAttraction getAttractionByName (String name) {
        return touristRepository.getAttractionByName(name);
    }

    public TouristAttractionDTO addTouristAttraction (TouristAttractionDTO t1) {
        return touristRepository.addNewAttraction(t1);
    }

    public TouristAttraction renameAttraction (TouristAttraction newTouristAttraction) {
        return touristRepository.renameAttraction(newTouristAttraction);
    }

    public TouristAttraction removeAttraction(String name) {
        return touristRepository.removeAttraction(name);
    }

}
