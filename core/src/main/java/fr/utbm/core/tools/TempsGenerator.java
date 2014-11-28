package fr.utbm.core.tools;

import java.util.Random;

/* random temps generator */
public class TempsGenerator {
	
	private Random r = null;
	private float min = (float) -273.15;//Physics limit  = 0°K Absolut  zero 
	private float max = (float) 273 ; //arbitrary value
	
	public TempsGenerator(float min, float max){
		this.min = min;
		this.max = max;
		r = new Random();
	}
		
	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public float generateTemp(){
		return r.nextFloat()*(max-min) + min;
	}

}
