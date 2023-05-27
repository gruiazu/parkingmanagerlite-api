package com.hormigo.david.parkingmanager.draw.service;

import com.hormigo.david.parkingmanager.draw.domain.Draw;
import com.hormigo.david.parkingmanager.draw.domain.DrawDao;

public interface DrawService {
    public Iterable<Draw> getAll();
    public Draw getLastDrawed();
    public void register(DrawDao drawDao);
}
