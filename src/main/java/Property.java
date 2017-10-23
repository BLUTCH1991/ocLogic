import java.io.*;
import java.util.Properties;


public class Property extends Game {

    public static int nbSizeMol = 0;
    public static int nbSizeMd = 0;
    public static int nbTryMol = 0;
    public static int nbTryMd = 0;
    public static String devMode = "";
    public static int nbDifferentDigit = 0;

    public void initProperties() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("./src/main/ressources/config.properties");
            prop.load(input);

            nbSizeMol = Integer.valueOf(prop.getProperty("nbSizeMol"));
            nbSizeMd = Integer.valueOf(prop.getProperty("nbSizeMd"));
            nbTryMol = Integer.valueOf(prop.getProperty("nbTryMol"));
            nbTryMd = Integer.valueOf(prop.getProperty("nbTryMd"));
            nbDifferentDigit = Integer.valueOf(prop.getProperty("nbDifferentDigit"));
            devMode = prop.getProperty("devMode");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setOneProperty(String key, String value) {
        try {
            Properties pop = new Properties();
            pop.load(new FileInputStream("./src/main/ressources/config.properties"));
            pop.put(key, value);
            FileOutputStream output = new FileOutputStream("./src/main/ressources/config.properties");
            pop.store(output, "");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void getAllProperties() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("./src/main/ressources/config.properties");
            prop.load(input);

            System.out.println("\n- MASTERMIND -");
            System.out.println("1) Nombre d'essais : " + prop.getProperty("nbTryMd"));
            System.out.println("2) Nombre de chiffres de la combinaison : " + prop.getProperty("nbSizeMd"));
            System.out.println("3) Nombre de chiffres utilisables : " + prop.getProperty("nbDifferentDigit") + "\n");
            System.out.println("- PLUS OU MOINS -");
            System.out.println("4) Nombre d'essais : " + prop.getProperty("nbTryMol"));
            System.out.println("5) Nombre de chiffres de la combinaison : " +  prop.getProperty("nbSizeMol") + "\n");
            System.out.println("6) Quitter le fichier de configuration\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}