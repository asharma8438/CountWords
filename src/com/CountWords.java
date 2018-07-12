package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountWords {

	public static void main(String args[]){

		//Input text or csv file with words
		String fileName = "D://Ashish//Eclipse_new_workspace//Test//csvv.csv";
		String TOKEN = ",";

		//constant variables
		int count = 5; // Character length
		String lower = "m";
		String upper = "M";

		List<String> letterList = new ArrayList<String>();
		List<String> countList = new ArrayList<String>();

		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {

			List<List<String>> rows = lines.map(line -> Arrays.asList(line.split(TOKEN))).collect(Collectors.toList());

			rows.forEach(names -> {

				names.forEach(name -> {

					for(String word : name.split(" ")){

						//add the word to countList if its length > count
						if(word.length()>count){
							countList.add(word);
						}

						//add the word to letterList if matches the Letter
						if(word.startsWith(lower) || word.startsWith(upper)){
							letterList.add(word);
						}
					}
				});
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Number of words that start with '"+lower+"' or '"+upper+"' = "+letterList.size());
		System.out.println("Below are the words longer than "+count+" characters:");
		countList.forEach(System.out::println);
	}
}
