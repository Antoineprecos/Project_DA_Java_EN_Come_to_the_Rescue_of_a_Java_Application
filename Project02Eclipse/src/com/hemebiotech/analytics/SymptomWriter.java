package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;

public class SymptomWriter {

    /**
     * Ecrit les symptomes dans un fichier de sortie
     * @param symptomes Les symptomes à écrire
     * @param nomDuFichier Le nom du fichier de sortie à créer
     */
    public void ecrireSymptomes(Map<String, Integer> symptomes, String nomDuFichier) throws Exception {
        FileWriter fichierResultat = new FileWriter(nomDuFichier);
        Iterator<String> i = symptomes.keySet().iterator();
        while (i.hasNext()) {
            String symptome = i.next();
            int compteur = symptomes.get(symptome);
            fichierResultat.write(symptome + " " + compteur + "\n");
        }
        fichierResultat.close();
    }
}