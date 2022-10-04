package unlam.classes;

public class Auto {

	public Auto() {
		// TODO Auto-generated constructor stub
	}

	public Auto(String marca, int horsePower) {
		super();
		this.marca = marca;
		this.horsePower = horsePower;
	}

	public String marca;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	private int horsePower;

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	private int degrees;

	public int getDegrees() {
		return degrees;
	}

	private void setDegrees(int degrees) {
		if (degrees > 0) {
			if (this.degrees + degrees > 90) {
				this.degrees = 90;
				System.out.println("Cuidado vas a volcar!!! animalito!!!");
			} else
				this.degrees += degrees;
		} else {
			if (this.degrees + degrees < -90) {
				this.degrees = -90;
				System.out.println("Cuidado vas a volcar!!! animalito!!!");
			} else
				this.degrees += degrees;
		}
	}

	public void turnRight() {
		setDegrees(10);
	}

	public void turnRight(int degress) {
		if (degress > 0)
			setDegrees(degress);
		else
			setDegrees(-degress);
	}

	public void turnLeft() {
		setDegrees(-10);
	}

	public void turnLeft(int degress) {
		if (degress > 0)
			setDegrees(-degress);
		else
			setDegrees(degress);
	}

}
