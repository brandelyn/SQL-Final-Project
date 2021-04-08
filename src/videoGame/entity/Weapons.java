package videoGame.entity;

public class Weapons {
	
	private int weaponId;
	private String weapon;
	
	public int getWeaponId() {
		return weaponId;
	}
	public String getWeapon() {
		return weapon;
	}
	
	@Override
	public String toString() {
		return "Weapon [weaponId = " + weaponId + ", weapon = " + weapon + "]";
	}


	

}
