package doctor4t.ratsmischief.common.enchantments;

import doctor4t.ratsmischief.common.init.ModEnchantments;
import doctor4t.ratsmischief.common.item.RatMasterArmorItem;
import doctor4t.ratsmischief.common.item.RatMasterMaskItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class RatCurseEnchantment extends Enchantment {
	public RatCurseEnchantment(Enchantment.Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.WEARABLE, slotTypes);
	}

	public static float getEquippedPieces(LivingEntity user) {
		if (user != null) {
			int equipped = 0;
			for (EquipmentSlot slot : RatMasterArmorItem.SLOTS) {
				equipped += EnchantmentHelper.getLevel(ModEnchantments.RAT_CURSE, user.getEquippedStack(slot));
			}
			return equipped;
		}
		return 0;
	}

	@Override
	public int getMinPower(int level) {
		return 25;
	}

	@Override
	public int getMaxPower(int level) {
		return 50;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof RatMasterArmorItem || stack.getItem() instanceof RatMasterMaskItem;
	}

	@Override
	public boolean isTreasure() {
		return true;
	}

	@Override
	public boolean isCursed() {
		return true;
	}
}