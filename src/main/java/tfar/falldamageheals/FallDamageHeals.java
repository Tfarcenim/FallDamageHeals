package tfar.falldamageheals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FallDamageHeals.MODID)
public class FallDamageHeals {
    // Directly reference a log4j logger.

    public static final String MODID = "falldamageheals";

    public FallDamageHeals() {
        // Register the setup method for modloading
        MinecraftForge.EVENT_BUS.addListener(this::fall);
    }

    private void fall(final LivingHurtEvent event) {
        DamageSource source = event.getSource();
        LivingEntity target  = event.getEntityLiving();
        if (target instanceof PlayerEntity && source == DamageSource.FALL) {
            event.setCanceled(true);
            target.heal(event.getAmount());
        }
    }
}
