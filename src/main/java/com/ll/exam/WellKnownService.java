package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WellKnownService {
    List<WellKnown> wellKnowns;
    int wellKnownLastIndex;
    public WellKnownService() {
        wellKnowns = new ArrayList<>();
        wellKnownLastIndex = 0;
    }


    public WellKnown write(String wellKnownSaying, String author) {
        int id = ++wellKnownLastIndex;
        WellKnown wellKnown = new WellKnown(id, wellKnownSaying, author);
        wellKnowns.add(wellKnown);
        return wellKnown;
    }

    public void remove(int paramId) {
        WellKnown foundWellKnown = findById(paramId);
        wellKnowns.remove(foundWellKnown);
    }

    public void modify(int paramId, String newWellKnownSaying, String newAuthor) {
        WellKnown foundWellKnown = findById(paramId);
        foundWellKnown.wellKnownSaying = newWellKnownSaying;
        foundWellKnown.author = newAuthor;
    }

    public WellKnown findById(int paramId) {
        for(WellKnown wellKnown : wellKnowns) {
            if(wellKnown.id == paramId) {
                return wellKnown;
            }
        }
        return null;
    }
}
