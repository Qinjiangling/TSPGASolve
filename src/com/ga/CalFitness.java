package com.ga;

import java.util.ArrayList;
import java.util.List;

public class CalFitness {
	private static List<City> allcity = new ArrayList<City>();

	//计算染色体的适应度
	public static double getFitness(Individual d) {
		int len = d.getLenth();
		double totalDis = 0;
		for (int i = 1; i < len; i++) {
			totalDis += calDis(allcity.get(d.getGene(i - 1)),
					allcity.get(d.getGene(i)));
		}
		totalDis += calDis(allcity.get(d.getGene(0)), allcity.get(d.getGene(len - 1)));
		
		return 1.0/totalDis;
	}

	public static double calDis(City c1, City c2) {
		return Math.sqrt((c1.getX() - c2.getX()) * (c1.getX() - c2.getX())
				+ (c1.getY() - c2.getY()) * (c1.getY() - c2.getY()));
	}
	
	//添加城市
	public static void addCity(City c){
		allcity.add(c);
	}
	
	//
	public static int getCityNum(){
		return allcity.size();
	}
}
