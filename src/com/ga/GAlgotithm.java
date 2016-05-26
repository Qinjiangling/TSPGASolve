package com.ga;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GAlgotithm {
	//�������
	private static final double mutrate = 0.05;
	//�������
	private static final double uniformRate = 1;
	private static final int tournamentSize = 30;
	//��Ⱥ��С
	private static int defaultPopSize = 20;
	
	public static Population evolve(Population oldPop){
		Population newPop = new Population(defaultPopSize, false);
		
		//�������Ÿ���
		newPop.set(0, oldPop.getFittest());
		for(int i = 1; i < defaultPopSize; i++){
			Individual d1 = selectIndividual(oldPop);
			Individual d2 = selectIndividual(oldPop);
			Individual newd = crossover(d1, d2);
			newPop.set(i, newd);
		}
		
		for(int i = 1; i < defaultPopSize; i++){
			mutation(newPop.get(i));
			//������Ӧ��ֵ
			newPop.get(i).calculateFitness();
		}
		
		return newPop;
	}
	//����
	public static void mutation(Individual d){
		//������� ���������������
		if(new Random().nextDouble() < mutrate){
			Random r = new Random();
			int x = r.nextInt(d.getLenth());
			int y;
			do{
				y = r.nextInt(d.getLenth());
			}while(x == y);
			int tmp = d.getGene(x);
			d.setGene(x, d.getGene(y));
			d.setGene(y, tmp);
		}
	}
	
	//������Ⱥ��ģ
	public static void setDefaultPopSize(int size){
		defaultPopSize = size;
	}
	
	// ����
	public static Individual crossover(Individual d1, Individual d2) {
//		if(Math.random() > uniformRate)
//			return d1;
		Individual newd = new Individual();
		int genlen = d1.getLenth();
		int crosslen = genlen / 2;
		
		int sta =  (int)(Math.random()*d1.getLenth()*(1.0/2));
		int len = sta + crosslen;
		for (int i = 0; i < genlen; i++) {
			if (i >= sta && i < len) {
				newd.setGene(i, d2.getGene(i));
			}else{
				newd.setGene(i, d1.getGene(i));
			}
		}
		int[] tmp = new int[genlen];
		for(int i =0 ; i < genlen; i++){
			tmp[newd.getGene(i)]++;
		}
		List<Integer> v1 = new ArrayList<Integer>();
		List<Integer> v2 = new ArrayList<Integer>();
		for(int i = 0; i < genlen; i++){
			if(tmp[i] == 0)
				v1.add(i);
			if(tmp[i] > 1)
				v2.add(i);
		}
		//�г�ͻ
		int v1size = v1.size();
		if(v1size > 0){
			for(int i = 0; i < v1size; i++){
				int gene = v2.get(i);
				for(int j = 0; j < genlen; j++){
					if(newd.getGene(j) == gene){
						newd.setGene(j, v1.get(i));
						break;
					}
				}
			}
		}
		
		return newd;
	}
	
	//ѡ��
	public static Individual selectIndividual(Population pop){
		Population tpop = new Population(tournamentSize, false);
		for(int i = 0; i < tournamentSize; i++){
			int selected = (int)(Math.random()*pop.size());
			tpop.set(i, pop.get(selected));
		}
		
		return tpop.getFittest();
	}
}
