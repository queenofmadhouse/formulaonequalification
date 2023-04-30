package com.foxminded.chendev.formulaonequalification.provider;

import java.util.Set;

import com.foxminded.chendev.formulaonequalification.entity.Racer;

public interface ViewProvider {
    public String provideView(Set<Racer> racers);
}
