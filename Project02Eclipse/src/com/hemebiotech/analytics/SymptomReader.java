package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SymptomReader {

    public Map<String, Integer> getSymptoms(String nomDufichier) throws Exception {
        BufferedReader reader = chargerFichier(nomDufichier);
        List<String> symptomesBrut = recupererSymptomes(reader);
        Map<String, Integer> symptomes = organiserSymptomes(symptomesBrut);
        return symptomes;
    }

    /**
     * Ecrire les symptomes dans un fichier de sortie

     * @return  nomDuFichier le nom du fichier de sortie de creer
     */
    private BufferedReader chargerFichier(String nomDuFichier) throws FileNotFoundException {
        FileReader fichierCree = new FileReader(nomDuFichier);
        BufferedReader reader = new BufferedReader(fichierCree);
        return reader;
    }

    /**
     * Recupere les symptomes dans un fichier
     * @param donnees le fichier contenant les symptomes
     * @return Une liste contenant tous les symptomes du fichier
     */
    private List<String> recupererSymptomes(BufferedReader donnees) throws Exception {
        String ligneDuFichier;
        List<String> symptomes = new ArrayList<>();
        while((ligneDuFichier = donnees.readLine()) != null){
            symptomes.add(ligneDuFichier);
        }
        return symptomes;
    }

    /**
     * Trie les symptomes par ordre alphabétique, élimine les doublons en
     * décomptant chaque occurence
     * @param symptomes la liste brute des symptomes
     * @return Une map dont chaque clé est un symptome et chaque valeur son décompte
     */
    private Map<String, Integer> organiserSymptomes(List<String> symptomes) {
        Map<String,Integer> dossier = new TreeMap<String, Integer>();

        for(String symptome:symptomes) {
            if (dossier.containsKey(symptome)) {
                int decompteActuel = dossier.get(symptome);
                dossier.put(symptome, decompteActuel + 1);
            } else {
                dossier.put(symptome, 1);
            }
        }
        return dossier;
    }
}