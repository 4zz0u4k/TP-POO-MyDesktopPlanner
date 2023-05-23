package MyDesktopPlanner.Calendrier;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class TupleCrénoDuréeExtraite {
    private Créno créno;
    private Duration durée;
    private LocalDate date;
    public TupleCrénoDuréeExtraite(Créno créno,Duration durée,LocalDate date){
        this.créno = créno;
        this.durée = durée;
        this.date = date;
    }

    public Créno getCréno() {
        return créno;
    }

    public Duration getDurée() {
        return durée;
    }

    public LocalDate getDate() {
        return date;
    }
}
