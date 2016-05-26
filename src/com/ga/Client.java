package com.ga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void test() {
		for (int i = 0; i < 100; i++) {
			int x = (int) (Math.random() * 100);
			int y = (int) (Math.random() * 100);
			CalFitness.addCity(new City(x, y));
		}
		Individual.setDefaultLength(100);
		GAlgotithm.setDefaultPopSize(50);
		Population pop = new Population(50, true);
		for (int i = 0; i < 1000; i++) {
			pop = GAlgotithm.evolve(pop);
			System.out.println(pop.getFittest().getFitness());
		}
		System.out.println(1/pop.getFittest().getFitness());
	}
	
	public static void test2() throws IOException{
		readData();
		Individual.setDefaultLength(34);
		GAlgotithm.setDefaultPopSize(50);
		Population pop = new Population(50, true);
		for (int i = 0; i < 2000; i++) {
			pop = GAlgotithm.evolve(pop);
			System.out.println("µÚ " + i + "´ú: " + pop.getFittest().getFitness());
		}
		System.out.println(1/pop.getFittest().getFitness());
		System.out.println(pop.getFittest());
	}

	public static void readData() throws IOException {
		InputStreamReader reader = new InputStreamReader(new FileInputStream(
				new File("data.txt")));
		BufferedReader br = new BufferedReader(reader);
		List<String[]> list = new ArrayList<String[]>();
		String tmp = "";
		tmp = br.readLine();
		while(tmp != null){
			list.add(tmp.split(" "));
			tmp = br.readLine();
		}
		
		for(String[] data : list){
			double x = Double.parseDouble(data[2]);
			double y = Double.parseDouble(data[3]);
			CalFitness.addCity(new City(x, y));
		}

	}

	public static void main(String[] args) throws IOException {
		test();
	}

}
