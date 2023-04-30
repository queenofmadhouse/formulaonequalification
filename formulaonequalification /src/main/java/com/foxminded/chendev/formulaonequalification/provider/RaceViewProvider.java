package com.foxminded.chendev.formulaonequalification.provider;

import com.foxminded.chendev.formulaonequalification.entity.Racer;

import java.time.Duration;
import java.util.Set;

public class RaceViewProvider implements ViewProvider {

    private static final int SEPARATOR_POSITION = 15;
    private static final int POSITION_FORMAT_THRESHOLD = 10;
    private static final int POSITION_SEPARATOR_LENGTH = 2;
    private static final int NAME_SEPARATOR_LENGTH = 3;
    private static final int TEAM_SEPARATOR_LENGTH = 3;
    private static final int TIME_SEPARATOR_LENGTH = 9;

    @Override
    public String provideView(Set<Racer> racers) {
        StringBuilder formattedResults = new StringBuilder();
        int position = 1;
        int maxPositionLength = String.valueOf(racers.size()).length();
        int maxNameLength = racers.stream().mapToInt(racer -> racer.getRacerName().length()).max().orElse(0);
        int maxTeamLength = racers.stream().mapToInt(racer -> racer.getRacerTeam().length()).max().orElse(0);

        for (Racer racer : racers) {
            formattedResults.append(formatRacer(position, maxNameLength, maxTeamLength, racer));

            if (position == SEPARATOR_POSITION) {
                formattedResults.append(createSeparator(maxPositionLength, maxNameLength, maxTeamLength));
            } else {
                formattedResults.append("\n");
            }

            position++;
        }

        return formattedResults.toString();
    }

    private String formatRacer(int position, int maxNameLength, int maxTeamLength, Racer racer) {
        String positionFormat = position < POSITION_FORMAT_THRESHOLD ? "%d.  " : "%d. ";

        return String.format(positionFormat + "%-" + maxNameLength + "s | %-" + maxTeamLength 
                + "s | %s", position, racer.getRacerName(), racer.getRacerTeam(), formatDuration(racer.getRacerBestTime()));
    }

    private String createSeparator(int maxPositionLength, int maxNameLength, int maxTeamLength) {
        int separatorLength = maxPositionLength + POSITION_SEPARATOR_LENGTH + maxNameLength + NAME_SEPARATOR_LENGTH 
                + maxTeamLength + TEAM_SEPARATOR_LENGTH + TIME_SEPARATOR_LENGTH;
        StringBuilder separator = new StringBuilder(separatorLength);
        for (int i = 0; i < separatorLength; i++) {
            separator.append("-");
        }

        return "\n" + separator.toString() + "\n";
    }

    private String formatDuration(Duration duration) {
        long minutes = duration.toMinutes();
        long seconds = duration.getSeconds() % 60;
        long millis = duration.toMillis() % 1000;

        return String.format("%02d:%02d.%03d", minutes, seconds, millis);
    }
}
