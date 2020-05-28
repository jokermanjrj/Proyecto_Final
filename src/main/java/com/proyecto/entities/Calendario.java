package com.proyecto.entities;

public class Calendario {

	private Dias dias[];
	private Meses meses[];
	
	public Calendario() {
		this.dias = new Dias[366];
		this.meses = new Meses[12];
		this.meses[0] = new Meses("enero",31,1);
		this.meses[1] = new Meses("febrero",29,2);
		this.meses[2] = new Meses("marzo",31,3);
		this.meses[3] = new Meses("abril",30,4);
		this.meses[4] = new Meses("mayo",31,5);
		this.meses[5] = new Meses("junio",30,6);
		this.meses[6] = new Meses("julio",31,7);
		this.meses[7] = new Meses("agosto",31,8);
		this.meses[8] = new Meses("septiembre",30,9);
		this.meses[9] = new Meses("octubre",31,10);
		this.meses[10] = new Meses("noviembre",30,11);
		this.meses[11] = new Meses("diciembre",31,12);
		System.out.println(meses[1].getDias());
		int di = 0;
		
		for(int i = 0;i < meses.length;i++) 
		{
			for(int z = 0;z < meses[i].getDias();z++) 
			{
				dias[di] = new Dias(z,i,2020);
				di++;
			}
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
