package com.foxminded.chendev.formulaonequalification.entity;

import java.time.Duration;

public class Racer implements Comparable<Racer> {
    
    private final String racerName;
    private final String racerTeam;
    private final Duration racerBestTime;
    
    private Racer(String racerName, String racerTeam, Duration racerBestTime) {
        this.racerName = racerName;
        this.racerTeam = racerTeam;
        this.racerBestTime = racerBestTime;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String racerName;
        private String racerTeam;
        private Duration racerBestTime;
        
        public Builder withRacerName(String racerName) {
            this.racerName = racerName;
            return this;
        }
        
        public Builder withRacerTeam(String racerTeam) {
            this.racerTeam = racerTeam;
            return this;
        }
        
        public Builder withRacerBestTime(Duration racerBestTime) {
            this.racerBestTime = racerBestTime;
            return this;
        }
        
        public Racer build() {
            return new Racer(racerName, racerTeam, racerBestTime);
        }
    }
    
    @Override
    public int compareTo(Racer other) {
        return this.racerBestTime.compareTo(other.racerBestTime);
    }

    public String getRacerName() {
        return racerName;
    }
    
    public String getRacerTeam() {
        return racerTeam;
    }

    public Duration getRacerBestTime() {
        return racerBestTime;
    }
}
