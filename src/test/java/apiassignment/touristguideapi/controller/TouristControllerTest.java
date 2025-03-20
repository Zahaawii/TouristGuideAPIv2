package apiassignment.touristguideapi.controller;

import apiassignment.touristguideapi.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(TouristController.class)
class TouristControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TouristService touristService;

    /*@BeforeEach*/



    /*@Test
    void processUpdate() throws Exception {
        //tjek om model har updateAttraction attribute
        //tjek om den redirecter til /save
        //

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listAttactions() throws Exception {
        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("attractionList"));
    }


    @Test
    void updateAttractions() throws Exception {
        TouristAttraction touristAttraction = new TouristAttraction();
        touristAttraction.setName("sample");
        touristAttraction.setSeason(Season.SOMMER);
        touristAttraction.setImgPath("sample");
        touristAttraction.setDescription("sample");
        touristAttraction.setCity("sample");


        mockMvc.perform(post("/add")

                .param("name", touristAttraction.getName())
                .param("season", touristAttraction.getSeason().name())
                .param("imgPath", touristAttraction.getImgPath())
                .param("description", touristAttraction.getDescription()))

                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/save"));

                verify(touristService, times(1)).addTouristAttraction(touristAttraction);

    }*/
}