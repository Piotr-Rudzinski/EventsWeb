package com.infoshareacademy.kulturalniweb.repository;

import com.google.gson.Gson;
import com.infoshareacademy.kulturalniweb.domainData.EventNew;
import com.infoshareacademy.kulturalniweb.domainData.EventSimple;
import com.infoshareacademy.kulturalniweb.services.PictureService;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListEventRepository {
    PictureService pictureService;

    private List<EventNew> eventsDB = new ArrayList<>();
    private Path path = Paths.get("src", "main", "resources", "data.json");

    public ListEventRepository(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    public void readEventsFromGsonToList() {
        clearList();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(String.valueOf(path));
            EventNew[] eventList = gson.fromJson(reader, EventNew[].class);

            for (EventNew eventNew : eventList) {
                eventsDB.add(eventNew);
            }

            addPictures();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Błąd odczytu pliku .json.");
        }
    }

    public void clearList() {
        eventsDB.clear();
    }

    public void addPictures() {
        for (int i = 0; i < eventsDB.size(); i++) {
            eventsDB.get(i).getPlace().setSubname(pictureService.getPictureFilename());
        }
    }


    public List<EventNew> getEventsDB() {
        return eventsDB;
    }

    public void setEventsDB(List<EventNew> eventsDB) {
        this.eventsDB = eventsDB;
    }
}
