package win.RaceHorses;

public class Horses {
    int id;
    int speed;

    public Horses(int id, int speed) {
        this.id = id;
        this.speed = speed;
    }

    public Horses commpar(Horses other) {
        if (this.speed > other.speed) {
            return this;
        } else if (this.speed < other.speed) {
            return other;
        } else {
            return null;
        }

    }

}