package com.ga;

import java.util.Random;

public class Individual {
	//Ĭ�ϱ��볤��
	private static int defaultLength = 10;
	
	//����
	private int[] genes  = new int[defaultLength];
	
	//��Ӧ��ֵ
	private double fitness = 0;
	
	//�޸�Ĭ�ϳ���
	public static void setDefaultLength(int length){
		defaultLength = length;
	}
	
	//������ɸ���
	public void generateIndivadual(){
		Random r = new Random();
		for(int i = 0; i < defaultLength; i++){
			genes[i] = i;
		}
		//�������100��
		for(int i = 0; i < 100; i++){
			int x = r.nextInt(defaultLength);
			int y;
			do{
				y = r.nextInt(defaultLength);
			}while(x == y);
			int tmp = genes[x];
			genes[x] = genes[y];
			genes[y] = tmp;
		}
	}
	
	//��ȡ��Ӧ��ֵ
	public double getFitness(){
		if(fitness == 0)
			calculateFitness();
		return fitness;
	}
	
	//������Ӧ��ֵ
	public void calculateFitness(){
		fitness = CalFitness.getFitness(this);
	}
	
	public int getGene(int i){
		return genes[i];
	}
	
	public void setGene(int i, int gene){
		genes[i] = gene;
	}
	
	//��ñ��볤��
	public int getLenth(){
		return defaultLength;
	}
	
	public String toString(){
		StringBuilder ret = new StringBuilder("[");
		for(int i = 0 ; i < defaultLength; i++){
			ret.append(" ");
			ret.append(genes[i]);
		}
		ret.append("]");
		
		return ret.toString();
	}
	
//	//test
//	public static void main(String[] args){
//		Individual test = new Individual();
//		test.generateIndivadual();
//		System.out.println(test);
//	}
}
