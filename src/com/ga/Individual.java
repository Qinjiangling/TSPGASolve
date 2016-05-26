package com.ga;

import java.util.Random;

public class Individual {
	//默认编码长度
	private static int defaultLength = 10;
	
	//编码
	private int[] genes  = new int[defaultLength];
	
	//适应度值
	private double fitness = 0;
	
	//修改默认长度
	public static void setDefaultLength(int length){
		defaultLength = length;
	}
	
	//随机生成个体
	public void generateIndivadual(){
		Random r = new Random();
		for(int i = 0; i < defaultLength; i++){
			genes[i] = i;
		}
		//随机交换100次
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
	
	//获取适应度值
	public double getFitness(){
		if(fitness == 0)
			calculateFitness();
		return fitness;
	}
	
	//计算适应度值
	public void calculateFitness(){
		fitness = CalFitness.getFitness(this);
	}
	
	public int getGene(int i){
		return genes[i];
	}
	
	public void setGene(int i, int gene){
		genes[i] = gene;
	}
	
	//获得编码长度
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
