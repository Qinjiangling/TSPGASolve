package com.ga;

public class Population {
	Individual[] individuals;

	public Population(int size, boolean isInit) {
		individuals = new Individual[size];
		Individual tmp;
		if (isInit) {
			for (int i = 0; i < size; i++) {
				tmp = new Individual();
				tmp.generateIndivadual();
				individuals[i] = tmp;
			}
		}
	}

	// get
	public Individual get(int i) {
		return individuals[i];
	}

	// 获取最大适应度值个体
	public Individual getFittest() {
		int len = size();
		Individual fittest = individuals[0];
		// Loop through individuals to find fittest
		for (int i = 0; i < len; i++) {
			if (fittest.getFitness() <= get(i).getFitness()) {
				fittest = get(i);
			}
		}

		return fittest;
	}

	// size
	public int size() {
		return individuals.length;
	}

	// set
	public void set(int i, Individual n) {
		individuals[i] = n;
	}
}
