import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Set<NoteBooks> nbs = new HashSet<>();
        ArrayList<NoteBooks> nbs = new ArrayList<>();
        int[] ram = new int[]{2, 4, 8, 16, 32};
        int[] hd = new int[]{128, 256, 512, 1024};
        String[] os = new String[]{"macOS", "Linux", "Windows"};
        String[] casecolour = new String[]{"black", "Silver", "midnight", "space gray", "white"};
        int[] screensize = new int[]{12, 13, 14, 15, 16, 17};

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int ozuI = random.nextInt(0, 5);
            int hdI = random.nextInt(0, 4);
            int osI = random.nextInt(0, 3);
            int colI = random.nextInt(0, 5);
            int scrI = random.nextInt(0, 6);
            NoteBooks nb = new NoteBooks();
            nb.setVRam(ram[ozuI]);
            nb.setVHd(hd[hdI]);
            nb.setVOs(os[osI]);
            nb.setVCol(casecolour[colI]);
            nb.setVScr(screensize[scrI]);
            //System.out.println(nb);
            nbs.add(nb);

        }
        /*
        NoteBooks nb1 = new NoteBooks();
        nb1.ram = 8;
        nb1.hd = 256;
        nb1.os = "Windows";
        nb1.casecolour = "black";
        nb1.screensize = 15;

        NoteBooks nb2 = new NoteBooks();
        nb2.ram = 16;
        nb2.hd = 512;
        nb2.os = "macOS";
        nb2.casecolour = "Silver";
        nb2.screensize = 16;

        NoteBooks nb3 = new NoteBooks();
        nb3.ram = 8;
        nb3.hd = 512;
        nb3.os = "Linux";
        nb3.casecolour = "midnight";
        nb3.screensize = 14;

        NoteBooks nb4 = new NoteBooks();
        nb4.ram = 16;
        nb4.hd = 512;
        nb4.os = "Windows";
        nb4.casecolour = "Silver";
        nb4.screensize = 16;

        NoteBooks nb5 = new NoteBooks();
        nb5.ram = 8;
        nb5.hd = 256;
        nb5.os = "macOS";
        nb5.casecolour = "space gray";
        nb5.screensize = 15;

        NoteBooks nb6 = new NoteBooks();
        nb6.ram = 4;
        nb6.hd = 128;
        nb6.os = "Linux";
        nb6.casecolour = "black";
        nb6.screensize = 14;

        nbs.add(nb1);
        nbs.add(nb2);
        nbs.add(nb3);
        nbs.add(nb4);
        nbs.add(nb5);
        nbs.add(nb6);
        */


        System.out.println();

        int fRam = 0;
        int fHd = 0;
        int fScr = 0;
        int fOs = 0;
        int fCol = 0;
        filterByBook(nbs, os, casecolour, fRam, fHd, fOs, fCol, fScr);
        boolean cycle = true;
        while (cycle) {
            System.out.println("Критерии поиска Ноутбуков");
            System.out.println("1 - ОЗУ: >= " + fRam);
            System.out.println("2 - Объем ЖД: >= " + fHd);
            System.out.println("3 - Операционная система" + fOs);
            System.out.println("4 - Цвет" + fCol);
            System.out.println("5 - Экран: >= " + fScr);
            System.out.println("6 - Ой! Ошибся, мне Ноутбук не нужен!");

            System.out.println("Введите номер критерия: ");

            String number = sc.nextLine();
            System.out.println(number);
            switch (number) {
                case "1" -> {
                    System.out.println("Введите минимальный объем ОЗУ: ");
                    fRam = sc.nextInt();
                    filterByBook(nbs, os, casecolour, fRam, fHd, fOs, fCol, fScr);
                }
                case "2" -> {
                    System.out.println("Введите минимальный объем ЖД: ");
                    fHd = sc.nextInt();
                    filterByBook(nbs, os, casecolour, fRam, fHd, fOs, fCol, fScr);
                }
                case "3" -> {
                    System.out.println("Выберите операционную систему\n" +
                            "1 - macOS\n" +
                            "2 - Linux\n" +
                            "3 - Windows\n" +
                            "0 - Пропустить"
                    );
                    System.out.println("Ведите номер меню");
                    fOs = sc.nextInt();
                    filterByBook(nbs, os, casecolour, fRam, fHd, fOs, fCol, fScr);

                }
                case "4" -> {
                    System.out.println("Выберите цвет\n" +
                            "1 - black\n" +
                            "2 - green\n" +
                            "3 - red\n" +
                            "4 - white\n" +
                            "0 - Пропустить"
                    );
                    System.out.println("Ведите номер меню");
                    fCol = sc.nextInt();
                    filterByBook(nbs, os, casecolour, fRam, fHd, fOs, fCol, fScr);
                }
                case "5" -> {
                    System.out.println("Введите минимальный размер экрана: ");
                    fScr = sc.nextInt();
                    filterByBook(nbs, os, casecolour, fRam, fHd, fOs, fCol, fScr);
                }
                case "6" -> {
                    System.out.println("Бывает " + number);
                    cycle = false;
                    sc.close();
                }
                case null -> {
                    cycle = false;
                    sc.close();
                }
                default -> System.out.println("Ошибка ввода " + number);

            }

        }
    }

    static void printSet(ArrayList<NoteBooks> nbs){
        for (NoteBooks nb: nbs){
            System.out.println(nb);
        }
    }

    static void filterByBook(ArrayList<NoteBooks> nbs, String[] os, String[] casecolour, int fRam, int fHd, int fOs, int fCol, int fScr) {
        String res;
        for (NoteBooks notebook : nbs) {
            if ((fRam <= notebook.getvRam()) &&
                    (fHd <= notebook.getvHd()) &&
                    (fOs != 0 && !os[fOs - 1].equals(notebook.getvOs())) &&
                    (fCol != 0 && !casecolour[fCol - 1].equals(notebook.getvCol())) &&
                    (fScr <= notebook.getvScr())) continue;
            res = notebook.toString();
            System.out.println(res);
        }
        return;
    }
}