package videoGame.entity;

public class Abilities {
	
	private int abilityId;
	private String ability;
	
	public int getAbilityId() {
		return abilityId;
	}
	public String getAbility() {
		return ability;
	}
	@Override
	public String toString() {
		return "Weapon [abilityId = " + abilityId + ", ability = " + ability + "]";
	}


}
