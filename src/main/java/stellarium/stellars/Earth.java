package stellarium.stellars;

import sciapi.api.value.IValRef;
import sciapi.api.value.euclidian.EVector;
import stellarium.util.math.Transforms;
import stellarium.util.math.VecMath;

public class Earth extends Planet {
	
	final double MvsE=0.0121505;
	
	//Get Ecliptic Position EVectortor from Sun
	
	public IValRef<EVector> GetEcRPos(double yr) {
		this.satellites.get(0).EcRPosE.set(((Moon)this.satellites.get(0)).GetEcRPosE(yr));
		return VecMath.sub(super.GetEcRPos(yr), VecMath.mult(MvsE, this.satellites.get(0).EcRPosE));
	}
	
	//Update Earth(Have to be first)
	public void Update(){
		EcRPos.set(GetEcRPos(Transforms.yr));
		this.satellites.get(0).Update();
	}
	
}
