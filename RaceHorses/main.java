package win.RaceHorses;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Horses[][] allHorses = {
                { new Horses(1, 17), new Horses(2, 33), new Horses(3, 12), new Horses(4, 48), new Horses(5, 26) },
                { new Horses(6, 19), new Horses(7, 42), new Horses(8, 37), new Horses(9, 23), new Horses(10, 55) },
                { new Horses(11, 14), new Horses(12, 29), new Horses(13, 40), new Horses(14, 22), new Horses(15, 51) },
                { new Horses(16, 31), new Horses(17, 45), new Horses(18, 11), new Horses(19, 38), new Horses(20, 20) },
                { new Horses(21, 13), new Horses(22, 34), new Horses(23, 17), new Horses(24, 46), new Horses(25, 27) }
        };

        for (int i = 0; i < allHorses.length; i++) {
            Horses[] sortedHorses = insertionSort(allHorses[i]);
            allHorses[i] = sortedHorses;
        }

        printallHores(allHorses);
        Horses fastestHorse = allHorses[0][0];
        int numf = 0;
        Horses sefastestHorse = allHorses[0][0];
        int numse = 0;
        Horses thirdFastestHorse = allHorses[0][0];
        int numt = 0;
        for (int j = 1; j < allHorses.length; j++) {
            if (fastestHorse.speed < allHorses[j][0].speed) {
                fastestHorse = allHorses[j][0];
                numf = j;
            } else if (sefastestHorse.speed < allHorses[j][0].speed) {
                sefastestHorse = allHorses[j][0];
                numse = j;
            } else if (thirdFastestHorse.speed < allHorses[j][0].speed) {
                numt = j;
                thirdFastestHorse = allHorses[j][0];
            }
        }

        ArrayList<Horses> Horses = new ArrayList<>();
        Horses.add(allHorses[numf][1]);
        Horses.add(allHorses[numf][2]);
        Horses.add(allHorses[numse][0]);
        Horses.add(allHorses[numse][1]);
        Horses.add(allHorses[numt][0]);
        Horses.sort((h1, h2) -> h2.speed - h1.speed);
        System.out.println("Fastest Horse ID: " + fastestHorse.id + ", Speed: " + fastestHorse.speed);
        System.out.println("Second Fastest Horse ID: " + Horses.get(0).id + ", Speed: " + Horses.get(0).speed);
        System.out.println("Third Fastest Horse ID: " + Horses.get(1).id + ", Speed: " + Horses.get(1).speed);
    }

    public static void printallHores(Horses[][] allHorses) {
        for (int i = 0; i < allHorses.length; i++) {
            for (int j = 0; j < allHorses[i].length; j++) {
                System.out.print("Horse ID: " + allHorses[i][j].id + ", Speed: " + allHorses[i][j].speed + " | ");
            }
            System.out.println();
        }
    }

    public static Horses[] insertionSort(Horses[] horses) {
        for (int i = 1; i < horses.length; i++) {
            Horses key = horses[i];
            int j = i - 1;
            while (j >= 0 && horses[j].speed < key.speed) {
                horses[j + 1] = horses[j];
                j--;
            }
            horses[j + 1] = key;
        }

        return horses;
    }

}