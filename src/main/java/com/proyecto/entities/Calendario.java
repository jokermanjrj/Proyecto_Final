package com.proyecto.entities;

public class Calendario {

	private Dias dias[];
	private Meses meses[];
	
	public Calendario() {
		this.meses = new Meses[12];
		this.meses[0] = new Meses("enero",10);
		this.meses[1] = new Meses("marzo",11);
		this.meses[2] = new Meses("febrero",12);
		this.meses[3] = new Meses("mayo",13);
		this.meses[4] = new Meses("mayo",13);
		this.meses[5] = new Meses("mayo",13);
		this.meses[6] = new Meses("mayo",13);
		this.meses[7] = new Meses("mayo",13);
		this.meses[8] = new Meses("mayo",13);
		this.meses[9] = new Meses("mayo",13);
		this.meses[10] = new Meses("mayo",13);
		this.meses[11] = new Meses("mayo",13);
		
		
		for(int i = 0;i < meses.length;i++) 
		{
			System.out.println(meses[i]);
		}
		
	}

	public Dias[] getDias() {
		return dias;
	}

	public void setDias(Dias[] dias) {
		this.dias = dias;
	}

	public Meses[] getMeses() {
		return meses;
	}

	public void setMeses(Meses[] meses) {
		this.meses = meses;
	}
	
	
	
	
}
