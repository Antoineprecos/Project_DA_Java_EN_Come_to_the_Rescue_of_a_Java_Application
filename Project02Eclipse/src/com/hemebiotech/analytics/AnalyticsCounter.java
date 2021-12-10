package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;


public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		SymptomReader symptomReader = new SymptomReader();
		Map<String, Integer> symptomes = symptomReader.getSymptoms("symptoms.txt");
		SymptomWriter symptomWriter = new SymptomWriter();
		symptomWriter.ecrireSymptomes(symptomes, "result.out");
	}
}
