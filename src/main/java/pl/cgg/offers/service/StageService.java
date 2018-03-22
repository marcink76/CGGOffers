package pl.cgg.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.cgg.offers.models.Offer;
import pl.cgg.offers.models.Stage;
import pl.cgg.offers.repositories.StageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StageService {

    @Autowired
    private StageRepository stageRepository;

    private List<Stage> stageList = new ArrayList<>();

    public List<Stage> getByOffer(Offer offer){
        return stageRepository.findAllByOffers(offer);
    }

    public void saveStage(Stage stage){
        stageRepository.save(stage);
    }

    public List<Stage> getStageList() {
        return stageList;
    }

    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
    }
}
