package mod.whiter.template.locale;

import net.minecraft.util.ResourceLocation;
import static mod.whiter.template.App.modid;


public class Local {
    public static ResourceLocation localname(String key) {
        return new ResourceLocation(modid, key);
    }
}
