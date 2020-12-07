public class KapuSzkenner {

    public static void main(String[] args) {

        // Megfigyelünk minden 1024-nél kisebb számmal ellátott portot
        // a gépünkön és megállapítjuk róla hogy folyik e rajta
        // listen folyamat vagy sem
        for(int i=0; i<1024; ++i)

            try {
                // megpróbálunk TCP kapcsolatot létesíteni
                java.net.Socket socket = new java.net.Socket(args[0], i);
                // Ha sikerül kiiratjuk hogy sikerült a kapcsolat
                System.out.println(i + " figyeli");
                socket.close();
            } catch (Exception e) {
                // Amennyiben nem sikerül a TCP kapcsolat,
                // a Socket Exception-t dob és kiiratjuk hogy
                // nincs kapcsolat az adott porton
                System.out.println(i + " nem figyeli");
            }
    }

}