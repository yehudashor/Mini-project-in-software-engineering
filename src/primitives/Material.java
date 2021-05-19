/**
 * 
 */
package primitives;

/**
 * Represent material
 * 
 * @authors Yehuda Shor 20761055 yehudashor789@gmail.com
 * @authors Israel Cohen 203250170 josh50170@gmail.com
 */
public class Material {
	/**
	 * kD, kS, kT, kR
	 */
	public double kD = 0.0, kS = 0.0, kT = 0.0, kR = 0.0;

	/**
	 * enShinines
	 */
	public int enShininess = 0;

	/**
	 * @param kT the kT to set
	 */
	public Material setkT(double kT) {
		this.kT = kT;
		return this;
	}


	/**
	 * @param kR the kR to set
	 */
	public Material setkR(double kR) {
		this.kR = kR;
		return this;
	}

	/**
	 * set kD
	 * 
	 * @param kD the kD to set
	 * @return this
	 */
	public Material setKd(double kD) {
		this.kD = kD;
		return this;
	}

	/**
	 * set kS
	 * 
	 * @param kS the kS to set
	 * @return this
	 */
	public Material setKs(double kS) {
		this.kS = kS;
		return this;
	}

	/**
	 * set enShinines
	 * 
	 * @param enShinines the enShinines to set
	 * @return this
	 */
	public Material setEnShininess(int enShinines) {
		this.enShininess = enShinines;
		return this;
	}

}
